/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dha.services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hairua's lap
 */
public abstract class BaseServices<T> {
    public abstract List<T> list() throws SQLException;
}
