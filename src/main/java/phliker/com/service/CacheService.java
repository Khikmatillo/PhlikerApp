package phliker.com.service;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import phliker.com.controller.PhotoController;
import phliker.com.model.FlickrResponse;
import phliker.com.model.Photo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nsarvar on 2/16/18.
 *
 * Class for checking the cache if requested Photo exists already, if not retrieving response from API
 * Implements the Service interface
 *
 * @author Khikmatullo Tulkinbekov &lt;mr.khikmatillo@gmail.com&gt;
 *
 */
public class CacheService implements Service {

    private Service flickrService;
    private Map<String, Map<String, Image>> cachedResults;
    private Map<String, FlickrResponse> cachedResponses;
    private String tags;

    /**
     * Constructor for CacheService
     * @param controller the controller to change <code>fxml</code> content
     */
    public CacheService(PhotoController controller) {
        flickrService = new FlickrService(controller);
        cachedResults = new HashMap<>();
        cachedResponses = new HashMap<>();
    }

    /**
     * method to search photo by tag
     * If searching tag is already searched then return it from cache
     * If not, return GET it from API
     * @param tags the tags to search by tag
     * @return FilckrResponse containing Photo Array in JSON format
     */
    @Override
    public FlickrResponse searchPhoto(String tags) {
        this.tags = tags;
        if(cachedResults.containsKey(tags)){
            return cachedResponses.get(tags);
        }else{
            FlickrResponse flickrResponse = flickrService.searchPhoto(tags);
            cachedResponses.put(tags, flickrResponse);
            cachedResults.put(tags, new HashMap<String, Image>());
            return flickrResponse;
        }
    }

    /**
     * Method to get Image
     * If Image is already seen, retur it from cache, if not from server
     *
     * @param photo the requested photo
     * @return Image from link of Photo
     */
    @Override
    public Image getImage(Photo photo) {
        if(cachedResults.get(tags).containsKey(photo.getId())){
            return cachedResults.get(tags).get(photo.getId());
        }else{
            Image image = flickrService.getImage(photo);
            cachedResults.get(tags).put(photo.getId(), image);
            return image;
        }
    }
}