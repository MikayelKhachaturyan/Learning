package org.example;

public class ThreadUncaughtException {
    public static void main(String[] args) {
        Thread exceptionThread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Runtime error");
            }
        });

        exceptionThread.setName("Exception thread");
        exceptionThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.printf("In thread: %s exception occurred: %s \n", t.getName(), e.getMessage());
            }
        });

        exceptionThread.start();
    }
}
