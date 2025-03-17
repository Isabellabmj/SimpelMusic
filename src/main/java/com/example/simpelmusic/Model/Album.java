package com.example.simpelmusic.Model;

import java.time.LocalTime;

public class Album {
    private int albumId;
    private String titel;
    private LocalTime spilletid;
    private int udgivelsesaar;
    private String pladeselskab;
    private String kunstner;

    public Album() {}

    public Album(int albumId, String titel, LocalTime spilletid, int udgivelsesaar, String pladeselskab, String kunstner) {
        this.albumId = albumId;
        this.titel = titel;
        this.spilletid = spilletid;
        this.udgivelsesaar = udgivelsesaar;
        this.pladeselskab = pladeselskab;
        this.kunstner = kunstner;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public LocalTime getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(LocalTime spilletid) {
        this.spilletid = spilletid;
    }

    public int getUdgivelsesaar() {
        return udgivelsesaar;
    }

    public void setUdgivelsesaar(int udgivelsesaar) {
        this.udgivelsesaar = udgivelsesaar;
    }

    public String getPladeselskab() {
        return pladeselskab;
    }

    public void setPladeselskab(String pladeselskab) {
        this.pladeselskab = pladeselskab;
    }

    public String getKunstner() {
        return kunstner;
    }

    public void setKunstner(String kunstner) {
        this.kunstner = kunstner;
    }
}
