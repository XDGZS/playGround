package com.gradproject.playground.entity;

import lombok.Data;

@Data
public class Scenic {
    private int Id;
    private String ScenicName;
    private String ScenicInfo;
    private String ScenicFacilities;
    private int ScenicNumber;
    private double ScenicPrice;
    private int ScenicGrade;
    private String ScenicComment;
    private byte ScenicDiscount;
    private String Address;

    public Scenic() {

    }

    public Scenic(String scenicName, String scenicInfo, String scenicFacilities, int scenicNumber, double scenicPrice, String address) {
        ScenicName = scenicName;
        ScenicInfo = scenicInfo;
        ScenicFacilities = scenicFacilities;
        ScenicNumber = scenicNumber;
        ScenicPrice = scenicPrice;
        Address = address;
    }
}
