package PayToBuild.Data;

import java.net.URL;

public class PCParts {
    String name;
    float price;
    URL url;

    public PCParts(String name, URL url, float price) {

        if (name == null || name.isEmpty()) {
            name = "";
        }

        if (url == null) {
            url = "";
        }

        if (price == null) {
            price = 0;
        }

        this.name = name;
        this.url = url;
        this.price = price;



    }
}
