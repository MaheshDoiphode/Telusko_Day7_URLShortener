package com.telusko.ProductSpring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLMappingRepository extends JpaRepository<URLMapping, Long> {

    URLMapping findByOriginalUrl(String originalUrl);

    // Add more custom methods if needed
}
