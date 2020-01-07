package powermock.whitebox;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Use Whitebox.setInternalState(..) to set a private member of an instance or class.
 * Use Whitebox.getInternalState(..) to get a private member of an instance or class.
 * Use Whitebox.invokeMethod(..) to invoke a private method of an instance or class.
 * Use Whitebox.invokeConstructor(..) to create an instance of a class with a private constructor.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Example1.class})
public class Example1Test {

    @Test
    public void testGetInternalState() throws Exception {

        Example1 example1 = new Example1();

        Example2 example2 = Whitebox.getInternalState(example1, "example2");

        assertEquals("hello", example2.getMessage());
    }

    @Test
    public void testSetInternalState() throws Exception {

        Example1 example1 = new Example1();
        Example2 example2 = mock(Example2.class);

        when(example2.getMessage()).thenReturn("Jesus Christ");
        when(example2.getMessage()).thenReturn("God");          // This would replace 'Jesus Christ'

        Whitebox.setInternalState(example1, "example2", example2);

        assertEquals("God", example1.getMessage());
    }

    /**
     * call any methods including private methods
     * @throws Exception
     */
    @Test
    public void testInvokeMethod() throws Exception {

        Example1 example1 = new Example1();

        Integer sum = Whitebox.invokeMethod(example1, "sum", 1, 2);

        assertEquals(new Integer(3), sum);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testInvokeConstructor() throws Exception {

        // invokes the private constructor 'private Example1(Integer i)'
        Example1 example1 = Whitebox.invokeConstructor(Example1.class, 12);

        assertEquals(new Integer(12), example1.i);
    }

// TODO move to mockito

//    @Test
//    public void testMultiThenReturn() throws Exception {
//
//        Example1 example1 = new Example1();
//        Example2 example2 = mock(Example2.class);
//
//        when(example2.getMessage()).thenReturn("Jesus Christ").thenReturn("God");
//
//        Whitebox.setInternalState(example1, "example2", example2);
//
//        assertEquals("Jesus Christ", example1.getMessage());
//        assertEquals("God", example1.getMessage());
//    }
//
//    @Test(expected = Exception.class)
//    public void testThenThrow() throws Exception {
//
//        Example1 example1 = new Example1();
//        Example2 example2 = mock(Example2.class);
//
//        when(example2.getMessage()).thenThrow(new Exception());
//
//        Whitebox.setInternalState(example1, "example2", example2);
//
//        example1.getMessage();
//    }
}
