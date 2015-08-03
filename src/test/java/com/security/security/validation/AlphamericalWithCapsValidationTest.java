package com.security.security.validation;

import com.secume.security.validation.AlphamericalWithCapsValidation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Hadi on 8/2/15.
 */
public class AlphamericalWithCapsValidationTest {

    @Test
    public void testValidation() {
        AlphamericalWithCapsValidation av = new AlphamericalWithCapsValidation();

        Assert.assertFalse(av.isValid(null));
        Assert.assertFalse(av.isValid("aaaa"));
        Assert.assertFalse(av.isValid("AAAA"));
        Assert.assertFalse(av.isValid("1111"));
        Assert.assertFalse(av.isValid("AaAa"));
        Assert.assertFalse(av.isValid("A1A1"));
        Assert.assertFalse(av.isValid("a1a1"));

        Assert.assertTrue(av.isValid("a1A1"));

    }
}
