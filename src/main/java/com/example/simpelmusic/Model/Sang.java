package com.example.simpelmusic.Model;

import java.time.LocalTime;

public class Sang
{
    private int sangId;
    private String titel;
    private LocalTime spilletid;
    private int albumId;

    public Sang(){}

    public Sang(int sangId, String titel, LocalTime spilletid, int albumId)
    {
        this.sangId = sangId;
        this.titel = titel;
        this.spilletid = spilletid;
        this.albumId = albumId;
    }

    public int getSangId()
    {
        return sangId;
    }

    public String getTitel()
    {
        return titel;
    }

    public LocalTime getSpilletid()
    {
        return spilletid;
    }

    public int getAlbumId()
    {
        return albumId;
    }

    public void setSangId(int sangId)
    {
        this.sangId = sangId;
    }

    public void setTitel(String titel)
    {
        this.titel = titel;
    }

    public void setSpilletid(LocalTime spilletid)
    {
        this.spilletid = spilletid;
    }

    public void setAlbumId(int albumId)
    {
        this.albumId = albumId;
    }
}
