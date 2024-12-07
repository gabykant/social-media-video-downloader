package com.ksoft.SocialMediaDownloader.Utils;

import com.ksoft.SocialMediaDownloader.MainApp;

import javafx.scene.control.Alert;

public class DisplayAlertBox {
    public static void showAlertBox( Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        alert.initOwner(MainApp.primaryStage);
        alert.showAndWait();
    }
}
