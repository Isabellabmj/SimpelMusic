package com.example.simpelmusic.Repository;

import com.example.simpelmusic.Model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepo
{
    @Autowired
    private JdbcTemplate template; //Det er her Spring boot håndterer databaseforbindelsen for os

    public List<Album> fetchAll()
    {
        String sql = "select * from album";
        RowMapper<Album> rowMapper = new BeanPropertyRowMapper<>(Album.class); //BeanPro.. er automatiserede rækker, de matcher kolonnenavne fradatabasen med java-variabler i Album klassen
        return template.query(sql, rowMapper); //query sender SQL forespørgelsen til databasen
    }

    public void addAlbum(Album album)
    {
        String sql = "INSERT INTO album (titel, spilletid, udgivelsesaar, pladeselskab, kunstner) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, album.getTitel(), album.getSpilletid(), album.getUdgivelsesaar(), album.getPladeselskab(), album.getKunstner());
    }
}
