package phliker.com.model;


/**
 * Created by nsarvar on 2/16/18.
 *
 * Class for defining a Photos that is collection of Photo
 *
 * @author Khikmatullo Tulkinbekov &lt;mr.khikmatillo@gmail.com&gt;
 *
 */
public class Photos {
    private Photo[] photos;
    private int index;
    private int total;

    /**
     * Constructor to create Photos object
     *
     * @param photos the collection of Photo class
     * @param total the total number of Photos in Response
     */
    public Photos(Photo[] photos, int total){
        this.photos = photos;
        this.total = total;
        index = 0;
        System.out.println("Successfully created " + photos.length + " photos!");
    }

    /**
     * get Photos class as array
     * @return existing all Photos as array
     */
    public Photo[] getPhotos() {
        return photos;
    }

    /**
     * get current Photo to display
     * @return current Photo, default value is the first Photo in collection
     */
    public Photo getCurrentPhoto(){
        return photos[index];
    }

    /**
     * get next Photo to display
     * @return next Photo, if the current Photo is last return itself
     */
    public Photo getNextPhoto(){
        if(index < photos.length){
            index++;
        }
        return photos[index];
    }

    /**
     *  get previous Photo to display
     * @return previous Photo, if the current Photo is first return itself
     */
    public Photo getPrevPhoto(){
        if(index > 0){
            index--;
        }
        return photos[index];
    }

    /**
     * get index of current Photo
     * @return
     */
    public int getIndex() {
        return index + 1;
    }

    /**
     * get total number of Photos in a Response
     * @return total number of Photos
     */
    public int getTotal() {
        return total;
    }
}