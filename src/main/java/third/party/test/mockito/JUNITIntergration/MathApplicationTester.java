package third.party.test.mockito.JUNITIntergration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

/**
 * Created by marcus.chiu on 9/23/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
    //@InjectMocks is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();


    //@Mock is used to create a mock object TO BE injected
    @Mock
    CalculatorService calculatorService;

    @Before
    public void setUp() {
        //Nothing here
    }

    @Test
    public void test() {
        //ADDING BEHAVIOR//
        //add he behavior of calc service to add two numbers
        when(calculatorService.add(100.0, 20.0)).thenReturn(120.0);


        //est the add functionality
        Assert.assertTrue(120.0 == mathApplication.add(100.0, 20.0));

        //VERIFYING BEHAVIOR//
        //ensures whether mocked method is being called with required arguments
        //verify the behavior has been called
        verify(calculatorService).add(100.0, 20.0);

        //EXPECTING CALLS//
        //ensures mocked method is being called with required arguments
        //'times(1)' makes sure it is called exactly that many times
        verify(calculatorService, times(1)).add(100.0, 20.0);

        //VARYING CALLS//
        //check a minimum 1 call count
        verify(calculatorService, atLeastOnce()).add(100.0, 20.0);

        //check if add function is called a minimum of 2 times
        verify(calculatorService, atLeast(1)).add(100.0, 20.0);

        //check if add function is called at most 3 times
        verify(calculatorService, atMost(3)).add(100.0,20.0);


        //EXCEPTION HANDLING//
        //add the behavior to throw exception
        /*doThrow(new RuntimeException("divide operation not implemented"))
            .when(calculatorService).divide(10.0, 20.0);

        //test the add functionality
        Assert.assertEquals(mathApplication.divide(10.0, 20.0), 0.5, 0);*/
    }
}
