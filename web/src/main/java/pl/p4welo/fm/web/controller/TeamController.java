package pl.p4welo.fm.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.p4welo.fm.service.ITeamService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2015-06-23.
 */
@RestController
@RequestMapping(value = "/team")
public class TeamController {

    @Resource
    private ITeamService teamService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List getTeams() {
        return teamService.findAll();
    }
}
