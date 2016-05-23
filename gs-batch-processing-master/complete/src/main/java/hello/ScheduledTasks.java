package hello;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    
@Autowired
private JobLauncher launcher;

@Autowired
private Job job;

private JobExecution execution;


private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

   // @Scheduled(fixedRate = 5000)
     @Scheduled(cron="*/5 * * * * *")
    public void processCSVintoDB() {
        try {
        String dateParam = new Date().toString();
        JobParameters param = 
	  new JobParametersBuilder().addString("date", dateParam).toJobParameters();
            execution = launcher.run(job, param);
            System.out.println("The time is now " + dateFormat.format(new Date()));
            System.out.println("Execution status: "+ execution.getStatus());

        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {        

            e.printStackTrace();

        }

        
    }
}
