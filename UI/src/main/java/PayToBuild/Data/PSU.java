package PayToBuild.Data;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PSU extends PCParts{
    int capacity_w;
    int capacity_va;

    public int getCapacity_w() {
        return capacity_w;
    }

    public void setCapacity_w(int capacity_w) {
        this.capacity_w = capacity_w;
    }

    public int getCapacity_va() {
        return capacity_va;
    }

    public void setCapacity_va(int capacity_va) {
        this.capacity_va = capacity_va;
    }

    public PSU(String name, float price, URL url, int capacity_w, int capacity_va) {

        super(name, price, url);


        if (capacity_w < 0) {
            capacity_w = 0;
        }

        if (capacity_va < 0) {
            capacity_va = 0;
        }


        this.capacity_w = capacity_w;
        this.capacity_va = capacity_va;
    }

    @Override
    public String toString() {
        return "PSU {" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", url=" + url +
                ", capacity_w=" + capacity_w + "W" +
                ", capacity_va=" + capacity_va + "VA" +
                '}';
    }


}
