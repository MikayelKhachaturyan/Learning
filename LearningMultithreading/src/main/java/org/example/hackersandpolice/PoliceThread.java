package org.example.hackersandpolice;

public class PoliceThread extends Thread {
    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                sleep(1000);
            }
            catch (InterruptedException e) {

            }
        }
        System.out.println("Hackers caught, GAME OVER!!!");
        System.exit(0);
    }
}
