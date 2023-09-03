package pl.przybylski.MusicHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/app")
public class AppController {

    @GetMapping()
    public String showMainPage() {
        return "app";
    }
}