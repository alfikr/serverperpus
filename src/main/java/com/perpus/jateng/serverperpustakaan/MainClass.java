/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perpus.jateng.serverperpustakaan;

import com.perpus.jateng.serverperpustakaan.controller.CollectionController;
import com.perpus.jateng.serverperpustakaan.util.JsonTransformer;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 *
 * @author danang
 */
@SpringBootApplication
public class MainClass {

    public static void main(String[] args) {

        initServer();
    }

    public static void initServer() {
        Konfigurasi konfig = Konfigurasi.getInstance();
        CollectionController control = konfig.getContext().getBean(CollectionController.class);
        get("/cari", (req, res) -> {
            // cari data berdasarkan id table collections
            String cari = req.queryParams("cari");
            return control.getCollection(Double.parseDouble(cari));
        }, new JsonTransformer());
        post("/cari", (req, res) -> {
            String key = req.queryParams("key");
            System.out.println("start here");
            System.out.println(req.contentType());
            System.out.println(req.params());
            System.out.println(req.raw());
            System.out.println("stop here");
            Map<String, Object> map = new HashMap<>();
            map.put("key", key);
            return map;
        }, new JsonTransformer());
        exception(IllegalStateException.class, (ex, req, res) -> {
        });
    }
}
