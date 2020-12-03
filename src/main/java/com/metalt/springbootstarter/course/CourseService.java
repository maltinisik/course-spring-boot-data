package com.metalt.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
 
	@Autowired
	private CourseRepository courseRepository;
	

  public List<Course> getAllCourses(String topicId) {
	  
	  List<Course> Courses = new ArrayList<>();
	  
	  courseRepository.findByTopicId(topicId).forEach(Courses::add);
	  
	  return Courses;	  
  }

  public Course getCourse(String id) {
	  
	  Optional<Course> findById = courseRepository.findById(id);
	  
	  return findById.get();
  }

  public void addCourse(Course course) {
	courseRepository.save(course);
  }

  public void updateCourse(Course course) {
	  courseRepository.save(course);
  }

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
