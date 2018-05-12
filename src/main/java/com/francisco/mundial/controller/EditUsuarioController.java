package com.francisco.mundial.controller;

import com.francisco.mundial.models.Conection;
import com.francisco.mundial.models.Usuarios;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/usuarios/editusuario.htm")
public class EditUsuarioController {

    private JdbcTemplate jdbctemplate;

    public EditUsuarioController() {
        Conection con = new Conection();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Usuarios datos = this.UsuarioSelected(id);
        mav.setViewName("/usuarios/editusuario");
        mav.addObject("usuarios", new Usuarios(id, datos.getName(), datos.getLastname(), datos.getIdentification(), datos.getPassword(), datos.getType(), datos.getDate()));
        return mav;
    }

    public Usuarios UsuarioSelected(int id) {
        final Usuarios userselected = new Usuarios();
        String quer = "SELECT * FROM usuarios WHERE idusuarios='" + id + "'";
        return (Usuarios) jdbctemplate.query(
                quer, new ResultSetExtractor< Usuarios>() {
            public Usuarios extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    userselected.setName(rs.getString("name"));
                    userselected.setLastname(rs.getString("lastname"));
                    userselected.setIdentification(rs.getString("identification"));
                    userselected.setType(rs.getString("type"));
                    userselected.setPassword(rs.getString("password"));
                }
                return userselected;
            }
        }
        );
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("usuarios") Usuarios u,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.jdbctemplate.update(
                "update usuarios set name=?, lastname=?, identification=?, password=?, type=?  where idusuarios=?",
                u.getName(), u.getLastname(), u.getIdentification(), u.getPassword(), u.getType(), id);
        return new ModelAndView("redirect:/usuarios/usuarios.htm");

    }
}
