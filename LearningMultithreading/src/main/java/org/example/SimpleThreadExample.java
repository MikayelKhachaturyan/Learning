package org.example;

public class SimpleThreadExample {
    public static void main(String[] args) {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printThreadInfo();
            }
        }) ;

        myThread.setName("New Worker Thread");
        myThread.setPriority(Thread.MAX_PRIORITY);

        printThreadInfo();
        myThread.start();
        printThreadInfo();
    }

    public static void printThreadInfo() {
        System.out.printf("Currently in thread: %s, priority: %s \n", Thread.currentThread().getName(), Thread.currentThread().getPriority());
    }
}