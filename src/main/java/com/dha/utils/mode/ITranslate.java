/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dha.utils.mode;

import com.dha.pojo.Word;
import java.util.List;

/**
 *
 * @author hairua's lap
 */
public interface ITranslate {
    String translated(String wordTrans,List<Word> dictionary);
    
}
