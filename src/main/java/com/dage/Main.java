package com.dage;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 创建一个 Spring 应用上下文
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 从上下文中获取 bean 并使用它（仅作为示例）
        // MyBean myBean = context.getBean(MyBean.class);
        // myBean.doSomething();

        // 关闭上下文
//        context.close();
    }
}