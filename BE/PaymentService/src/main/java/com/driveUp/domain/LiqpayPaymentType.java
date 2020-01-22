package com.driveUp.domain;

public enum LiqpayPaymentType {

    CARD("card"),
    PRIVAT24("privat24"),
    CASH("cash");

    private String liqpayTitle;

    LiqpayPaymentType(String liqpayTitle) {
        this.liqpayTitle = liqpayTitle;
    }

    public String getLiqpayTitle() {
        return liqpayTitle;
    }
}
