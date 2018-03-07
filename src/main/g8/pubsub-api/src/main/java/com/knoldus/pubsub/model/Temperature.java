package com.knoldus.pubsub.model;

public class Temperature {
    private String tempType = null;
    private String tempValue = null;

    public Temperature() {
    }

    public Temperature(String tempType, String tempValue) {
        this.tempType = tempType;
        this.tempValue = tempValue;
    }

    public String getTempType() {
        return tempType;
    }

    public void setTempType(String tempType) {
        this.tempType = tempType;
    }

    public String getTempValue() {
        return tempValue;
    }

    public void setTempValue(String tempValue) {
        this.tempValue = tempValue;
    }

}
