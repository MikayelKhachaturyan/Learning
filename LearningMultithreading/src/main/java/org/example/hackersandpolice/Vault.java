package org.example.hackersandpolice;

public class Vault {
    private final int password;

    public Vault(int password){
        this.password = password;
    }

    public boolean tryPass(int password) {
        return this.password == password;
    }
}
