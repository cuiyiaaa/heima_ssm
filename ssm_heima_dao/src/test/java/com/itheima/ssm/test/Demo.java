package com.itheima.ssm.test;

import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.mapper.DemoMapper;
import com.itheima.ssm.mapper.OrdersMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.image.Kernel;
import java.util.*;

public class Demo {

    @Test
    public void test() {
        long begin = System.currentTimeMillis();

        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        DemoMapper mapper = context.getBean(DemoMapper.class);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 499; i++) {
            list.add("BC" + i);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("ids", list);
        map.put("name", "测试");

        mapper.add(map);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    @Test
    public void test2() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        DemoMapper mapper = context.getBean(DemoMapper.class);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("MN" + i);
        }

        long begin = System.currentTimeMillis();
        mapper.save("测试", list);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    @Test
    public void test3() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        DemoMapper mapper = context.getBean(DemoMapper.class);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("io" + i);
        }

        long begin = System.currentTimeMillis();
        mapper.saveDemo(list);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    @Test
    public void test4() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        DemoMapper mapper = context.getBean(DemoMapper.class);

        String[] strs = new String[1000];
        for (int i = 0; i < 1000; i++) {
            strs[i] = "KL" + i;
        }

        long begin = System.currentTimeMillis();
        mapper.saveDemo2(strs);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
