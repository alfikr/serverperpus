/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perpus.jateng.serverperpustakaan.controller;

import com.perpus.jateng.serverperpustakaan.pojo.VTableBuku;
import com.perpus.jateng.serverperpustakaan.service.ServiceCollections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author danang
 */
@Controller
public class CollectionController {
    private @Autowired ServiceCollections service;
    public Map<String,Object> cariData(String data){
        Map<String,Object> map = new HashMap<>();
        return map;
    }
    public VTableBuku getCollection(double id){
        return service.dataMap(id);
    }
}
