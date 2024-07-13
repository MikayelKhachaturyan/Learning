package org.example.join;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long[] numbers = {100000, 5, 13, 15, 244, 355};
        List<FactorialThread> factorialThreads = new ArrayList();

        for(int i = 0; i < numbers.length; i++) {
            factorialThreads.add(new FactorialThread(numbers[i]));
        }

        for(Thread t : factorialThreads) {
            t.start();
        }


        while(!factorialThreads.isEmpty()) {
            for (Thread t : factorialThreads) {
                try {
                    t.join(2000);
                } catch (InterruptedException e) {

                }
            }

            Iterator<FactorialThread> i = factorialThreads.iterator();
            while(i.hasNext()) {
                FactorialThread ft = i.next();
                if(ft.isFinished()) {
                    System.out.println("factorial of " + ft.getN() + " is " + ft.getResult());
                    i.remove();
                }
            }
        }

    }
}
