package com.example.shitblej.service;

import com.example.shitblej.model.Advertisement;
import com.example.shitblej.model.Category;
import com.example.shitblej.model.User;
import com.example.shitblej.repository.AdvertisementRepository;
import com.example.shitblej.repository.CategoryRepository;
import com.example.shitblej.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {

  private final AdvertisementRepository adRepository;
  private final CategoryRepository categoryRepository;
  private final UserRepository userRepository;

  @Autowired
  public AdvertisementService(AdvertisementRepository adRepository,
      CategoryRepository categoryRepository,
      UserRepository userRepository) {
    this.adRepository = adRepository;
    this.categoryRepository = categoryRepository;
    this.userRepository = userRepository;
  }

  public Advertisement create(Advertisement ad) {
    Category categoryEntity = categoryRepository.findById(ad.getCategory().getId()).orElse(null);
    User userEntity = userRepository.findById(ad.getUser().getId()).orElse(null);
    Advertisement persistedAd = adRepository.save(new Advertisement(ad.getType(), categoryEntity, userEntity,ad.getTitle(),ad.getDescription(),ad.getPrice(),ad.getLocation()));
    return persistedAd;
  }

  public Advertisement get(Long id) {
    Advertisement ad = adRepository.findById(id).orElse(null);
    if (ad == null) {
      return null;
    }
    return ad;
  }


}
