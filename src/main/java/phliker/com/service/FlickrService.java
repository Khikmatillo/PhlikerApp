package phliker.com.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.image.Image;
import phliker.com.controller.PhotoController;
import phliker.com.model.FlickrResponse;
import phliker.com.model.Photo;
import phliker.com.utils.AppProperties;

import java.io.IOException;
import java.net.URL;


/**
 * Created by nsarvar on 2/16/18.
 *
 * Class for retrieving response from API
 * Implements the Service interface
 *
 * @author Khikmatullo Tulkinbekov &lt;mr.khikmatillo@gmail.com&gt;
 *
 */
public class FlickrService implements Service {

    private static String flickrApiKey = AppProperties.getProperty("api_key");
    private final static String flickrApiUrl = "https://api.flickr.com/services/rest/?&method=flickr.photos.search&api_key=" + flickrApiKey +
            "&format=json&nojsoncallback=1&tags=";
    private int total = 0;
    private PhotoController controller;

    /**
     * Constructor for FlickrService
     * @param controller the controller to change <code>fxml</code> content
     */
    public FlickrService(PhotoController controller) {
        this.controller = controller;
    }

    /**
     * search photo method
     * function sends request to server and gets JSON format response
     *
     * @param tags the tag to search by tag
     * @return FlickResponse with array of Photos in json format
     */
    @Override
    public FlickrResponse searchPhoto(String tags) {
        String apiUrl = flickrApiUrl + tags;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode rootNode = mapper.readTree(new URL(apiUrl));
            String stat = rootNode.get("stat").textValue();
            System.out.println("Status: " + stat);
            System.out.println(rootNode.toString());
            if(stat.equals("ok")){
                total = Integer.parseInt(rootNode.findValue("total").textValue());
                JsonNode photoNode = rootNode.findPath("photo");
                if(photoNode.size() > 0){
                    return new FlickrResponse(mapper, photoNode, total);
                }else{
                    //action when 0 result retrieved
                    controller.setTitle("No photo found for tag: " + tags);
                    System.out.println("No photo found for tag: " + tags);
                }
            }else{
                //action when status failed
                controller.setTitle("Failed! Cause: " + rootNode.get("message").toString());
                System.out.println("Failed! Cause: " + rootNode.get("message").toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * method to get Image for ImageView
     * @param photo the requested photo
     * @return Image from link of Photo
     */
    @Override
    public Image getImage(Photo photo) {
        System.out.println("Link: " + photo.getPhotoLink());
        return new Image(photo.getPhotoLink());
    }
}