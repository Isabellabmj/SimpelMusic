package com.example.simpelmusic.Controller;

import com.example.simpelmusic.Model.Album;
import com.example.simpelmusic.Service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//lagdelt arkitektur, vi bruger Controller-laget, Service-laget og Repository-laget.

@Controller
public class HomeController //Get, betyder at vi henter data)
{
    @Autowired
    private AlbumService albumService; //Spring injecter, Autowired opretter en instans af AlbumService, så vi kan bruge Service laget uden at oprette instans manuelt

    @GetMapping("/") //denne metode bliver kalt, når vi besøger vores hjemmesides root(/)
    public String showAllAlbums(Model model)
    {
        List<Album> albums = albumService.getAllAlbums(); //henter alle albums der ligger i service laget
        model.addAttribute("albums", albums); //lægger listen af albums i model-objekter, så Thymeleaf kan bruge dem
        return "home/index"; //returnerer til Thymeleaf-template "home/index"
    }

    @GetMapping("/addAlbum")
    public String addAlbumForm(Model model)
    {
        model.addAttribute("album", new Album()); //opretter et tomt album-objekt
        return "addAlbum/album"; //viser formularen i album.html
    }

    @PostMapping("/saveAlbum") //Post betyder at vi til at sende data til serveren
    public String saveAlbum(@ModelAttribute Album album)
    {
        albumService.addAlbum(album); //sender albummet videre til service laget, som gemmer det i databasen
        return "redirect:/"; //vi bliver sendt tilbage til forsiden.
    }
}
