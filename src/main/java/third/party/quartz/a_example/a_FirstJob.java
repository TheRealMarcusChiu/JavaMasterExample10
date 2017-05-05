package third.party.quartz.a_example;

import org.quartz.*;

/**
 * https://www.mkyong.com/java/quartz-2-scheduler-tutorial/
 */
public class a_FirstJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello Quartz!");
    }
}
