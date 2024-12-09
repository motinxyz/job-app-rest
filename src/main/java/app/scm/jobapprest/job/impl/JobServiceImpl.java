package app.scm.jobapprest.job.impl;

import app.scm.jobapprest.job.Job;
import app.scm.jobapprest.job.JobService;
import app.scm.jobapprest.job.JobUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs;
    private Long nextId = 2L;

    public JobServiceImpl() {
        jobs = JobUtil.generateDemoJobs();
    }
    @Override
    public List<Job> getAllJobs() {
        return jobs;
    }

    @Override
    public Job getJobById(Long id) {

        for(Job job : jobs) {

            if(job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    @Override
    public String addJob(Job job) {
        nextId++;
        job.setId(nextId);
        jobs.add(job);
        return "jobs added successfully";
    }
}
