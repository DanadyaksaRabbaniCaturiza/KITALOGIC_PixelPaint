/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import database.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class WallpaperPublic extends Wallpaper implements GalleryProvider{
    
    public WallpaperPublic() {
     super();
    }
    
    public List<Wallpaper> getGalleryWallpaper(int userId) {
        List<Wallpaper> list = new ArrayList<>();
        
        String query = "SELECT * FROM artworks ORDER BY id DESC";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            
           ResultSet rs = pstmt.executeQuery();
          
                while (rs.next()) {
                    Wallpaper wp = new Wallpaper();
                    wp.setId(rs.getInt("id"));
                    wp.setTitle(rs.getString("title"));
                    wp.setDescription(rs.getString("description"));
                    wp.setCategory(rs.getString("category"));
                    wp.setImagePath(rs.getString("image_path"));
                    wp.setUserId(rs.getInt("user_id"));
                    wp.setTimeAdded(rs.getString("created_at"));
                    list.add(wp);
                }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
        
    }  
}
