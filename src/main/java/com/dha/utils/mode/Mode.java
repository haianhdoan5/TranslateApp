/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.dha.utils.mode;

import javafx.scene.Scene;

/**
 *
 * @author hairua's lap
 */
public enum Mode {
    Anh_Viet {
        @Override
        public void updateTheme(Scene s) {
            TranslateManager.setThemesFactory(new En_VieThemesFactory());
            TranslateManager.applyThemes(s);
        }
    },Viet_Anh {

        @Override
        public void updateTheme(Scene s) {
            TranslateManager.setThemesFactory(new Vie_EnThemesFactory());
            TranslateManager.applyThemes(s);
        }
    };
    
    public abstract void updateTheme(Scene s);
    
}
