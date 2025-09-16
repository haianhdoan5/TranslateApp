/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dha.utils.mode;

import com.dha.pojo.Word;
import com.dha.translateapp.App;
import java.util.List;

/**
 *
 * @author hairua's lap
 */
public class En_VieTranslateFactory implements ITranslate{

    @Override
    public String translated(String wordTrans, List<Word> dictionary) {
        for(var w:dictionary){
            if(w.getEnglish().equals(wordTrans))
                return w.getVietnamese();    
        }
        return " khong tim thay";
    }

    
    
}
