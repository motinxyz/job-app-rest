package app.scm.jobapprest.job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    Job getJobById(Long id);
    String addJob(Job job);
    boolean deleteJobById(Long id);

    boolean updateJobInfoById(Long id, Job updatedJob);
}
