package com.francisco.mundial.apprest;

import com.francisco.mundial.models.Conection;
import com.francisco.mundial.restmodels.RestAddUsuario;
import com.francisco.mundial.restmodels.RestUsuario;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class AppRestController {

    private JdbcTemplate jdbcTemplate;

    public AppRestController() {
        Conection con = new Conection();
        this.jdbcTemplate = new JdbcTemplate(con.conectar());
    }

    @GetMapping("/getPlayers")
    public Map<String, Object> getUser() {
        String sql = "SELECT * FROM jugadores";
        List datos = this.jdbcTemplate.queryForList(sql);
        Map<String, Object> obj = new HashMap<>();
        obj.put("jugadores", datos);
        return obj;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody RestUsuario restusr) {
        String sql = "Select * from usuarios where password=" + restusr.getClave() + " && identification='" + restusr.getCedula() + "'";
        List datos = this.jdbcTemplate.queryForList(sql);
        if (!datos.isEmpty()) {
            Map<String, Object> mapdata = new HashMap<>();
            mapdata.put("success", true);
            return mapdata;
        } else {
            Map<String, Object> mapdata = new HashMap<>();
            mapdata.put("success", false);
            return mapdata;
        }
    }
    
    @PostMapping("/addUser")
    public Map<String, Object> addUser(@RequestBody RestAddUsuario u) {
        Date date = new Date();
        this.jdbcTemplate.update(
            "insert into usuarios (name, lastname, identification, password, type, date) values(?,?,?,?,?,?)",
            u.getName(), u.getLastname(), u.getIdentification(), u.getPassword(), "0", date);
            Map<String, Object> mapdata = new HashMap<>();
            mapdata.put("success", true);
            return mapdata;

    }
}
