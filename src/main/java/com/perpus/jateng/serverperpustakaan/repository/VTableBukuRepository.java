/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perpus.jateng.serverperpustakaan.repository;

import com.perpus.jateng.serverperpustakaan.pojo.VTableBuku;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danang
 */
@Repository
public interface VTableBukuRepository extends PagingAndSortingRepository<VTableBuku,Double> {
    
}
