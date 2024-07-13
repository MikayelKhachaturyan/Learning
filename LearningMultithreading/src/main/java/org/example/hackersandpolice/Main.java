package org.example.hackersandpolice;

import java.util.Random;

public class Main {
    public static int MAX_PASSWORD_VALUE = 9999;
    public static void main(String[] args) {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD_VALUE));

        Thread[] threds = {new AscendingHackerThread(vault, MAX_PASSWORD_VALUE),
                new DescendingHackerThread(vault, MAX_PASSWORD_VALUE), new PoliceThread()};

        for (Thread t : threds) {
            t.start();
        }
    }
}
