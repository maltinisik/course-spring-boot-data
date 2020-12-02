package com.metalt.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
 
	@Autowired
	private TopicRepository topicRepository;
	
	/*
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring","spring framework","spring framework desc"),
			new Topic("oracle","sql","struntured query lang"),
			new Topic("java","j2ee","j2ee desc")
			)); 
			
	*/

  public List<Topic> getAllTopics() {
	  
	  List<Topic> topics = new ArrayList<>();
	  
	  topicRepository.findAll().forEach(topics::add);
	  
	  return topics;	  
  }

  public Topic getTopic(String id) {
	//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	  
	  Optional<Topic> findById = topicRepository.findById(id);
	  
	  return findById.get();
  }

  public void addTopic(Topic topic) {
	topicRepository.save(topic);
  }

  public void updateTopic(String id, Topic topic) {
	  topicRepository.save(topic);
  }

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
