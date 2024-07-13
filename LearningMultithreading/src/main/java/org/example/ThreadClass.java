package org.example;

public class ThreadClass {
    public static void main(String[] arg) {
        Thread myThread = new MyThread();
        myThread.start();
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.printf("Hello from thread: %s", this.getName());
        }
    }
}
