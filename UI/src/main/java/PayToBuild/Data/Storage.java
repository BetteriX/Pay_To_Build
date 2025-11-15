package PayToBuild.Data;

import java.net.URL;

public class Storage extends PCParts{
    String type; //SSD/HDD
    String formFactor;
    int capacity;
    float pricePRgb;
    int cache;
    String driveInterface;

    public Storage(String name, float price, URL url, String type, String formFactor, int capacity, float pricePRgb, int cache, String driveInterface) {

        super(name, price, url);

        if (type == null || type.isEmpty()) {
            type = "";
        }

        if (formFactor == null || formFactor.isEmpty()) {
            formFactor = "";
        }

        if (driveInterface == null || driveInterface.isEmpty()) {
            driveInterface = "";
        }

        if (capacity < 0) {
            capacity = 0;
        }

        if (pricePRgb < 0) {
            pricePRgb = 0.0f;
        }

        if (cache < 0) {
            cache = 0;
        }

        this.type = type;
        this.formFactor = formFactor;
        this.capacity = capacity;
        this.pricePRgb = pricePRgb;
        this.cache = cache;
        this.driveInterface = driveInterface;
    }
}
