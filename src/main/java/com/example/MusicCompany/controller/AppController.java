package com.example.MusicCompany.controller;

import com.example.MusicCompany.model.Album;
import com.example.MusicCompany.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/app")
public class AppController {

    @GetMapping()
    public String showMainPage() {
        return "app";
    }
}