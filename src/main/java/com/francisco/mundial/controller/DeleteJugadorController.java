/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.francisco.mundial.controller;

import com.francisco.mundial.models.Conection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class DeleteJugadorController {
    
    public JdbcTemplate jdbctemplate;

    public DeleteJugadorController() {
        Conection con = new Conection();
        this.jdbctemplate =new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("/jugadores/deletejugadores.htm")
    public ModelAndView deletejugador(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        this.jdbctemplate.update("Delete from jugadores where idjugadores=?", id);
        return new ModelAndView("/redirect:/jugadores/jugadores.htm");
    }
    
}
   