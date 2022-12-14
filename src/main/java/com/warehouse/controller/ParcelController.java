package com.warehouse.controller;


import com.lowagie.text.DocumentException;
import com.warehouse.entity.Parcel;
import com.warehouse.service.ParcelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/parcels")
@AllArgsConstructor
public class ParcelController {

    private final ParcelService parcelService;

    @PostMapping
    public String addParcel(@RequestBody Parcel parcel) throws Exception {
        return parcelService.save(parcel);
    }

    @GetMapping
    public List<Parcel> getAll() {
        return parcelService.findAll();
    }

    @GetMapping("/{id}")
    public Parcel findById(@PathVariable Long id) {
        return parcelService.findById(id);
    }

    @GetMapping("/{id}/label")
    public void exportParcelByIdToPdf(HttpServletResponse response, @PathVariable Long id) throws Exception {
        parcelService.exportParcelToPdfById(response, id);
    }

    @GetMapping("/{id}/csv")
    public void exportPostByIdToCSV(HttpServletResponse response, @PathVariable Long id) throws DocumentException,
            IOException {
        parcelService.exportParcelToCSVById(response, id);
    }

}
