
package com.francisco.mundial.controller;

import com.francisco.mundial.models.Conection;
import com.francisco.mundial.models.Jugadores;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jugadores/addjugador.htm")
public class AddJugadorController {
    private JdbcTemplate jdbctemplate;

    public AddJugadorController() {
        Conection con = new Conection();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav3 = new ModelAndView();
        mav3.setViewName("/jugadores/addjugador");
        mav3.addObject("addjugador", new Jugadores());
        return mav3;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("addjugador") Jugadores j,
            BindingResult result,
            SessionStatus status
    ) {
            this.jdbctemplate.update(
            "insert into jugadores (name, lastname, club) values(?,?,?)",
            j.getName(), j.getLastname(), j.getClub());
            return new ModelAndView("redirect:/jugadores/jugadores.htm");


    }
    
}