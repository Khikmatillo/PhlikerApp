package phliker.com.service;

import javafx.scene.image.Image;
import phliker.com.model.FlickrResponse;
import phliker.com.model.Photo;


/**
 * Created by nsarvar on 2/15/18.
 */
public class FlickrService implements Service {
    /*
        all API data is stored as hard-coded with variables.
     */
    private static final String SEARCH = "flickr.photos.search";
    private static final String GET_INFO = "flickr.photos.getInfo";
    private final static String flickrApiUrl = "https://api.flickr.com/services/rest";
    private static String flickrApiKey;
    private static String photoSourceUrl = "https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg";
    private boolean debugging;

    public FlickrService() {
    }

    /**
     * search photo method
     *
     * @param tags
     * @return
     */
    @Override
    public FlickrResponse searchPhoto(String tags) {
        return null;
    }

    @Override
    public Image getImage(Photo photo) {
        return null;
    }
}