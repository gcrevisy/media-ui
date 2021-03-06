package fr.gcrevisy.media.service;

import java.util.List;

import fr.gcrevisy.media.model.metier.Film;

public interface MediaService {

    List<Film> getAllFilms();

    Film saveOrUpdate(Film item);

    Film getById(String id);
}