package pl.p4welo.fm.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.p4welo.fm.domain.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parado on 2015-06-18.
 */
@RestController
public class RstController {

    @RequestMapping(value = "/dupa", method = RequestMethod.GET)
    public List getTeams() {
        List<Team> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            result.add(new Team("FC Wymiatacze " + i));
        }
        return result;
    }
}
