package com.klef.soa.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Team;
import com.klef.soa.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
	@Autowired
	private TeamService service;
	
	@PostMapping("/add")
	private ResponseEntity<Team> addmember(Team t) {
		Team team= service.addMember(t);
		return ResponseEntity.ok(team);
	}
    
	@PutMapping("/update")
	private ResponseEntity<Team> updatemember(@RequestBody Team t) {
		Team team=service.updateMember(t);
		if(team!=null)
		return ResponseEntity.ok(team);
		else
			return ResponseEntity.status(404).body(team);
	}
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String> deletebyid(@PathVariable Long id) {
		String mssg= service.deleteMemeber(id);
		if(mssg!=null)
			return ResponseEntity.ok(mssg);
		else
			return ResponseEntity.status(404).body(mssg);
	}
	
	@GetMapping("/displayall")
	private List<Team> displayall(){
		return service.displayAll();
	}
	
	@GetMapping("/display/{id}")
	private ResponseEntity<Team> displaybyid(Long id) {
		Team team= service.displayById(id);
			return ResponseEntity.ok(team);
	}
	
	@GetMapping("/displaybyname/{name}")
	private List<Team> findbyname(@PathVariable String name){
		List<Team> list=service.displayByName(name);
		return list;
	}
	
	@GetMapping("/displaybytyoe/{type}")
	private List<Team> findbytype(String type){
		return service.displayByType(type);
	}
}
