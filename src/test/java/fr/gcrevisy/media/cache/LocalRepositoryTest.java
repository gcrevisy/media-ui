package fr.gcrevisy.media.cache;

import org.junit.Assert;
import org.junit.Test;

public class LocalRepositoryTest {

    @Test
    public void chargerCacheOk() {
        Assert.assertNotNull(LocalRepository.getInstance());
    }

    @Test
    public void getFilmsOk() {
        Assert.assertNotNull(LocalRepository.getInstance().getAllFilms());
    }
}