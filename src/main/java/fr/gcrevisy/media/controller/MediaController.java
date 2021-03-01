package fr.gcrevisy.media.controller;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping(value = "/details/{id}")
    public String details(@PathVariable("id") String id) {
        logger.info("Entree dans la methode MediaController#details : " + id.toString());

        // model.addAttribute("films", mediaService.);

        return "/details";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        logger.info("Entree dans la methode MediaController#delete : " + id.toString());

        // model.addAttribute("films", mediaService.);

        return "home";
    }
}