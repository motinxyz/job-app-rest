package app.scm.jobapprest.job.impl;

import app.scm.jobapprest.job.Job;
import app.scm.jobapprest.job.JobService;
import app.scm.jobapprest.job.JobUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs;

    public JobServiceImpl() {
        jobs = JobUtil.generateDemoJobs();
    }
    @Override
    public List<Job> getAllJobs() {
        return jobs;
    }

    @Override
    public Job getJobById(Long id) {
        return new Job(1L, "Jr. Spring Dev",
                "Your job is to create and manage smart spring projects!",
                "45000", "55000", "Dhaka");
    }

    @Override
    public String addJob(Job job) {
        jobs.add(job);
        return "jobs added successfully";
    }
}
