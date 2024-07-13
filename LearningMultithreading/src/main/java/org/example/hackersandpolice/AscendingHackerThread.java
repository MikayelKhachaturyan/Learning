package org.example.hackersandpolice;

public class AscendingHackerThread extends HackerThread {
    private final int maxValue;

    AscendingHackerThread(Vault vault, int maxValue) {
        super(vault);
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        for(int i = 0; i < this.maxValue; i++) {
            try {
                sleep(5);
            }
            catch (InterruptedException e) {

            }
            if(this.vault.tryPass(i)) {
                System.out.printf("Hacker Thread: %s, hacked the password, it is %d !!! \n", this.getName(), i);
                System.exit(0);
            };
        }
    }
}
