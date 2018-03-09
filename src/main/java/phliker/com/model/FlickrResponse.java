package phliker.com.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by nsarvar on 2/16/18.
 *
 * Class for defining Response from server.
 * Response is an JsonArray of Photos
 *
 * @author Khikmatullo Tulkinbekov &lt;mr.khikmatillo@gmail.com&gt;
 *
 */
public class FlickrResponse {

    private ObjectMapper objectMapper;
    private JsonNode jsonNode;
    private int total;

    /**
     * Constructor for FlickrResponse
     *
     * @param objectMapper object mapper to map Json Array to Photo objects
     * @param jsonNode JsonNode contains json array of Photos
     * @param total total number of Photos in response
     */
    public FlickrResponse(ObjectMapper objectMapper, JsonNode jsonNode, int total){
        this.objectMapper = objectMapper;
        this.jsonNode = jsonNode;
        this.total = total;
    }

    /**
     * get Photos by parsing JsonArray to photo objects
     * @return Photos class by parsing JsonNode
     */
    public Photos getPhotos(){
        int len = jsonNode.size();
        try{
            Photo[] photos = new Photo[len];
            for(int i = 0; i < len; i++){
                photos[i] = objectMapper.readValue(jsonNode.get(i).toString(), Photo.class);
            }
            System.out.println("Size of photos: " + photos.length);
            return new Photos(photos, total);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
