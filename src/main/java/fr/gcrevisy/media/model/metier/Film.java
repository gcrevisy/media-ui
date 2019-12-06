package fr.gcrevisy.media.model.metier;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.gcrevisy.media.model.technique.Model;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Film implements Model {

    private static final long serialVersionUID = 1L;
    private String id;
    private String libelle;
    private String support;
    private String annee;

    public Film() {

    }

    public Film(String id, String libelle, String support, String annee) {
        this.id = id;
        this.libelle = libelle;
        this.support = support;
        this.annee = annee;
    }

    public Film(String libelle, String support, String annee) {
        this.libelle = libelle;
        this.support = support;
        this.annee = annee;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getSupport() {
        return this.support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getAnnee() {
        return this.annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Film)) {
            return false;
        }
        Film film = (Film) o;
        return Objects.equals(id, film.id) && Objects.equals(libelle, film.libelle)
                && Objects.equals(support, film.support) && Objects.equals(annee, film.annee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle, support, annee);
    }

}