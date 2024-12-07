package com.ksoft.SocialMediaDownloader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class MainApp extends Application 
{
    public static Stage primaryStage;
    public static void main( String[] args )
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage arg0) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/ksoft/SocialMediaDownloader/MainView.fxml"));
            // StackPane root = new StackPane();
            // Label label = new Label("Social Media Video Downloader");
            // root.getChildren().add(label);

            // Scene scene = new Scene(root, 400, 300);
            Scene scene = new Scene(root);
            primaryStage = arg0;
            arg0.setTitle("Socia Media Video Downloader");
            arg0.setScene(scene);
            arg0.sizeToScene();
            arg0.setResizable(false);
            arg0.show();
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        // throw new UnsupportedOperationException("Unimplemented method 'start'");
    }
}
