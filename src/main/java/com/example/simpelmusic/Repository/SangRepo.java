package com.example.simpelmusic.Repository;

import com.example.simpelmusic.Model.Sang;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SangRepo
{
    @Autowired
    private JdbcTemplate template;

    public List<Sang> findSangeVedAlbum(int albumId)
    {
        String sql = "select * from sang where album_id= ? ";
        return template.query(sql, new BeanPropertyRowMapper<>(Sang.class),albumId);
    }
}
