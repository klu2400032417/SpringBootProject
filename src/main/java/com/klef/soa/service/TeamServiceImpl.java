package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Team;
import com.klef.soa.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService{

	@Autowired
	private TeamRepository repo;
	@Override
	public Team addMember(Team t) {
	 		return repo.save(t);
	}

	@Override
	public Team updateMember(Team t) {
		Optional<Team> optional=repo.findById(t.getId());
				if(optional.isPresent()) {
					Team team=optional.get();
					team.setType(t.getType());
					team.setStatus(t.getStatus());
					team.setLocation(t.getLocation());
					return repo.save(team);
				}
				else
					return null;
	}

	@Override
	public String deleteMemeber(Long id) {
		Optional<Team> optional=repo.findById(id);
		if(optional.isPresent()) {
			Team team=optional.get();
			repo.delete(team);
			return "deleted successfully";
		}
		else
		return "Id not found";
	}

	@Override
	public List<Team> displayAll() {
		return repo.findAll();
	}

	@Override
	public Team displayById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Team> displayByName(String name) {
		
		return repo.findByName(name);
	}

	@Override
	public List<Team> displayByType(String type) {
		// TODO Auto-generated method stub
		return repo.findByType(type);
	}

}
