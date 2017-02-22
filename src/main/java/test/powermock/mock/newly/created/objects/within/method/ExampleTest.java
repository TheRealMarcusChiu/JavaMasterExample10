package test.powermock.mock.newly.created.objects.within.method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Mocking methods of local scope objects with Mockito
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Example.class})
public class ExampleTest {

    @Test
    public void test() throws Exception {

        // mock subExample
        SubExample subExample = mock(SubExample.class);
        when(subExample.getInteger()).thenReturn(1);

        // whenever a new creation of SubExample(with any arguments) return mocked version
        PowerMockito.whenNew(SubExample.class).withAnyArguments().thenReturn(subExample);

        // this function will create a new SubExample, which will be replaced by the mocked version
        Integer response = new Example().example(10);

        assertEquals(new Integer(1), response);
    }
}

