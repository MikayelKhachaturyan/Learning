package org.example.interrupt;

import java.math.BigInteger;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new PowerTask(new BigInteger("100000"), new BigInteger("200000000")));

        t.setDaemon(true);
        t.start();

        System.out.println("finishing main thread");
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(100000);
            }
            catch (InterruptedException ex) {
                System.out.println("BlockingThread interrupted");
            }

        }
    }

    private static class PowerTask implements Runnable {
        private final BigInteger base;
        private final BigInteger power;

        public PowerTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
           System.out.println(base + "^" + power + "=" + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger pow) {
            BigInteger result = BigInteger.ONE;
            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) < 0; i = i.add(BigInteger.ONE)) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("PowerTask interrupted prematurely");
                    return BigInteger.ZERO;
                }
                pow = pow.multiply(base);
            }

            return result;
        }
    }
}
