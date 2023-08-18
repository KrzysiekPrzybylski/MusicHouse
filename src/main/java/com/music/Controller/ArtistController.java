package com.music.Controller;


import com.music.Artist;
import com.music.Service.ArtistService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    private ArtistService artistService;

    @GetMapping
    public String artists(Model model) {
        List<Artist> artists = artistService.getAllArtists();
        model.addAttribute("artists", artists);
        return "artists"; // Thymeleaf template name
    }
    @PostMapping("/add")
    public String addArtist(@ModelAttribute Artist artist) {
        artistService.saveArtist(artist);
        return "redirect:/artists";
    }
}
