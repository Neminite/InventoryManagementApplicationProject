package com.lhaunsp.wguproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Application class that houses the start of the program
 *
 * @author Lucas Haunsperger
 */
public class InventoryManagementApplication extends Application {
    /**
     * The main function that is the entrypoint
     * Javadoc is in a separate zip file
     * FUTURE ENHANCEMENT: Add functionality to save to / load from a file so that data will not be lost
     *
     * @param args any passed arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the application, sets the title, and opens the main menu
     *
     * @param stage the stage of the application
     * @throws IOException if the fxml file can not be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IMSMain.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 375);
        stage.setTitle("Inventory Management Application");
        stage.setScene(scene);
        stage.show();
    }
}
