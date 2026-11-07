package com.klef.soa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.Team;
import com.klef.soa.repository.TeamRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TeamRepositoryTest {

    @Autowired
    private TeamRepository repository;

    @Test
    void findAll() {
        List<Team> teams = repository.findAll();

        assertNotNull(teams);
        assertFalse(teams.isEmpty());

        System.out.println("Total Teams: " + teams.size());
    }

    @Test
    void findById() {
        Optional<Team> team = repository.findById(13L);

        assertTrue(team.isPresent());
        assertEquals(13L, team.get().getId());

        System.out.println("Team ID: " + team.get().getId());
    }

    @Test
    void findByName() {
        List<Team> teams = repository.findByName("ashmitha");

        assertFalse(teams.isEmpty());
        assertEquals("ashmitha", teams.get(0).getName());

        System.out.println("Team Name: " + teams.get(0).getName());
    }

    @Test
    void findByType() {
        List<Team> teams = repository.findByType("teamlead");

        assertFalse(teams.isEmpty());
        assertEquals("teamlead", teams.get(0).getType());

        System.out.println("Team Type: " + teams.get(0).getType());
    }

    @Test
    void nullconstraints() {
        Optional<Team> team = repository.findById(1L);

        if (team.isPresent()) {
            assertNotNull(team.get().getName());
            System.out.println("Team Name: " + team.get().getName());
        } else {
            System.out.println("Team not found");
        }
    }
}