package app.scm.jobapprest.job.impl;

import app.scm.jobapprest.job.Job;
import app.scm.jobapprest.job.JobController;
import app.scm.jobapprest.job.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job =  jobService.getJobById(id);

        if(job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @PostMapping
    public String addJob(@RequestBody Job job) {

        return jobService.addJob(job);
    }

}
