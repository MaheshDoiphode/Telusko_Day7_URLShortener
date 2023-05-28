package com.telusko.ProductSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/url")
public class URLController {

    @Autowired
    private URLGenerate urlGenerate;

    @Autowired
    private URLService urlService;

    @GetMapping
    public List<URLMapping> getAllURLMappings() {
        return urlService.getAllURLMappings();
    }


    @PostMapping
    public String addURLMapping(@RequestBody URLMapping urlMapping) {
        String originalUrl = urlMapping.getOriginalUrl();
        String shortenedUrl = urlGenerate.generateURL(originalUrl);
        urlMapping.setShortenedUrl(shortenedUrl);
        urlService.addURLMapping(urlMapping);
        return shortenedUrl;
    }

}
