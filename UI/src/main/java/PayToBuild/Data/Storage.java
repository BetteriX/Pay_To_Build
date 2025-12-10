package PayToBuild.Data;

import java.net.URL;

public class Storage extends PCParts{
    String type; //SSD/HDD
    String form_factor;
    int capacity;
    float price_per_gb;
    int cache;
    String driveInterface;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForm_factor() {
        return form_factor;
    }

    public void setForm_factor(String form_factor) {
        this.form_factor = form_factor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getPrice_per_gb() {
        return price_per_gb;
    }

    public void setPrice_per_gb(float price_per_gb) {
        this.price_per_gb = price_per_gb;
    }

    public int getCache() {
        return cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }

    public String getDriveInterface() {
        return driveInterface;
    }

    public void setDriveInterface(String driveInterface) {
        this.driveInterface = driveInterface;
    }

    public Storage(String name, float price, URL url, String type, String form_factor, int capacity, float price_per_gb, int cache, String driveInterface) {

        super(name, price, url);

        if (type == null || type.isEmpty()) {
            type = "";
        }

        if (form_factor == null || form_factor.isEmpty()) {
            form_factor = "";
        }

        if (driveInterface == null || driveInterface.isEmpty()) {
            driveInterface = "";
        }

        if (capacity < 0) {
            capacity = 0;
        }

        if (price_per_gb < 0) {
            price_per_gb = 0.0f;
        }

        if (cache < 0) {
            cache = 0;
        }

        this.type = type;
        this.form_factor = form_factor;
        this.capacity = capacity;
        this.price_per_gb = price_per_gb;
        this.cache = cache;
        this.driveInterface = driveInterface;
    }

    @Override
    public String toString() {
        return "Storage {" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", url=" + url +
                ", type='" + type + '\'' +
                ", form_factor='" + form_factor + '\'' +
                ", capacity=" + capacity + " GB" +
                ", price_per_gb=" + price_per_gb +
                ", cache=" + cache + " MB" +
                ", driveInterface='" + driveInterface + '\'' +
                '}';
    }


}
