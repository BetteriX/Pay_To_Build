package PayToBuild.Data;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VideoCard extends PCParts{
    int memory; //e.g. 16GB
    String color;
    int core_clock; //MHz
    int boost_clock;//MHz
    int length;
    String chipset;

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCore_clock() {
        return core_clock;
    }

    public void setCore_clock(int core_clock) {
        this.core_clock = core_clock;
    }

    public int getBoost_clock() {
        return boost_clock;
    }

    public void setBoost_clock(int boost_clock) {
        this.boost_clock = boost_clock;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public VideoCard(String name, float price, URL url, int memory, String color, int core_clock, int boost_clock, int length, String chipset) {

        super(name, price, url);

        if (color == null || color.isEmpty()) {
            color = "";
        }

        if (chipset == null || chipset.isEmpty()) {
            chipset = "";
        }

        if (memory < 0) {
            memory = 0;
        }

        if (core_clock < 0) {
            core_clock = 0;
        }

        if (boost_clock < 0) {
            boost_clock = 0;
        }

        if (length < 0) {
            length = 0;
        }

        this.memory = memory;
        this.color = color;
        this.core_clock = core_clock;
        this.boost_clock = boost_clock;
        this.length = length;
        this.chipset = chipset;
    }
}
