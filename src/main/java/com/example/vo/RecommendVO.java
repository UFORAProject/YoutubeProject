package com.example.vo;

public class RecommendVO {
    private String ch_url;
    private String ch_name;
    private String img;
    private Double similarity;

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCh_url() {
        return this.ch_url;
    }

    public void setCh_url(String ch_url) {
        this.ch_url = ch_url;
    }

    public String getCh_name() {
        return this.ch_name;
    }

    public void setCh_name(String ch_name) {
        this.ch_name = ch_name;
    }

    public Double getSimilarity() {
        return this.similarity;
    }

    public void setSimilarity(Double similarity) {
        this.similarity = similarity;
    }
    
}
