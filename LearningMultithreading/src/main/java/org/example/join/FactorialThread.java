package org.example.join;

import java.math.BigInteger;

public class FactorialThread extends Thread {
    private final long n;
    private BigInteger factorial;
    private boolean isFinished;

    public FactorialThread(long n) {
        this.n = n;
        this.isFinished = false;
    }

    @Override
    public void run() {
        computeFactorial();
        isFinished = true;
    }

    public BigInteger getResult() {
        return factorial;
    }

    public long getN() {
        return n;
    }

    public boolean isFinished() {
        return isFinished;
    }

    private void computeFactorial() {
        factorial = BigInteger.ONE;
        for(int i = 1; i <=n; i++) {
            factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
        }
    }
}
