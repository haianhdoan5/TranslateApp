/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dha.utils.mode;

import com.dha.translateapp.App;

/**
 *
 * @author hairua's lap
 */
public class Vie_EnThemesFactory implements IThemes{
    @Override
    public String getStyleSheet() {
        return App.class.getResource("styles.css").toExternalForm();
    }
}
