/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dha.services;

import com.dha.pojo.Word;
import com.dha.utils.MyConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hairua's lap
 */
public class WordServices extends BaseServices<Word>{

    @Override
    public List<Word> list() throws SQLException {
        Connection conn = MyConnector.getInstance().getConnect();
        PreparedStatement stm = conn.prepareCall("SELECT * FROM word");
        ResultSet rs = stm.executeQuery();
        List<Word> words = new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("id");
            String vietnamese = rs.getString("vietnamese");
            String english = rs.getString("english");
            
            Word w = new Word(id,vietnamese,english);
            words.add(w);
        }
        
        return words;
    }
    
}
