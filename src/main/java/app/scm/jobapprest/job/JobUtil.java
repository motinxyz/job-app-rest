package app.scm.jobapprest.job;

import java.util.ArrayList;
import java.util.List;

public class JobUtil {

    public static List<Job> generateDemoJobs(){
        List<Job> jobs = new ArrayList<>();
        Job job1 = new Job(1L, "Jr. Spring Dev", "Your job is to create and manage smart spring projects!", "45000", "55000", "Dhaka");
        jobs.add(job1);
        Job job2 = new Job(2L, "Jr. System Engr", "Your job is to do your job!", "145000", "155000", "Dhaka");
        jobs.add(job2);

        return jobs;
    }
}
