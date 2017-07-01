/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perpus.jateng.serverperpustakaan.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danang
 */
@Entity
@Table(name = "v_table_buku", catalog = "inlislite_v3", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VTableBuku.findAll", query = "SELECT v FROM VTableBuku v"),
    @NamedQuery(name = "VTableBuku.findByTitle", query = "SELECT v FROM VTableBuku v WHERE v.title = :title"),
    @NamedQuery(name = "VTableBuku.findByAuthors", query = "SELECT v FROM VTableBuku v WHERE v.authors = :authors"),
    @NamedQuery(name = "VTableBuku.findByPublishYear", query = "SELECT v FROM VTableBuku v WHERE v.publishYear = :publishYear"),
    @NamedQuery(name = "VTableBuku.findByName", query = "SELECT v FROM VTableBuku v WHERE v.name = :name"),
    @NamedQuery(name = "VTableBuku.findById", query = "SELECT v FROM VTableBuku v WHERE v.id = :id"),
    @NamedQuery(name = "VTableBuku.findByStatus", query = "SELECT v FROM VTableBuku v WHERE v.status = :status")})
public class VTableBuku implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private double id;
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(nullable = false, length = 700)
    private String title;
    @Column(length = 700)
    private String authors;
    @Column(length = 255)
    private String publishYear;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String name;
    
    @Basic(optional = false)
    @Column(nullable = false, length = 14)
    private String status;

    public VTableBuku() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
