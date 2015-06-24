package pl.p4welo.fm.service.impl;

import org.springframework.stereotype.Service;
import pl.p4welo.fm.domain.Team;
import pl.p4welo.fm.service.ITeamService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by parado on 2015-06-23.
 */
@Service
public class TeamServiceImpl implements ITeamService {

    @Override
    public List<Team> findAll() {
        return Arrays.asList(
                new Team(0, "FC Wymiatacze", 50d, "#388E3E"),
                new Team(1, "Odra Wodzislaw", 40d, "#B47A47"),
                new Team(2, "Naprzod Rydultowy", 35d, "#2B6A6D")
        );
    }
}
