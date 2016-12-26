package test.mockito.JUNITIntergration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

/**
 * Created by marcus.chiu on 9/23/16.
 */
public class MathApplicationTester2 {
    // create mock with out mock annotation
    private CalculatorService calculatorService;
    private MathApplication mathApplication;

    @Before
    public void setUp() {
        mathApplication = new MathApplication();
        // mock() - creates mocks without bothering about the order of method
        // calls that the mock is going to make in due course of its action.
        calculatorService = mock(CalculatorService.class);
        mathApplication.setCalculatorService(calculatorService);
    }

    @Test
    public void test(){
        when(calculatorService.add(10.0, 10.0)).thenReturn(20.0);
        when(calculatorService.subtract(20.0, 10.0)).thenReturn(10.0);

        Assert.assertEquals(mathApplication.add(10.0, 10.0), 20.0, 0);
        Assert.assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);

        verify(calculatorService).add(10.0, 10.0);
        verify(calculatorService).subtract(20.0, 10.0);


        //ORDERED VERIFICATION//
        //create an inOrder verifier for a single mock
        InOrder inOrder = inOrder(calculatorService);

        //following will make sure that add is first called then subtract is called.
        inOrder.verify(calculatorService).add(10.0, 10.0);
        inOrder.verify(calculatorService).subtract(20.0, 10.0);


        //CALLBACKS//
        //add the behavior to add numbers
        when(calculatorService.add(200.0,100.0)).thenAnswer(new Answer<Double>() {
            public Double answer(InvocationOnMock invocation) throws Throwable {
                //get the arguments passed to mock
                Object[] args = invocation.getArguments();

                //get the mock
                Object mock = invocation.getMock();

                //return the result
                return 300.0;
            }
        });

        //test the add functionality
        Assert.assertEquals(mathApplication.add(200.0, 100.0), 300.0, 0);
    }
}
