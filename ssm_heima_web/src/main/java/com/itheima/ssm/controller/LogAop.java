package com.itheima.ssm.controller;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;

    //访问的开始时间
    private Date visitTime;
    //访问的类
    private Class clazz;
    //访问的方法
    private Method method;

    //拦截所有controller下的方法
    @Pointcut("execution(* com.itheima.ssm.controller.*.*(..))")
    public void txPoint() {
    }

    //前置通知：主要用于获取开始执行的时间，执行的类时哪一个，执行的是哪一个方法
    @Before("txPoint()")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        //获取开始时间，当前时间就是开始时间
        visitTime = new Date();
        //获取访问的类
        clazz = jp.getTarget().getClass();

        //获取当前访问方法的名字
        String methodName = jp.getSignature().getName();

        Object[] args = jp.getArgs();
        //获取具体访问的方法
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName);
        } else {
            //根据args构造一个Class数组，因为getMethod第二个参数需要一个Class数组

            Class[] classArgs = new Class[args.length];
            //拷贝数组
            //System.arraycopy(args, 0, classArgs, 0, args.length);
            for (int i = 0; i < args.length; i++) {

                //Class<?>[] interfaces = args[i].getClass().getInterfaces();
                //if (interfaces != null) {
                //    for (Class<?> anInterface : interfaces) {
                //        System.out.println(anInterface);
                //    }
                //}

                if (args[i].getClass() == BindingAwareModelMap.class) {
                    classArgs[i] = Model.class;
                    continue;
                }
                classArgs[i] = args[i].getClass();
            }
            method = clazz.getMethod(methodName, classArgs);
        }
    }

    //最终通知
    @After("txPoint()")
    public void doAfter(JoinPoint jp) throws Exception {
        //获取访问的时长
        long executionTime = System.currentTimeMillis() - visitTime.getTime();

        //获取访问的URL
        String url = "";

        if (method != null && clazz != LogAop.class) {
            ////获取类上的URL
            //RequestMapping clazzAnnotation = (RequestMapping) clazz.getDeclaredAnnotation(RequestMapping.class);
            //if (clazzAnnotation != null) {
            //    url = clazzAnnotation.value()[0];
            //}
            //
            ////获取方法上的URL
            //RequestMapping methodAnnotation = (RequestMapping) method.getDeclaredAnnotation(RequestMapping.class);
            //if (methodAnnotation != null) {
            //    url += methodAnnotation.value()[0];
            //}

            //直接使用request获取
            String uri = request.getRequestURI();

            //获取访问的IP地址
            System.out.println("IP地址" + request.getRemoteAddr());

            //获取当前的操作者,可以使用SecurityContext获取，也可以使用request.getSession中获取
            SecurityContext context = SecurityContextHolder.getContext();
            UserDetails userDetails = (UserDetails) context.getAuthentication().getPrincipal();

            Object username = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
            //将日志信息封装的到SysLog对象中
            SysLog sysLog = new SysLog();

            sysLog.setVisitTime(visitTime);
            sysLog.setExecutionTime(executionTime);
            sysLog.setUrl(uri);
            sysLog.setIp(request.getRemoteAddr());
            sysLog.setUsername(userDetails.getUsername());
            sysLog.setMethod("[类名]：" + clazz.getName() + ";[方法名]：" + method.getName());

            //保存日志信息
            sysLogService.saveSysLog(sysLog);
        }
    }

}
