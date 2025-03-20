package com.example.simpelmusic.Service;

import com.example.simpelmusic.Model.Album;
import com.example.simpelmusic.Repository.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService
{
    @Autowired
    private AlbumRepo albumRepo;

    public List<Album> getAllAlbums()
    {
        return albumRepo.fetchAll();
    }

    public void addAlbum(Album album)
    {
        albumRepo.addAlbum(album);
    }

    public Album findAlbumVedId(int albumId)
    {
        return albumRepo.findById(albumId);
    }

    public void updateAlbum(Album album)
    {
        albumRepo.updateAlbum(album);
    }

    /*public Boolean deleteAlbum(int albumId)
    {
        return albumRepo.deleteAlbum(albumId);
    }*/

    public boolean deleteAlbum(int albumId) {
        return albumRepo.deleteAlbum(albumId);
    }

}
