package PayToBuild.Data;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Memory extends PCParts{
    String speed;
    String modules; //e.g. 2x16GB
    float price_per_gb;
    String color;
    float first_word_latency;
    float cas_latency;

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }

    public float getPrice_per_gb() {
        return price_per_gb;
    }

    public void setPrice_per_gb(float price_per_gb) {
        this.price_per_gb = price_per_gb;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getFirst_word_latency() {
        return first_word_latency;
    }

    public void setFirst_word_latency(float first_word_latency) {
        this.first_word_latency = first_word_latency;
    }

    public float getCas_latency() {
        return cas_latency;
    }

    public void setCas_latency(float cas_latency) {
        this.cas_latency = cas_latency;
    }

    public Memory(String name, float price, URL url, String speed, float price_per_gb, String modules, String color, float first_word_latency, float cas_latency) {

        super(name, price, url);

        if (modules == null || modules.isEmpty()) {
            modules = "";
        }

        if (color == null || color.isEmpty()) {
            color = "";
        }

        if (speed == null || speed.isEmpty()) {
            speed = "";
        }

        if (cas_latency < 0) {
            cas_latency = 0.0f;
        }

        if (first_word_latency < 0) {
            first_word_latency = 0.0f;
        }

        if (price_per_gb < 0) {
            price_per_gb = 0.0f;
        }
        

        this.speed = speed;
        this.price_per_gb = price_per_gb;
        this.modules = modules;
        this.color = color;
        this.first_word_latency = first_word_latency;
        this.cas_latency = cas_latency;
    }
}
