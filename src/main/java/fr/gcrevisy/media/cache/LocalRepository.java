package fr.gcrevisy.media.cache;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.gcrevisy.media.model.metier.Film;

public class LocalRepository {
    private Logger logger;
    private static LocalRepository repository;
    private List<Film> films;

    private LocalRepository() {
        logger = LoggerFactory.getLogger(LocalRepository.class);
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream(rootPath + "fr/gcrevisy/media/cache/LocalRepository.properties");
            prop.load(input);
        } catch (IOException e) {
            logger.error("Erreur pendant le chargement des proprietes", e);
        }
        String path = prop.getProperty("cacheLocation");
        if (StringUtils.isBlank(path))
            path = "C:\\MongoDB\\LocalRepository.data";
        films = chargerCache(path);
    }

    public static LocalRepository getInstance() {
        if (repository == null) {
            repository = new LocalRepository();
        }
        return repository;
    }

    public List<Film> getAllFilms() {
        return films;
    }

    protected List<Film> chargerCache(String repositoryPath) {
        List<Film> result = new ArrayList<Film>();

        try {

            if (!Files.exists(Paths.get(repositoryPath))) {
                creerRepository(repositoryPath, result);
            }

            FileInputStream fis = new FileInputStream(repositoryPath);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object o = ois.readObject();

            if (o instanceof List) {
                result = (List<Film>) o;
            }

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    protected void creerRepository(String repositoryPath, List<Film> liste) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(repositoryPath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(liste);
        oos.close();
        fos.close();
    }
}