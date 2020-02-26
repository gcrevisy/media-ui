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

        Collections.sort(result, new Comparator<Film>() {

            @Override
            public int compare(Film o1, Film o2) {
                return o1.getLibelle().compareTo(o2.getLibelle());
            }
        });

        return result;
    }

}