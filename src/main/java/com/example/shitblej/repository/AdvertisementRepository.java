package com.example.shitblej.repository;

import com.example.shitblej.model.Advertisement;
import com.example.shitblej.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.shitblej.model.Advertisement.Type;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

}
