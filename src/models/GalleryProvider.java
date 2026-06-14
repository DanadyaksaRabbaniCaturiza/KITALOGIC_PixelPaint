/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package models;

import java.util.List;

/**
 *
 * @author user
 */
public interface GalleryProvider {
    //abstract method
    List<Wallpaper> getGalleryWallpaper(int userId);
}
