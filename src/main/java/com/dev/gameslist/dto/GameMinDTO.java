package com.dev.gameslist.dto;

import com.dev.gameslist.entities.Game;

public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {
    }

    public GameMinDTO(Game entitiy) {
        this.id = entitiy.getId();
        this.title = entitiy.getTitle();
        this.year = entitiy.getYear();
        this.imgUrl = entitiy.getImgUrl();
        this.shortDescription = entitiy.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
