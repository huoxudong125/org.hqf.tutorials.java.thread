package org.hqf.tutorials.java.thread.threadPool;

import jdk.Exported;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadDemoTest {

    ThreadDemo threadDemo;

    @Before
    public void setUp() throws Exception {
        threadDemo = new ThreadDemo();
    }

    @Test
    public void getThredResultByFuture() {
    }

    @Test(expected = ArithmeticException.class)
    public void throwException() {
        threadDemo.throwException();
    }


}