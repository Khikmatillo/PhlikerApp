package phliker.com.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import phliker.com.model.FlickrResponse;
import phliker.com.model.Photo;
import phliker.com.model.Photos;
import phliker.com.service.CacheService;
import phliker.com.utils.AppProperties;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by nsarvar on 2/16/18.
 *
 * Class to control <code>FXMl</code> contents
 *
 * @author Khikmatullo Tulkinbekov &lt;mr.khikmatillo@gmail.com&gt;
 *
 */
public class PhotoController {

    // view elements
    @FXML
    TextField searchField;
    @FXML
    ImageView imageView;
    @FXML
    ImageView loaderImageView;
    @FXML
    Button prevButton;
    @FXML
    Button nextButton;
    @FXML
    Label title;
    @FXML
    Label counter;
    private CacheService cacheService;
    private boolean debugging;
    private FlickrResponse flickrResponse;
    private Photos photos;

    /**
     * Constructor for PhotoController
     */
    public PhotoController() {
        debugging = AppProperties.getBool("debug");
        cacheService = new CacheService(this);
        if (debugging) {
            System.out.println("[debug] PhotoController: constructor");
        }
    }

//    @JsonIgnoreProperties(ignoreUnknown = true)

//    Thread loading = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            Platform.runLater(new Runnable() {
//                @Override public void run() {
//                    System.out.println("Running loading");
//                    setTitle("Please wait ...");
//                    loaderImageView.setVisible(true);
//                    loaderImageView.setImage(new Image(new File("src/main/java/images/loading.gif").toURI().toString()));
//                }
//            });
//        }
//    });

    /**
     * method to set text to <code>Textview</code> for Photo name
     * @param text the text that should be set
     */
    public void setTitle(String text){
        title.setText(text);
    }

    /**
     * Methos to load Photo to <code>ImageView</code>
     * @param type the type:
     *             <ul>
     *             <li>1: Current Photo</li>
     *             <li>2: Next Photo</li>
     *             <li>3: Previous Photo</li>
     *             </ul>
     */
    private void loadPhoto(int type){
        if(photos != null){
            Photo photo;
            if(type == 1) photo = photos.getCurrentPhoto();
            else if(type == 2) photo = photos.getNextPhoto();
            else photo = photos.getPrevPhoto();

            imageView.setImage(cacheService.getImage(photo));
            setTitle(photo.getTitle());
            if(title.getText().isEmpty()){
                title.setText("No title");
            }
            int index = photos.getIndex();
            counter.setText(index + " of " + photos.getTotal());
            loaderImageView.setVisible(false);
            if(index == 1) prevButton.setDisable(true);
            else prevButton.setDisable(false);
            if(index == photos.getPhotos().length) nextButton.setDisable(true);
            else nextButton.setDisable(false);

//            loading.interrupt();
        }
    }

    /**
     * method to search image
     * @param event the event when <code>Search</code> button clicked
     */
    @FXML
    private void searchImage(ActionEvent event){

        if(!searchField.getText().isEmpty()){

//            loading.start();

            flickrResponse = cacheService.searchPhoto(searchField.getText());
            if(flickrResponse != null){
                photos = flickrResponse.getPhotos();
                if(photos != null){
                    loadPhoto(1);
                }
            }
        }else{
            title.setText("Enter a tag first");
        }
    }

    /**
     * method to display next Photo
     * @param event the event when <code>Next</code> button clicked
     */
    @FXML
    public void nextImage(ActionEvent event) {
        if(photos != null){
            loadPhoto(2);
        }
    }

    /**
     * Method to display previous Photo
     * @param event the event when <code>Prev</code> button clicked
     */
    @FXML
    public void prevImage(ActionEvent event) {
        if(photos != null){
            loadPhoto(3);
        }
    }
}