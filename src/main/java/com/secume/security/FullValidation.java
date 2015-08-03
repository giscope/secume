package com.secume.security;

import com.secume.security.validation.Validation;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Hadi on 8/2/15.
 */
@Component
public class FullValidation {

    @Resource
    List<Validation> validations;

    public FullValidation(List<Validation> validations) {
        this.validations = validations;
    }


    public Set<String> validate(String password) {
        Set<String> status = new HashSet<>();

        for (Validation step : validations) {
            if (!step.isValid(password)) {
                status.add(step.getError());
            }
        }

        if (status.isEmpty()) {
            status.add("OK");
        }

        return status;
    }


}
