package com.telusko.ProductSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class URLService {
    @Autowired
    private URLMappingRepository urlMappingRepository;

    public List<URLMapping> getAllURLMappings() {
        return urlMappingRepository.findAll();
    }



    public URLMapping getURLMappingById(Long id) {
        return urlMappingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid URL Mapping ID: " + id));
    }

    public void addURLMapping(URLMapping urlMapping) {
        urlMappingRepository.save(urlMapping);
    }

    public URLMapping getURLMappingByOriginalUrl(String originalUrl) {
        return urlMappingRepository.findByOriginalUrl(originalUrl);
    }

    public void deleteURLMapping(Long id) {
        urlMappingRepository.deleteById(id);
    }
}
