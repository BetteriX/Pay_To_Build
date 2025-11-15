package PayToBuild.Data;

import java.net.URL;

public class PCParts {
    String name;
    float price;
    URL url;

    public PCParts(String name, float price, URL url) {

        if (name == null || name.isEmpty()) {
            name = "";
        }

        if (price < 0) {
            price = 0;
        }

        this.name = name;
        this.price = price;
        this.url = url;
    }
}