package org.example.ui;

import java.lang.reflect.Array;
import java.util.List;

public class CPUCooler extends PCParts{
    int RPM;
    int height;
    float noiseLevel;
    String color;
    List<String> sockets;
    boolean waterCooled;
    boolean fanless;

    public CPUCooler(String name, float price, int RPM, int height, float noiseLevel, String color, List<String> sockets, boolean waterCooled, boolean fanless) {
        super(name, price);
        this.RPM = RPM;
        this.height = height;
        this.noiseLevel = noiseLevel;
        this.color = color;
        this.sockets = sockets;
        this.waterCooled = waterCooled;
        this.fanless = fanless;
    }

    public int getRPM() {
        return RPM;
    }

    public void setRPM(int RPM) {
        this.RPM = RPM;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(float noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getSockets() {
        return sockets;
    }

    public void setSockets(List<String> sockets) {
        this.sockets = sockets;
    }

    public boolean isWaterCooled() {
        return waterCooled;
    }

    public void setWaterCooled(boolean waterCooled) {
        this.waterCooled = waterCooled;
    }

    public boolean isFanless() {
        return fanless;
    }

    public void setFanless(boolean fanless) {
        this.fanless = fanless;
    }
}
