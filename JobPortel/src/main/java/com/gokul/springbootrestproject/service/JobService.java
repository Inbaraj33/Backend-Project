package com.gokul.springbootrestproject.service;


import com.gokul.springbootrestproject.model.JobPost;
import com.gokul.springbootrestproject.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class JobService  {

    @Autowired
    JobRepo repo;
    public void addJob(JobPost add)
    {
    repo.save(add);
    }
    public List<JobPost> getAllJobs()
    {
         return   repo.findAll();
    }

    public JobPost getJob(int i) {
        return repo.findById(i).orElse(new JobPost());
        // its give the error because its return the optional method
    }

    public void updateJob(JobPost jobPost) {

        repo.save(jobPost);
    }

    public void deleteJob(int postId) {

        repo.deleteById(postId);

    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(List.of(
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
                        3, List.of("HTML","css"))
        ) );

       repo.saveAll(jobs);

    }


    public List<JobPost> search(String keyword) {

        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);


    }
}
