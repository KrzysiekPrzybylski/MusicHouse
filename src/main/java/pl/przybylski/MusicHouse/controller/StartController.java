package pl.przybylski.MusicHouse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/start")
public class StartController {

    @GetMapping()
    public String showMainPage() {
        return "start";
    }
}