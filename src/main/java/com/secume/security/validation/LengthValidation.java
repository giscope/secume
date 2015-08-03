package com.secume.security.validation;

import org.springframework.stereotype.Component;

/**
 * Created by Hadi on 8/2/15.
 */
@Component
public class LengthValidation implements Validation {

    final String error = "must be between 5 and 12 characters in length";

    @Override
    public boolean isValid(String password) {
        return null!= password && password.length()>4 && password.length()<15;
    }

    @Override
    public String getError() {
        return error;
    }

}
