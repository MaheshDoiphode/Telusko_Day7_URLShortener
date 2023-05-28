package com.telusko.ProductSpring;

import jakarta.persistence.*;

@Entity(name = "url_mapping")
public class URLMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String originalUrl;
    private String shortenedUrl;

    public URLMapping() {
    }

    public URLMapping(String originalUrl, String shortenedUrl) {
        this.originalUrl = originalUrl;
        this.shortenedUrl = shortenedUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortenedUrl() {
        return shortenedUrl;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    @Override
    public String toString() {
        return "URLMapping{" +
                "id=" + id +
                ", originalUrl='" + originalUrl + '\'' +
                ", shortenedUrl='" + shortenedUrl + '\'' +
                '}';
    }
}
