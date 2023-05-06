package com.laopao.blog.controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Description:
 * @Title: AsyncDownloadFile
 * @Package com.laopao.blog.controller
 * @Author: zhaozhiyong
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2023/5/2 15:02
 */
public class AsyncDownloadFile {

    public static CompletableFuture<Void> downloadFileAsync(String fileUrl, String outputFile) {
        return CompletableFuture.runAsync(() -> {
            try (BufferedInputStream in = new BufferedInputStream(new URL(fileUrl).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
                byte[] dataBuffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            } catch (IOException e) {
                System.err.println("Error occurred while downloading file: " + e.getMessage());
            }
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Starting download...");

        CompletableFuture<Void> future = downloadFileAsync(
                "https://speed.hetzner.de/100MB.bin",
                "D:\\test");

        // Do some other tasks while downloading file
        System.out.println("Doing some other tasks...");

        future.get(); // Wait for the download to complete

        System.out.println("Download completed!");
    }

}
