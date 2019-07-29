package com.example.email_tin_services.model;

import java.util.Random;

/**
 *
 * @author E238958
 */
public class TINGenerator {

    private static String TIN = "NGRLAG";

    private TINGenerator() {
    }

    public static String getTaxIdentificationNumber() {
        if (TIN.length() <= 6) {
            TINGenerator tinGen = new TINGenerator();
            return tinGen.getTIN();
        }
        return TIN;
    }

    private String getTIN() {
        TIN += generateRandomNumber();
        return TIN;
    }
    
    private String generateRandomNumber() {
        Random random = new Random();
        String numStr = "";
        for (int i = 0; i < 5; i++) {
            numStr += random.nextInt(9) + 1;
        }
        return numStr;
    }
    
    @Override
    public String toString() {
        return "Tax Generator{" + '}';
    }
}
