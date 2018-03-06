package phliker.com.service;

import javafx.scene.image.Image;
import phliker.com.model.FlickrResponse;
import phliker.com.model.Photo;

/**
 * Created by nsarvar on 2/20/18.
 */
public class CacheService implements Service {

    private Service flickrService;

    public CacheService() {
        flickrService = new FlickrService();
    }

    // don't change this method
    @Override
    public FlickrResponse searchPhoto(String tags) {
        return flickrService.searchPhoto(tags);
    }

    @Override
    public Image getImage(Photo photo) {
        return null;
    }
}