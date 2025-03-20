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

    /*public List<Album> fetchAll()
    {
        String sql = "select * from album";
        RowMapper<Album> rowMapper = new BeanPropertyRowMapper<>(Album.class); //BeanPro.. er automatiserede rækker, de matcher kolonnenavne fra databasen med java-variabler i Album klassen
        return template.query(sql, rowMapper); //query sender SQL forespørgelsen til databasen
    }*/

    public List<Album> fetchAll() {
        String sql = "SELECT album_id AS albumId, titel, spilletid, udgivelsesaar, pladeselskab, kunstner FROM album";
        RowMapper<Album> rowMapper = new BeanPropertyRowMapper<>(Album.class);
        return template.query(sql, rowMapper);
    }

    public void addAlbum(Album album)
    {
        String sql = "INSERT INTO album (titel, spilletid, udgivelsesaar, pladeselskab, kunstner) VALUES (?, ?, ?, ?, ?)"; //? er prepared statements
        template.update(sql, album.getTitel(), album.getSpilletid(), album.getUdgivelsesaar(), album.getPladeselskab(), album.getKunstner());
    }

    public Album findById(int albumId)
    {
        String sql = "SELECT * FROM album WHERE album_id = ?";
        RowMapper<Album> rowMapper = new BeanPropertyRowMapper<>(Album.class);
        return template.queryForObject(sql, rowMapper, albumId);
    }

    public void updateAlbum(Album album) {
        String sql = "UPDATE album SET titel=?, spilletid=?, udgivelsesaar=?, pladeselskab=?, kunstner=? WHERE album_id=?";
        template.update(sql, album.getTitel(), album.getSpilletid(), album.getUdgivelsesaar(), album.getPladeselskab(), album.getKunstner(), album.getAlbumId());
    }

    /*public Boolean deleteAlbum(int albumID)
    {
        String sql = "DELETE FROM album WHERE album_id = ? ";
        return template.update(sql, albumID) > 0;
    }*/

    public boolean deleteAlbum(int albumId) {
        String sql = "DELETE FROM album WHERE album_id = ?";
        return template.update(sql, albumId) > 0; // Returnerer true, hvis et album blev slettet
    }

}
