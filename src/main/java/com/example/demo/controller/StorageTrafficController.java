/**
 * @author 12432
 * @date 2023/05/30
 */
package com.example.demo.controller;

import com.example.demo.dto.InOutNumber;
import com.example.demo.service.StorageTrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage-traffic")
public class StorageTrafficController {

    private final StorageTrafficService storageTrafficService;

    public StorageTrafficController(StorageTrafficService storageTrafficService) {
        this.storageTrafficService = storageTrafficService;
    }

    @GetMapping("/inout-number")
    public InOutNumber[] inoutNumberData(@RequestParam int id) {
        InOutNumber[] inoutNumberData = storageTrafficService.inoutNumberData(id);
        return inoutNumberData;
    }

    @GetMapping("/type-sale-data")
    public int[] typeSaleData(@RequestParam int id) {
        int[] typeSaleData = storageTrafficService.typeSaleData(id);
        return typeSaleData;
    }

    @GetMapping("/type-data")
    public String[] typeData(@RequestParam int id) {
        String[] typeData = storageTrafficService.typeData(id);
        return typeData;
    }
}
