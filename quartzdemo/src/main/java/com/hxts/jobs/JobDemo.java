package com.hxts.jobs;

import java.util.Date;

/**
 * 自定义Job
 */
public class JobDemo {
    public void run() {
        System.out.println("job execute..." + new Date());
    }
}