package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Team;

public interface TeamService {
     Team addMember(Team t);
     Team updateMember(Team t);
     String deleteMemeber(Long id);
     List<Team> displayAll();
     Team displayById(Long id);
     List<Team> displayByName(String name);
     List<Team> displayByType(String type);
    
}
