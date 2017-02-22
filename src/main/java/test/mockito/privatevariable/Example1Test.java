package test.mockito.privatevariable;

import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Example1Test {

    @Test
    public void testThenReturn() throws Exception {

        Example1 example1 = new Example1();
        Example2 example2 = mock(Example2.class);

        when(example2.getMessage()).thenReturn("Jesus Christ");
        when(example2.getMessage()).thenReturn("God");

        Whitebox.setInternalState(example1, "example2", example2);

        assertEquals("God", example1.getMessage());
    }

    @Test
    public void testMultiThenReturn() throws Exception {

        Example1 example1 = new Example1();
        Example2 example2 = mock(Example2.class);

        when(example2.getMessage()).thenReturn("Jesus Christ").thenReturn("God");

        Whitebox.setInternalState(example1, "example2", example2);

        assertEquals("Jesus Christ", example1.getMessage());
        assertEquals("God", example1.getMessage());
    }

    @Test(expected = Exception.class)
    public void testThenThrow() throws Exception {

        Example1 example1 = new Example1();
        Example2 example2 = mock(Example2.class);

        when(example2.getMessage()).thenThrow(new Exception());

        Whitebox.setInternalState(example1, "example2", example2);

        example1.getMessage();
    }
}
