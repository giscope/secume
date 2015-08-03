import com.secume.security.FullValidation;
import com.secume.security.validation.AlphamericalWithCapsValidation;
import com.secume.security.validation.LengthValidation;
import com.secume.security.validation.SequenceValidation;
import com.secume.security.validation.Validation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Hadi on 8/2/15.
 */
public class FullValidationTest {

    Validation alpha = new AlphamericalWithCapsValidation();
    Validation length = new LengthValidation();
    Validation sequence = new SequenceValidation();

    FullValidation fv;

    @Before
    public void before() {
        fv = new FullValidation(Arrays.asList(alpha, length, sequence));
    }

    @Test
    public void testValidation() {
        Assert.assertNotNull(fv.validate("abcdABCD1"));
        Assert.assertArrayEquals(new String[]{"OK"}, fv.validate("abcdABCD1").toArray());

        //null password
        String[] actual = fv.validate(null).stream().sorted().toArray(String[]::new);
        String[] expected = Arrays.asList(length.getError(), alpha.getError(), sequence.getError()).stream().sorted().toArray(String[]::new);
        Assert.assertArrayEquals(expected, actual);

        //length
        Assert.assertArrayEquals(new String[]{length.getError()}, fv.validate("aSk4").toArray());
        Assert.assertArrayEquals(new String[]{length.getError()}, fv.validate("pasSwordDoesntmakesense1").toArray());

        //alphanumerical with capital keys
        Assert.assertArrayEquals(new String[]{alpha.getError()}, fv.validate("abcdABCD").toArray());
        Assert.assertArrayEquals(new String[]{alpha.getError()}, fv.validate("abcd1").toArray());

        //sequence
        Assert.assertArrayEquals(new String[]{sequence.getError()}, fv.validate("abcdabcdA2").toArray());
        Assert.assertArrayEquals(new String[]{sequence.getError()}, fv.validate("ABC122de").toArray());
    }

}
