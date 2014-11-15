package wacc23;

import org.junit.Test;
import wacc23.utils.RepeatString;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RepeatStringTest {

    @Test
    public void TestRepeatStringRepeatsStrings() {
        String testStr = RepeatString.repeatString("foo", 3);
        assertThat(testStr, is("foofoofoo"));
        testStr = RepeatString.repeatString("boo", 0);
        assertThat(testStr, is(""));
    }

}
