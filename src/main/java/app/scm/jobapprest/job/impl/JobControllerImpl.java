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
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
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
    public ResponseEntity<String>  addJob(@RequestBody Job job) {

        jobService.addJob(job);

        return new ResponseEntity<String>("job added successfully", HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {

        boolean idFound = jobService.deleteJobById(id);

        if (idFound) {
            return ResponseEntity.ok("job deleted successfully");
        }
        return new ResponseEntity<String>("invalid id", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<String> updateJobInfoById(@PathVariable Long id, @RequestBody Job updatedJob) {

        boolean updated = jobService.updateJobInfoById(id, updatedJob);

        if(updated)
            return ResponseEntity.ok("updated successfully");
        return new ResponseEntity<String>("invalid job info", HttpStatus.NOT_FOUND);
    }
}
