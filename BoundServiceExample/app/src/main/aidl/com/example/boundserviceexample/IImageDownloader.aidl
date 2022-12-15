// IImageDownloader.aidl
package com.example.boundserviceexample;

// Declare any non-default types here with import statements

interface IImageDownloader {
    String downloadImage(in String link);
}