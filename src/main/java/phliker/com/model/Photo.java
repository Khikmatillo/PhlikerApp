package phliker.com.model;

/**
 * Created by nsarvar on 2/16/18.
 *
 * Class for defining a photo with necessary attributes
 *
 * @author Khikmatullo Tulkinbekov &lt;mr.khikmatillo@gmail.com&gt;
 *
 */
public class Photo {
    private String id;
    private String secret;
    private String server;
    private int farm;
    private String title;

    /**
     * Default constructor to create a new Photo
     *
     * Attributes assigned later with help of setter functions
     * */
    public Photo(){}

    /**
     * Function to set id
      * @param id the id of Photo
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Function to set secret
     * @param secret the secret field of Photo
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * Function to set server
     * @param server the server field of Photo
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * Function to set farm
     * @param farm the farm field of Photo
     */
    public void setFarm(int farm) {
        this.farm = farm;
    }

    /**
     * Function to set title
     * @param title the title field of Photo
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Function to get id
     * @return id of the Photo
     */
    public String getId() {
        return id;
    }

    /**
     * Function to get title
     * @return title of Photo
     */
    public String getTitle() {
        return title;
    }

    /**
     * Function generate a link for Photo using it's <code>farm</code>, <code>server</code>, <code>id</code> and <code>secret</code> fields
     * @return link for Photo
     */
    public String getPhotoLink(){
        return "https://farm" + farm + ".staticflickr.com/" + server + "/" + id + "_" + secret + ".jpg";
    }
}