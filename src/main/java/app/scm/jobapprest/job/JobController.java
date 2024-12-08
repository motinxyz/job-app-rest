package app.scm.jobapprest.job;

import java.util.List;

public interface JobController {

    List<Job> getAllJobs();
    Job getJobById(Long id);
    String addJob(Job job);
}
