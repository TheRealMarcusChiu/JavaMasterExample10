package third.party.quartz.a_example;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class b_SimpleTriggerExample {

    public static void main(String[] args) throws Exception {

        // Quartz 1.6.3
        // JobDetail job = new JobDetail();
        // job.setName("dummyJobName");
        // job.setJobClass(HelloJob.class);

        JobDetail job = JobBuilder
                .newJob(a_FirstJob.class)
                .withIdentity("dummyJobName", "group1")
                .build();

        //Quartz 1.6.3
        // SimpleTrigger trigger = new SimpleTrigger();
        // trigger.setStartTime(new Date(System.currentTimeMillis() + 1000));
        // trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        // trigger.setRepeatInterval(30000);

        // Trigger the job to run on the next round minute
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("dummyTriggerName", "group1")
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        // schedule it
        // would default read /resources/quartz.properties file
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);

        // The same can also be implemented without using a properties file but using the following code
//        Properties prop = new Properties();
//        prop.setProperty("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");
//        prop.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
//        prop.setProperty("org.quartz.threadPool.threadCount", "4");
//        SchedulerFactory schdFact = new StdSchedulerFactory(prop);

        // Or specify a different properties file
//        SchedulerFactory schdFact = new StdSchedulerFactory("quartz.properties");
    }
}
