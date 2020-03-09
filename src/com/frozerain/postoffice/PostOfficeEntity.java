package com.frozerain.postoffice;

public class PostOfficeEntity {
    private int postOfficeCode;
    private String postOfficeAddress;
    private String postOfficeWorkTime;
    private int postOfficeRating;

    public PostOfficeEntity() {
    }

    public PostOfficeEntity(int postOfficeCode, String postOfficeAddress, String postOfficeWorkTime, int postOfficeRating) {
        this.postOfficeCode = postOfficeCode;
        this.postOfficeAddress = postOfficeAddress;
        this.postOfficeWorkTime = postOfficeWorkTime;
        this.postOfficeRating = postOfficeRating;
    }

    public int getPostOfficeCode() {
        return postOfficeCode;
    }

    public void setPostOfficeCode(int postOfficeCode) {
        this.postOfficeCode = postOfficeCode;
    }

    public String getPostOfficeAddress() {
        return postOfficeAddress;
    }

    public void setPostOfficeAddress(String postOfficeAddress) {
        this.postOfficeAddress = postOfficeAddress;
    }

    public String getPostOfficeWorkTime() {
        return postOfficeWorkTime;
    }

    public void setPostOfficeWorkTime(String postOfficeWorkTime) {
        this.postOfficeWorkTime = postOfficeWorkTime;
    }

    public int getPostOfficeRating() {
        return postOfficeRating;
    }

    public void setPostOfficeRating(int postOfficeRating) {
        this.postOfficeRating = postOfficeRating;
    }

    @Override
    public String toString() {
        return postOfficeCode + ", " + postOfficeAddress;
    }

    public String getInfo(){
        return "Код почтового оффиса: " + postOfficeCode + "\n" +
                "Адрес оффиса: " + postOfficeAddress + "\n" +
                "Время работы: " + postOfficeWorkTime + "\n" +
                "Рейтинг почтового оффиса (0-10): " + postOfficeRating + "\n\n\n" +
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                "░░░░░░░░▄▀▄▀▀▀▀▄▀▄░░░░░░░░░░░░░░░░\n" +
                "░░░░░░░░█░░░░░░░░▀▄░░░░░░▄░░░░░░░░\n" +
                "░░░░░░░█░░▀░░▀░░░░░▀▄▄░░█░█░░░░░░░\n" +
                "░░░░░░░█░▄░█▀░▄░░░░░░░▀▀░░█░░░░░░░\n" +
                "░░░░░░░█░░▀▀▀▀░░░░░░░░░░░░█░░░░░░░\n" +
                "░░░░░░░█░░░░░░░░░░░░░░░░░░█░░░░░░░\n" +
                "░░░░░░░█░░░░░░░░░░░░░░░░░░█░░░░░░░\n" +
                "░░░░░░░░█░░▄▄░░▄▄▄▄░░▄▄░░█░░░░░░░░\n" +
                "░░░░░░░░█░▄▀█░▄▀░░█░▄▀█░▄▀░░░░░░░░\n" +
                "░░░░░░░░░▀░░░▀░░░░░▀░░░▀░░░░░░░░░░\n" +
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░";
    }
}
