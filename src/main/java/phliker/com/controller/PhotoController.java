package phliker.com.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import phliker.com.service.CacheService;
import phliker.com.utils.AppProperties;

/**
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
    CacheService cacheService;
    private boolean debugging;

    public PhotoController() {
        debugging = AppProperties.getBool("debug");

        cacheService = new CacheService();

        if (debugging) {
            System.out.println("[debug] PhotoController: constructor");
        }
    }

    @FXML
    private void searchImage(ActionEvent event) {
        System.out.println(searchField.getText());
    }

    @FXML
    public void nextImage(ActionEvent event) {
        System.out.println(" next button clicked ");
    }

    @FXML
    public void prevImage(ActionEvent event) {
        System.out.println(" prev button clicked ");
    }
}