package com.gokul.springbootrestproject;

import com.gokul.springbootrestproject.model.JobPost;
import com.gokul.springbootrestproject.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SpringBootRestApp {
    @Autowired
    private JobService service;

    @GetMapping(path="jobPosts",produces = {"application/json"})
    public List<JobPost>  getAllJobs()
    {
        return service.getAllJobs();
    }
    @GetMapping("getJob/{postId}")

    public JobPost getJob(@PathVariable("postId") int postId)
    {
        return service.getJob(postId);
    }

    @PostMapping(path="jobPost", consumes = {"application/json"})


    public JobPost addJob(@RequestBody JobPost jobPost)
    {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }
@PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost)
    {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

 @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId)
    {

        service.deleteJob(postId);
      return "deleted";
    }

    @GetMapping("load")
    public String loadData()
    {
       service.load();
        return "sucess";
    }
@GetMapping("jobPost/keyword/{keyword}")
    public List <JobPost> searchByKeyword(@PathVariable("keyword") String keyword)
    {
        return service.search(keyword);
    }
}
