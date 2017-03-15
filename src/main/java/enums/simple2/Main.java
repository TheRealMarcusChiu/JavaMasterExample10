package enums.simple2;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Main {

    @Test
    public void test() {
        assertEquals("PDF", ExampleEnumTwo.LASER.getFileType(1));
        assertEquals("GIF", ExampleEnumTwo.LASER.getFileType(2));
        assertEquals("PNG", ExampleEnumTwo.LASER.getFileType(1124313413));
    }
}
