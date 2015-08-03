package com.secume.security.validation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Hadi on 8/2/15.
 */
@Component
public class AlphamericalWithCapsValidation implements Validation {

    final String error = "Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.";

    @Override
    public boolean isValid(String password) {
        return StringUtils.isAlphanumeric(password)
                && StringUtils.containsAny(password, "abcdefghijklmnopqrstuvwxyz")
                && StringUtils.containsAny(password, "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
                && StringUtils.containsAny(password, "0123456789");
    }

    @Override
    public String getError() {
        return error;
    }
}
