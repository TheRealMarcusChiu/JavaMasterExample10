package test.powermock.mock.newly.created.objects.within.method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Mocking methods of local scope objects with Mockito
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Example.class})
public class ExampleTest {

    // interchangeable with mock(SubExample.class);
    @Mock
    SubExample subExample;

    @Test
    public void test() throws Exception {

        // interchangeable with @Mock above
        // SubExample subExample = mock(SubExample.class);

        // mock subExample
        when(subExample.getInteger()).thenReturn(1);

        // whenever a new creation of SubExample(with any arguments) return mocked version
        PowerMockito.whenNew(SubExample.class).withAnyArguments().thenReturn(subExample);

        // this function will create a new SubExample, which will be replaced by the mocked version
        Integer response = new Example().example(10);

        assertEquals(new Integer(1), response);
    }
}

