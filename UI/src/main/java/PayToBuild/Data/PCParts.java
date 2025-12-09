package PayToBuild.Data;

import java.net.URL;

public class PCParts {
    String name;
    float price;
    URL url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

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