/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perpus.jateng.serverperpustakaan.service;

import com.perpus.jateng.serverperpustakaan.pojo.VTableBuku;
import com.perpus.jateng.serverperpustakaan.repository.VTableBukuRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 *
 * @author danang
 */
@Service
public class ServiceCollections {
    private @Autowired VTableBukuRepository colDao;
    
    public Page<Collection> cariData(String data){
        return null;
    }
    public VTableBuku dataMap(double ID){
        return colDao.findOne(ID);
    }
}
