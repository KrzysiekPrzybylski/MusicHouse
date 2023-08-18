package com.music.Controller;

import com.music.Album;
import com.music.Repository.AlbumRepository;
import com.music.Repository.ArtistRepository;
import com.music.Service.AlbumService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping
    public String albums(Model model) {
        List<Album> albums = albumService.getAllAlbums();
        model.addAttribute("albums", albums);
        return "albums"; // Thymeleaf template name
    }


    private ArtistRepository artistRepository;
}
