package enums.simple;

import org.apache.commons.lang3.EnumUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class Main {

    @Test
    public void testString2Enum() {
        // Note EnumUtils uses org.apache.commons.lang3.EnumUtils not org.apache.commons.lang.enums.EnumUtils
        Days_Compact day = EnumUtils.getEnum(Days_Compact.class, "MONDAY");
        assertEquals("MONDAY", day.toString());
    }

    @Test
    public void testNull2Enum() {
        Days_Compact day = EnumUtils.getEnum(Days_Compact.class, null);
        assertNull(day);
    }

    @Test
    public void testRandom2Enum() {
        Days_Compact day = EnumUtils.getEnum(Days_Compact.class, "asdfghjkl");
        assertNull(day);
    }

    @Test
    public void testAssertValues() {

        // assert false
        assertFalse(Days_Compact.MONDAY.isWeekend());
        assertFalse(Days_Compact.TUESDAY.isWeekend());
        assertFalse(Days_Compact.WEDNESDAY.isWeekend());
        assertFalse(Days_Compact.THURSDAY.isWeekend());
        assertFalse(Days_Compact.FRIDAY.isWeekend());

        // assert true
        assertTrue(Days_Compact.SATURDAY.isWeekend());
        assertTrue(Days_Compact.SUNDAY.isWeekend());
    }
}
