package com.gradproject.playground.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Ticket {
    private int Id;
    private int User_id;
    private int Scenic_id;
    private Date BuyDate;
    private double price;
    private String remake;

    public Ticket() {

    }

    public Ticket(int user_id, int scenic_id, Date buyDate) {
        User_id = user_id;
        Scenic_id = scenic_id;
        BuyDate = buyDate;
    }
}
