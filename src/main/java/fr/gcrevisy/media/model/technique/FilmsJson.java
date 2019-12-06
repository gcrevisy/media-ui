package fr.gcrevisy.media.model.technique;

import java.util.List;

import fr.gcrevisy.media.model.metier.Film;

/**
 * FilmsJson
 */
public class FilmsJson {

    private List<Film> films;

    public FilmsJson() {
    }

    public FilmsJson(List<Film> films) {
        this.films = films;
    }

    public List<Film> getFilms() {
        return this.films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

}