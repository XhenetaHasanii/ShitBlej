package com.example.shitblej.controller;

import com.example.shitblej.model.Advertisement;
import com.example.shitblej.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {

  private final AdvertisementService adService;

  @Autowired
  public AdvertisementController(AdvertisementService adService) {
    this.adService = adService;
  }


  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> postAdvertisement(@RequestBody Advertisement adRequest) {
    Advertisement adResponse = adService.create(adRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(adResponse);
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getAdvertisement(@PathVariable final Long id) {
    if (id < 0) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
    }

    Advertisement ad = adService.get(id);
    if (ad == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no data");
    }

    return ResponseEntity.status(HttpStatus.OK).body(ad);
  }
}
