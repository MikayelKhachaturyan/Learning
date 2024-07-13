package org.example.hackersandpolice;

public class DescendingHackerThread extends HackerThread{
    private final int maxValue;

    DescendingHackerThread(Vault vault, int maxValue) {
        super(vault);
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        for(int i = this.maxValue; i > 0; i--) {
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
