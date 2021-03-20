package com.example.UserFeedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserFeedback.entities.Feedback;
import com.example.UserFeedback.services.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
//	@GetMapping("/feedback")
//	public @ResponseBody Iterable<Feedback> getAllFeedbacks() {
//        // This returns a JSON or XML with the Feedbacks
//        return feedbackService.GetAllFeedback();
//    }
	
	@PostMapping(path="/feedback", consumes = {MediaType.APPLICATION_PROBLEM_JSON_VALUE})
	public Feedback addNewFeedback(@RequestBody Feedback newFeedback) {
		// TODO: Do something useful here.  
		// Add the Feedback.
//		Feedback feed = new Feedback();
//		feed.setComments(newFeedback.getComments());
//		feed.setRating(newFeedback.getRating());
//		feed.setUser(newFeedback.getUser());
//		feedbackService.save(feed);
		return feedbackService.save(newFeedback);  // Change this.
	}
	

}