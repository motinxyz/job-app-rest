package app.scm.jobapprest.job.impl;

import app.scm.jobapprest.job.Job;
import app.scm.jobapprest.job.JobController;
import app.scm.jobapprest.job.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/jobs")
public class JobControllerImpl implements JobController {

    private JobService jobService;

    public JobControllerImpl(JobService jobService) {
        this.jobService = jobService;
    }

    @Override
    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @Override
    @GetMapping("{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @Override
    @PostMapping
    public String addJob(@RequestBody Job job) {

        return jobService.addJob(job);
    }

}
