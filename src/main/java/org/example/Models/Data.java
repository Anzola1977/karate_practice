package org.example.Models;

import java.util.HashMap;
import java.util.Map;

public class Data {
    private int year;
    private double price;
    private String cpuModel;
    private String hardDiskSize;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data data)) return false;
        return
                getYear() == data.getYear() &&
                getPrice() == data.getPrice() &&
                getCpuModel().equals(data.getCpuModel()) &&
                getHardDiskSize().equals(data.getHardDiskSize());
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getHardDiskSize() {
        return hardDiskSize;
    }

    public void setHardDiskSize(String hardDiskSize) {
        this.hardDiskSize = hardDiskSize;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> mapData = new HashMap<>();
        mapData.put("year", this.year);
        mapData.put("cpuModel", this.cpuModel);
        mapData.put("price", this.price);
        mapData.put("hardDiskSize", this.hardDiskSize);
        return mapData;
    }
}
