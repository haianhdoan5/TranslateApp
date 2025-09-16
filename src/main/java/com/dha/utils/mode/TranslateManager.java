/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dha.utils.mode;

import javafx.scene.Scene;

/**
 *
 * @author hairua's lap
 */
public class TranslateManager {
    private static ITranslate translateFactory ;
    private static IThemes themesFactory;
    
    public static void setTranslateFactory(ITranslate nTranslateFactory){
        
        translateFactory= nTranslateFactory;
    }
    public static void setThemesFactory(IThemes theme){
        themesFactory= theme;
    }
    
    public static void applyThemes(Scene s){
        s.getRoot().getStylesheets().clear();
        s.getRoot().getStylesheets().add(themesFactory.getStyleSheet());
        
    }
}
