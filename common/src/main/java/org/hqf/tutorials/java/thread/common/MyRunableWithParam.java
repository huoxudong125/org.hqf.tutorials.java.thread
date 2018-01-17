package org.hqf.tutorials.java.thread.common;

import org.hqf.tutorials.java.po.Data;

public class MyRunableWithParam implements  Runnable {

    Data data;

    public MyRunableWithParam(Data name) {
        this.data = name;
    }

    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("线程  执行:");
            data.setName("新名字");
            data.setSex("新性别");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
