package phliker.com.model;

/**
 * Created by nsarvar on 2/16/18.
 */
public class Photo {
    private String id;
    private String link;
    private String title;
    private Photo prevPhoto;
    private Photo nextPhoto;

    public Photo(String id, String link, String title, Photo prevPhoto, Photo nextPhoto) {
        this.id = id;
        this.link = link;
        this.title = title;
        this.prevPhoto = prevPhoto;
        this.nextPhoto = nextPhoto;
    }

    public String getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public Photo getPrevPhoto() {
        return prevPhoto;
    }

    public Photo getNextPhoto() {
        return nextPhoto;
    }

    public void setNextPhoto(Photo nextPhoto) {
        this.nextPhoto = nextPhoto;
    }
}