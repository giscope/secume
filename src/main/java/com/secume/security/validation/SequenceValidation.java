package com.secume.security.validation;

/**
 * Created by Hadi on 8/2/15.
 */
public class SequenceValidation implements Validation {

    final static String error = "Must not contain any sequence of characters immediately followed by the\n" +
            "same sequence";

    @Override
    public boolean isValid(String password) {
        if (null == password) {
            return false;
        }

        for (int l = 1; l <= password.length() / 2; l++) {
            for (int i = 0; i <= password.length()-2 * l; i++) {
                String a = password.substring(i, i + l);
                String b = password.substring(i + l, i + 2 * l);
                if (a.equals(b)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String getError() {
        return error;
    }
}
