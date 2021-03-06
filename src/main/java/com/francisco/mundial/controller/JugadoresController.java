
package com.francisco.mundial.controller;

import com.francisco.mundial.models.Conection;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JugadoresController {
    
        
    private JdbcTemplate jdbtemplate;
    
    public JugadoresController(){
        Conection con = new Conection();
        this.jdbtemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("/jugadores/jugadores.htm")
    public ModelAndView player(){
        ModelAndView mav = new ModelAndView();
        String jugadoresmundial = "SELECT * FROM jugadores";
        List datosp = this.jdbtemplate.queryForList(jugadoresmundial);
        mav.addObject("datosp", datosp);
        mav.setViewName("/jugadores/jugadores");
        return mav;
    }
}
