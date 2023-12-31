package com.example.events.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.events.models.EventDTO;
import com.example.events.models.FilterEventsDTO;
import com.example.events.services.IEventsService;

@CrossOrigin(origins =  "*", maxAge = 3600)
@RestController
@RequestMapping("/events")
public class EventsController {
	
	private IEventsService eventsService;
	
	@Autowired
	public EventsController(IEventsService eventsService) {
		this.eventsService = eventsService;
	}
	
	@GetMapping
	public List<EventDTO> getEvents() {
		return eventsService.getAllEvents();
	}
	
	@PostMapping("/filter")
	public Object filterEvents(@RequestBody FilterEventsDTO filter) {
		return eventsService.filterEvents(filter);
	}
	
	@GetMapping("/event/{id}")
	public EventDTO getEvent(@PathVariable int id) {
		return eventsService.getEvent(id);
	}
	
	
}
