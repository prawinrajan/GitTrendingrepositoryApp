package com.prawin.gitTrendrepo.api;


import com.google.gson.annotations.SerializedName;


import java.util.List;

public class Hero {

    @SerializedName("author")
    private String author;

    @SerializedName("name")
    private String name;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("url")
    private String url;

    @SerializedName("description")
    private String description;

    @SerializedName("language")
    private String language;

    @SerializedName("languageColor")
    private String languageColor;

    @SerializedName("stars")
    private String stars;

    @SerializedName("forks")
    private String forks;

    @SerializedName("currentperiodstars")
    private String currentperiodstars;


    public Hero(String author, String name, String avatar, String url, String description, String language, String languageColor, String stars, String forks, String currentperiodstars) {
        this.author = author;
        this.name = name;
        this.avatar = avatar;
        this.url = url;
        this.description = description;
        this.language = language;
        this.languageColor = languageColor;
        this.stars = stars;
        this.forks = forks;
        this.currentperiodstars = currentperiodstars;
    }

    public Hero(){
        this.author = author;
        this.name = name;
        this.avatar = avatar;
        this.url = url;
        this.description = description;
        this.language = language;
        this.languageColor = languageColor;
        this.stars = stars;
        this.forks = forks;
        this.currentperiodstars = currentperiodstars;
    }


    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLanguageColor(String languageColor) {
        this.languageColor = languageColor;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public void setForks(String forks) {
        this.forks = forks;
    }

    public void setCurrentperiodstars(String currentperiodstars) {
        this.currentperiodstars = currentperiodstars;
    }
    private List<Hero> hero;

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getLanguageColor() {
        return languageColor;
    }

    public String getStars() {
        return stars;
    }

    public String getForks() {
        return forks;
    }

    public String getCurrentperiodstars() {
        return currentperiodstars;
    }

    public List<Hero> getHero() {

        return hero;
    }
}
