
package com.francisco.mundial.controller;

import com.francisco.mundial.models.Conection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class DeleteUsuarioController {
    
    public JdbcTemplate jdbctemplate;

    public DeleteUsuarioController() {
        Conection con = new Conection();
        this.jdbctemplate =new JdbcTemplate(con.conectar());
    }
    
    @RequestMapping("deleteusuario.htm")
    public ModelAndView delete(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        this.jdbctemplate.update("Delete from usuarios where idusuarios=?", id);
        return new ModelAndView("/redirect:/usuarios.htm");
    }
    
}
