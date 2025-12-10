package PayToBuild.Data;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CPUCooler extends PCParts{
    String rpm;
    int size;
    String noise_level;
    String color;

    public String getRpm() {
        return rpm;
    }

    public void setRpm(String rpm) {
        this.rpm = rpm;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getNoise_level() {
        return noise_level;
    }

    public void setNoise_level(String noise_level) {
        this.noise_level = noise_level;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CPUCooler(String name, float price, URL url, String rpm, int size, String noise_level, String color) {

        super(name, price, url);

        if (color == null || color.isEmpty()) {
            color = "";
        }

        if (noise_level == null|| noise_level.isEmpty()) {
           noise_level = "";
        }


        if (rpm == null || rpm.isEmpty()) {
            rpm = "";
        }


        if (size < 0) {
            size = 0;
        }

        this.rpm = rpm;
        this.size = size;
        this.noise_level = noise_level;
        this.color = color;
    }

    @Override
    public String toString() {
        return "CPUCooler {" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", url=" + url +
                ", rpm=" + rpm +
                ", size=" + size + " mm" +
                ", noise_level='" + noise_level + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}
