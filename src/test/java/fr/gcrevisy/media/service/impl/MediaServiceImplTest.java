package fr.gcrevisy.media.service.impl;

import org.junit.Assert;
import org.junit.Test;

public class MediaServiceImplTest {

    @Test
    public void getAllOk() {
        MediaServiceImpl service = new MediaServiceImpl();
        Assert.assertNotNull(service.getAllFilms());
    }

}