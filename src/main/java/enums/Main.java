package enums;

import org.apache.commons.lang3.EnumUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Main {

    @Test
    public void testString2Enum() {
        // Note EnumUtils uses org.apache.commons.lang3.EnumUtils not org.apache.commons.lang.enums.EnumUtils
        ExampleEnum exampleEnum = EnumUtils.getEnum(ExampleEnum.class, "ONE");
        assertEquals("ONE", exampleEnum.toString());
    }

    @Test
    public void testNull2Enum() {
        ExampleEnum exampleEnum = EnumUtils.getEnum(ExampleEnum.class, null);
        assertNull(exampleEnum);
    }

    @Test
    public void testRandom2Enum() {
        ExampleEnum exampleEnum = EnumUtils.getEnum(ExampleEnum.class, "asdfghjkl");
        assertNull(exampleEnum);
    }
}
