package fr.gcrevisy.media.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import fr.gcrevisy.media.cache.LocalRepository;
import fr.gcrevisy.media.model.metier.Film;
import fr.gcrevisy.media.model.technique.FilmsJson;
import fr.gcrevisy.media.service.MediaService;

/**
 * MediaService
 */
@Service
public class MediaServiceImpl implements MediaService {

    private Logger logger = LoggerFactory.getLogger(MediaServiceImpl.class);
    private static boolean restAvailable;

    public MediaServiceImpl() {
        restAvailable = true;
    }

    @Override
    public List<Film> getAllFilms() {
        List<Film> result = new ArrayList<>();

        if (restAvailable)

            try {
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<FilmsJson> results = restTemplate.getForEntity("http://localhost:9090/films",
                        FilmsJson.class);
                // exchange("UriBuilder.buildUri(contexte)", HttpMethod.GET, null,
                // FilmsJson.class);
                result.addAll(results.getBody().getFilms());

            } catch (RestClientException ex) {
                logger.error("Services REST indisponibles");
                restAvailable = false;
                result = LocalRepository.getInstance().getAllFilms();
            }
        else {
            result = LocalRepository.getInstance().getAllFilms();
        }
        /**
         * result.add(new Film("2 days in New York", "DVD", "")); result.add(new
         * Film("Django Unchained", "DVD", "")); result.add(new Film("Brave", "DVD",
         * "")); result.add(new Film("Looper", "DVD", "")); result.add(new Film("Star
         * Trek into darkness", "DVD", "")); result.add(new Film("Star Trek", "DVD",
         * "")); result.add(new Film("Silver linings", "DVD", "")); result.add(new
         * Film("Beautiful creatures", "DVD", "")); result.add(new Film("Pacific rim",
         * "DVD", "")); result.add(new Film("Hobbit : an unexpected journey", "DVD",
         * "")); result.add(new Film("Princess bride", "DVD", "")); result.add(new
         * Film("The Dark Knight", "DVD", "")); result.add(new Film("Public enemies",
         * "DVD", "")); result.add(new Film("Avengers", "DVD", "")); result.add(new
         * Film("Shutter Island", "DVD", "")); result.add(new Film("Inception", "DVD",
         * "")); result.add(new Film("Gatsby", "DVD", "")); result.add(new Film("J
         * Edgar", "DVD", "")); result.add(new Film("Les infiltrés", "DVD", ""));
         * result.add(new Film("Sweeney Todd", "DVD", "")); result.add(new Film("Harry
         * Potter et l'école des sorciers", "DVD", "")); result.add(new Film("Harry
         * Potter et la chambre des sercrets", "DVD", "")); result.add(new Film("Harry
         * Potter et le prisionner d'Azkaban", "DVD", "")); result.add(new Film("Harry
         * Potter et la coupe de feu", "DVD", "")); result.add(new Film("Harry Potter et
         * l'Ordre du Phoenix", "DVD", "")); result.add(new Film("Harry Potter et le
         * Prince de sang mélé", "DVD", "")); result.add(new Film("Harry Potter et les
         * reliques de la mort (Pt 1)", "DVD", "")); result.add(new Film("Harry Potter
         * et les reliques de la mort (Pt 2)", "DVD", "")); result.add(new Film("007 :
         * Skyfall", "DVD", "")); result.add(new Film("007 : Casino Royal", "DVD", ""));
         * result.add(new Film("007 : Quantum of Solace", "DVD", "")); result.add(new
         * Film("Le secret des poignards volants", "DVD", "")); result.add(new Film("500
         * jours ensemble", "DVD", "")); result.add(new Film("Usual Suspects", "DVD",
         * "")); result.add(new Film("Shrek 2", "DVD", "")); result.add(new Film("Le
         * marchand de Venise", "DVD", "")); result.add(new Film("2012", "DVD", ""));
         * result.add(new Film("Pluie d'enfer", "DVD", "")); result.add(new
         * Film("Constantine", "DVD", "")); result.add(new Film("L'exorciste", "DVD",
         * "")); result.add(new Film("Les fugitifs", "DVD", "")); result.add(new
         * Film("Le cercle", "DVD", "")); result.add(new Film("Merlin l'enchanteur",
         * "DVD", "")); result.add(new Film("Wall Street", "DVD", "")); result.add(new
         * Film("Sin City", "DVD", "")); result.add(new Film("Les incorruptibles",
         * "DVD", "")); result.add(new Film("Exitenze", "DVD", "")); result.add(new
         * Film("Ca", "DVD", "")); result.add(new Film("Monsieur N.", "DVD", ""));
         * result.add(new Film("Les infiltrés", "DVD", "")); result.add(new
         * Film("Fantasia", "DVD", "")); result.add(new Film("The green hornet", "DVD",
         * "")); result.add(new Film("Le chacal", "DVD", "")); result.add(new Film("Le
         * nom de la rose", "DVD", "")); result.add(new Film("Requiem for a dream",
         * "DVD", "")); result.add(new Film("Van Helsing", "DVD", "")); result.add(new
         * Film("The Dark Knight rises", "DVD", "")); result.add(new Film("Hell", "DVD",
         * "")); result.add(new Film("Shoot 'em up", "DVD", "")); result.add(new
         * Film("Walk the line", "DVD", "")); result.add(new Film("Happy go lucky",
         * "DVD", "")); result.add(new Film("Ghost world", "DVD", "")); result.add(new
         * Film("The Queen", "DVD", "")); result.add(new Film("In the loop", "DVD",
         * "")); result.add(new Film("American beauty", "DVD", "")); result.add(new
         * Film("Frost / Nixon", "DVD", "")); result.add(new Film("In Bruges", "DVD",
         * "")); result.add(new Film("Raison et sentiments", "DVD", "")); result.add(new
         * Film("Identity", "DVD", "")); result.add(new Film("Ed Wood", "DVD", ""));
         * result.add(new Film("Edward aux mains d'argent", "DVD", "")); result.add(new
         * Film("L'étrange Noël de Mister Jack", "DVD", "")); result.add(new
         * Film("Aviator", "DVD", "")); result.add(new Film("Watchmen", "DVD", ""));
         * result.add(new Film("L'amée des 12 singes", "DVD", "")); result.add(new
         * Film("Beetlejuice", "DVD", "")); result.add(new Film("L'assassinat de Jesse
         * James", "DVD", "")); result.add(new Film("Le nom des gens", "DVD", ""));
         * result.add(new Film("Made in Dagenhan", "DVD", "")); result.add(new
         * Film("Hook", "DVD", "")); result.add(new Film("True Grit", "DVD", ""));
         * result.add(new Film("Death proof", "DVD", "")); result.add(new Film("Le
         * chateau dans le ciel", "DVD", "")); result.add(new Film("Charlie et la
         * chocolatrie", "DVD", "")); result.add(new Film("The expendables", "DVD",
         * "")); result.add(new Film("Coup de foudre à Bollywood", "DVD", ""));
         * result.add(new Film("Sherlock Holmes", "DVD", "")); result.add(new
         * Film("Sherlock Holmes : jeu d'ombres", "DVD", "")); result.add(new Film("The
         * social network", "DVD", "")); result.add(new Film("Robin des bois", "DVD",
         * "")); result.add(new Film("Boulevard de la mort", "DVD", "")); result.add(new
         * Film("Les desastreuses aventures des orphelins Beaudelaire", "DVD", ""));
         * result.add(new Film("The King's speech", "DVD", "")); result.add(new
         * Film("Eternal sunshine of the spotless mind", "DVD", "")); result.add(new
         * Film("Gran torino", "DVD", "")); result.add(new Film("Bowling for colombine",
         * "DVD", "")); result.add(new Film("Les fils de l'homme", "DVD", ""));
         * result.add(new Film("Invictus", "DVD", "")); result.add(new Film("Orgueil et
         * préjugés", "DVD", "")); result.add(new Film("Priceless", "DVD", ""));
         * result.add(new Film("La vérité nue", "DVD", "")); result.add(new
         * Film("Mansfielf park", "DVD", "")); result.add(new Film("A passage to India",
         * "DVD", "")); result.add(new Film("Jane Eyre", "DVD", "")); result.add(new
         * Film("Elizabeth", "DVD", "")); result.add(new Film("Elizabeth, the golden
         * age", "DVD", "")); result.add(new Film("Marie-Antoinette", "DVD", ""));
         * result.add(new Film("Three times", "DVD", "")); result.add(new
         * Film("Elephant", "DVD", "")); result.add(new Film("Plup fiction", "DVD",
         * "")); result.add(new Film("Gladiator", "DVD", "")); result.add(new Film("2
         * days in Paris", "DVD", "")); result.add(new Film("Shakespeare in love",
         * "DVD", "")); result.add(new Film("In her shoes", "DVD", "")); result.add(new
         * Film("Escrocs mais pas trop", "DVD", "")); result.add(new Film("H2G2, le
         * guide du voyageur galactique", "DVD", "")); result.add(new Film("Little miss
         * sunshine", "DVD", "")); result.add(new Film("Les laisons dangereuses", "DVD",
         * "")); result.add(new Film("Virgin suicides", "DVD", "")); result.add(new
         * Film("Lost in translation", "DVD", "")); result.add(new Film("Gwen", "DVD",
         * "")); result.add(new Film("Dark crystal", "DVD", "")); result.add(new
         * Film("Kingdom of heaven", "DVD", "")); result.add(new Film("Lolita", "DVD",
         * "")); result.add(new Film("King Lear", "DVD", "")); result.add(new Film("Les
         * noces funèbres", "DVD", "")); result.add(new Film("Mon voisin Totoro", "DVD",
         * "")); result.add(new Film("Le chateau ambulant", "DVD", "")); result.add(new
         * Film("La ligue des gentlemen extraordinaires", "DVD", ""));
         */
        Collections.sort(result, new Comparator<Film>() {

            @Override
            public int compare(Film o1, Film o2) {
                return o1.getLibelle().compareTo(o2.getLibelle());
            }
        });

        return result;
    }

}