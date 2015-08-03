package com.security.security.validation;

import com.secume.security.validation.SequenceValidation;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.stereotype.Component;

/**
 * Created by Hadi on 8/2/15.
 */
@Component
public class SequenceValidationTest {

    @Test
    public void testValidation() {
        SequenceValidation sv = new SequenceValidation();

        Assert.assertFalse(sv.isValid(null));
        Assert.assertFalse(sv.isValid("aa"));
        Assert.assertFalse(sv.isValid("abab"));
        Assert.assertFalse(sv.isValid("abcabc"));
        Assert.assertFalse(sv.isValid("acbacba"));

        Assert.assertTrue(sv.isValid("abcab"));
        Assert.assertTrue(sv.isValid("acbacd"));
    }
}
