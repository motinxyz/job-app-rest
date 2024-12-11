package app.scm.jobapprest.job.impl;

import app.scm.jobapprest.job.Job;
import app.scm.jobapprest.job.JobService;
import app.scm.jobapprest.job.JobUtil;
import org.springframework.stereotype.Service;

import java.util.Iterator;
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

    @Override
    public boolean deleteJobById(Long id) {

        Iterator<Job> iterator = jobs.iterator();

        while(iterator.hasNext()){
            Job job = iterator.next();
            if(job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
//
//        boolean idFound = false;
//        Job jobToRemove = null;
//
//        for(Job job: jobs){
//            if(job.getId().equals(id)){
//                jobToRemove = job;
//                idFound = true;
//                break;
//            }
//        }
//
//        if(idFound) {
//            jobs.remove(jobToRemove);
//        }
//        return idFound;
    }

    @Override
    public boolean updateJobInfoById(Long id, Job updatedJob) {
        Iterator<Job> iterator = jobs.iterator();

        Job job = null;
        while(iterator.hasNext()){
            job = iterator.next();
            if(job.getId().equals(id)){
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setLocation(updatedJob.getLocation());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());

                return true;
            }
        }
        return false;
    }
}
