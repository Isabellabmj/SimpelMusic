package com.example.simpelmusic.Service;

import com.example.simpelmusic.Model.Sang;
import com.example.simpelmusic.Repository.SangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SangService
{
    @Autowired

    private SangRepo sangRepo;

    public List<Sang> hentSangeVedAlbum(int albumId)
    {
        return sangRepo.findSangVedAlbum(albumId);
    }
}
