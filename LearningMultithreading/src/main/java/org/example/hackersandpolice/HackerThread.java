package org.example.hackersandpolice;

public abstract class HackerThread extends Thread {
    protected final Vault vault;

    HackerThread(Vault vault) {
        this.vault = vault;
        this.setName(this.getClass().getName());
    }

    @Override
    public void start() {
        System.out.printf("Hacker Thread: %s started hacking \n" , this.getName());
        super.start();
    }
}
