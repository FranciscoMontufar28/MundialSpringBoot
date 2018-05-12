package com.francisco.mundial.controller;

import com.francisco.mundial.models.Conection;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VotosController {

    private JdbcTemplate jdbcTemplate;

    public VotosController() {
        Conection con = new Conection();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    @RequestMapping("/votos/votos.htm")
    public ModelAndView votes() {
        ModelAndView mav = new ModelAndView();
        String sql = "SELECT j.name, j.lastname, j.club, COUNT(v.idjugadores) AS votes \n"
                + "FROM jugadores j INNER JOIN votos v ON j.idjugadores=v.idjugadores\n"
                + "GROUP BY j.idjugadores";
        List datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("datos", datos);
        mav.setViewName("/votos/votos");
        return mav;
    }
}
