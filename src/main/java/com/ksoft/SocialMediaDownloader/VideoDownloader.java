package com.ksoft.SocialMediaDownloader;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class VideoDownloader {
    public static void download(String videoUrl, String outputPath) {
        try {
            System.out.println("Téléchargement de la vidéo...");
            FileUtils.copyURLToFile(new URL(videoUrl), new File(outputPath));
            System.out.println("Téléchargement terminé !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
