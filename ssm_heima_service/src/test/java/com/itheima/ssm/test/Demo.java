package com.itheima.ssm.test;

import com.itheima.ssm.utils.BCryptPasswordEncoderUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class Demo {

    @Test
    public void test1() {
        String passWord = "123456";
        String s = BCryptPasswordEncoderUtils.encodePassWord(passWord);
        //$2a$10$F7osgFOGkdVBD4imCPq9eOxLsCI32k9ZPfgPxocVnrDefgZPfwlRa
        //$2a$10$CT6.KCP1PSq.WiDm8LfDxOtlA4cpPg3tkrYnqdcm85SYkpKSUCOuq
        //$2a$10$ZZ7n/SyCSQUROUnS.UQJkuseYjMbZ4/R7tAbo2FpySYKuCCMYMy8G
        System.out.println(s);
    }


    @Test
    public void test() throws Exception  {

    }
}
