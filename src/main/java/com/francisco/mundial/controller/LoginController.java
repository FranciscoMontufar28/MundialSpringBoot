
package com.francisco.mundial.controller;

import com.francisco.mundial.models.Conection;
import com.francisco.mundial.models.Usuarios;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login.htm")
public class LoginController {
    
    private JdbcTemplate jdbctemplate;

    public LoginController() {
        Conection con = new Conection();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }

    @GetMapping
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        mav.addObject("login", new Usuarios());
        return mav;
    }

    @PostMapping
    public ModelAndView login(
            @ModelAttribute("login") Usuarios u,
            BindingResult result,
            SessionStatus status
    ) {
        ModelAndView mav = new ModelAndView();
        String user = u.getIdentification();
        String pass = u.getPassword();
        String sql = "select * from usuarios where password="+pass+" && identification='"+user+"'";
        List datos=this.jdbctemplate.queryForList(sql);
        if(!datos.isEmpty()){
        mav.addObject("datos", datos);
        mav.setViewName("login");
        return new ModelAndView("redirect:/menu/menu.htm");
        }else{
            mav = new ModelAndView();
            mav.setViewName("login");
            mav.addObject("login", new Usuarios());
            return mav;
        }

    }
    
}