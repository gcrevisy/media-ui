package fr.gcrevisy.media.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.gcrevisy.media.service.MediaService;

@Controller
public class MediaController {
    private Logger logger;

    @Autowired
    private MediaService mediaService;

    public MediaController() {
        logger = LoggerFactory.getLogger(MediaController.class);
    }

    public MediaController(MediaService service) {
        this();
        mediaService = service;
    }

    @GetMapping(value = "/")
    public String home(Model model) {
        logger.info("Entree dans la methode MediaController#home : " + model.toString());

        model.addAttribute("films", mediaService.getAllFilms());

        return "home";
    }

    @GetMapping(value = "/details/")
    public String details(Model model) {
        logger.info("Entree dans la methode MediaController#home : " + model.toString());

        model.addAttribute("films", mediaService.getAllFilms());

        return "home";
    }
}