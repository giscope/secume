package com.secume.security.validation;

/**
 * Created by Hadi on 8/2/15.
 */
public interface Validation {
    boolean isValid(String password);

    String getError();
}
