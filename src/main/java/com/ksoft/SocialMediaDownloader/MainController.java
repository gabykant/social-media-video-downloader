package com.ksoft.SocialMediaDownloader;


import java.io.File;

import com.ksoft.SocialMediaDownloader.Utils.DisplayAlertBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage; 

public class MainController {
    @FXML
    private TextField textUrlVideo;

    @FXML
    private Button btnClearUrlVideo;

    @FXML
    private Button addToDownloadList;
 
    @FXML
    private ListView<String> listUrlToDownload;

    private ObservableList<String> items;

    @FXML
    private TextField textDisplayDirectoryPath;

    @FXML
    private Button btnChooseDirectory;

    @FXML
    private ProgressBar progressBar;
 
    @FXML
    public void initialize() { 
        items = FXCollections.observableArrayList(); 
        if (listUrlToDownload == null) { 
        } else { 
            listUrlToDownload.setItems(items);
        }
    }

    @FXML
    private void clearInputUrlVideo() {
        textUrlVideo.setText(null); 
    }

    @FXML
    private void addToList() {
        String url = textUrlVideo.getText();
        if(!url.isEmpty() && url != null) {
            if (!url.matches("^(http|https)://.*$")) { 
                return;
            }
            
            items.add(url);

            clearInputUrlVideo();
        }
    }

    @FXML
    private void browseDirectory() { 
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose a folder to store your files");
        
        File initialDirectory = new File(System.getProperty("user.home"));
        directoryChooser.setInitialDirectory(initialDirectory);
        
        Stage stage = (Stage) textDisplayDirectoryPath.getScene().getWindow();
        File selectedDirectory = directoryChooser.showDialog(stage);
        
        if (selectedDirectory != null) {
            textDisplayDirectoryPath.setText(selectedDirectory.getAbsolutePath());
        }
    }

    @FXML
    private void startDownload() {
        // String videoUrl = listUrlToDownload.getItems().get(0);
        // String outputPath = textDisplayDirectoryPath.getText();

        Task<Void> backgroundDownloadTask = new Task<>() {

            @Override
            protected Void call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(50); 
                    updateProgress(i, 100); 
                }
                
                return null;
            }
            
        };

        progressBar
            .progressProperty()
            .bind(
                backgroundDownloadTask.progressProperty()
            );

        backgroundDownloadTask.setOnSucceeded(
            event -> DisplayAlertBox.showAlertBox(AlertType.INFORMATION, "Download complete", "Your files are downloaded") );

        Thread backgroundDownloadThread = new Thread(backgroundDownloadTask);
        backgroundDownloadThread.setDaemon(true); 
        backgroundDownloadThread.start();

        DialogPane fDialogPane = new DialogPane();
                fDialogPane.setHeaderText("Alert Info");
                fDialogPane.setContentText("Download finished");
                fDialogPane.setVisible(true);

        // System.out.println(outputPath);
        // VideoDownloader.download(videoUrl, outputPath + "/test.vlc");
    }
}
