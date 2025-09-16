/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dha.services;

import com.dha.pojo.Word;
import com.dha.utils.MyConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author hairua's lap
 */
public class UpdateWordServices {

    public boolean addWord(Word w) throws SQLException {
        String sql = "INSERT INTO word(vietnamese,english) VALUE(?,?)";

        try (Connection conn = MyConnector.getInstance().getConnect(); PreparedStatement stm = conn.prepareCall(sql)) {
            stm.setString(1, w.getVietnamese());
            stm.setString(2, w.getEnglish());
            return stm.executeUpdate() > 0;
        }
    }
    
    public boolean delWord(int id) throws SQLException{
        String sql = "DELETE FROM word WHERE id = ?";
        try(Connection conn = MyConnector.getInstance().getConnect(); PreparedStatement stm = conn.prepareStatement(sql)){
            stm.setInt(1, id);

            return stm.executeUpdate() > 0;
        } 
        
    }
}
