
package com.francisco.mundial.controller;

import com.francisco.mundial.models.Conection;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuariosController {
    
    private JdbcTemplate jdbtemplate;
    
    public UsuariosController(){
        Conection con = new Conection();
        this.jdbtemplate = new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("usuarios.htm")
    public ModelAndView event(){
        ModelAndView mav = new ModelAndView();
        String usuariosmundial = "SELECT * FROM usuarios";
        List datos = this.jdbtemplate.queryForList(usuariosmundial);
        mav.addObject("datos", datos);
        mav.setViewName("usuarios");
        return mav;
    }
    
    
    
}
