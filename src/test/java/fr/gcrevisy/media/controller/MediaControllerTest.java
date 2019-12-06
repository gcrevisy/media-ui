package fr.gcrevisy.media.controller;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import fr.gcrevisy.media.model.metier.Film;
import fr.gcrevisy.media.service.MediaService;

/**
 * MediaControllerTest
 */
public class MediaControllerTest {

    @Test
    public void homeOk() {
        MediaService service = Mockito.mock(MediaService.class);
        Mockito.when(service.getAllFilms()).thenReturn(new ArrayList<Film>());
        Model model = Mockito.mock(Model.class);

        MediaController controller = new MediaController(service);

        controller.home(model);
    }
}