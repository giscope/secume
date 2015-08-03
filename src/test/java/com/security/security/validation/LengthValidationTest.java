package com.security.security.validation;

import com.secume.security.validation.LengthValidation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Hadi on 8/2/15.
 */
public class LengthValidationTest {

    @Test
    public void testValidation() {
        LengthValidation lv = new LengthValidation();

        Assert.assertFalse(lv.isValid(null));
        Assert.assertFalse(lv.isValid("less"));
        Assert.assertFalse(lv.isValid("moremoremoremoremore"));
        Assert.assertTrue(lv.isValid("justenough"));
    }

}
