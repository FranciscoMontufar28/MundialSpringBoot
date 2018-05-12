package com.francisco.mundial.controller;

import com.francisco.mundial.models.Conection;
import com.francisco.mundial.models.Jugadores;
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
@RequestMapping("/jugadores/editjugador.htm")
public class EditJugadorController {

    private JdbcTemplate jdbctemplate;

    public EditJugadorController() {
        Conection con = new Conection();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav2 = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Jugadores jugadores = this.JugadorSelected(id);
        mav2.setViewName("/jugadores/editjugador");
        mav2.addObject("jugadores", new Jugadores(id, jugadores.getName(), jugadores.getLastname(), jugadores.getClub()));
        return mav2;
    }

    public Jugadores JugadorSelected(int id) {
        final Jugadores playerselected = new Jugadores();
        String playerquer = "SELECT * FROM jugadores WHERE idjugadores='" + id + "'";
        return (Jugadores) jdbctemplate.query(
                playerquer, new ResultSetExtractor< Jugadores>() {
            public Jugadores extractData(ResultSet rsplayer) throws SQLException, DataAccessException {
                if (rsplayer.next()) {
                    playerselected.setName(rsplayer.getString("name"));
                    playerselected.setLastname(rsplayer.getString("lastname"));
                    playerselected.setClub(rsplayer.getString("club"));
                }
                return playerselected;
            }
        }
        );
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(
            @ModelAttribute("jugadores") Jugadores j,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) {
        int id = Integer.parseInt(request.getParameter("id"));
        this.jdbctemplate.update(
                "update jugadores set name=?, lastname=?, club=?  where idjugadores=?",
                j.getName(), j.getLastname(), j.getClub(), id);
        return new ModelAndView("redirect:/jugadores/jugadores.htm");

    }
}
