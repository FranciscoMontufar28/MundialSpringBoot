
package com.francisco.mundial.controller;

import com.francisco.mundial.models.Conection;
import com.francisco.mundial.models.Usuarios;
import java.util.Date;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RestController("/usuarios/addusuario.htm")
public class AddUsuarioController {
    
    private JdbcTemplate jdbctemplate;
    
    public AddUsuarioController(){
        Conection con = new Conection();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/usuarios/addusuario");
        mav.addObject("usuarios", new Usuarios());
        return mav;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("usuarios") Usuarios u,
            BindingResult result,
            SessionStatus status
    ) {
            Date date = new Date();
            this.jdbctemplate.update(
            "insert into usuarios (name, lastname, identification, password, type, date) values(?,?,?,?,?,?)",
            u.getName(), u.getLastname(), u.getIdentification(), u.getPassword(), u.getType(), date);
            return new ModelAndView("redirect:/usuarios.htm");


    }
    
    
    
}
