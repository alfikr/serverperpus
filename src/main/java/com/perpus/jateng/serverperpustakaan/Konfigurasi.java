/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perpus.jateng.serverperpustakaan;

import com.perpus.jateng.serverperpustakaan.config.SpringKonfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author danang
 */
public class Konfigurasi {
    private static Konfigurasi instance;
    private final ApplicationContext context;
    public Konfigurasi() {
        context = new AnnotationConfigApplicationContext(SpringKonfig.class);
        
    }
    public ApplicationContext getContext(){
        return context;
    }
    
    
    public static Konfigurasi getInstance(){
        if(instance==null){
            instance=new Konfigurasi();
        }
        return instance;
    }
}
