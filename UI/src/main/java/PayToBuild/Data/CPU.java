package PayToBuild.Data;

import java.net.URL;

public class CPU extends PCParts{
    int core_count;
    float core_clock;
    float boost_clock;
    String microarchitecture;
    int tdp;
    String graphic; //built in



    public CPU(String name, float price, URL url, int core_count, float core_clock, float boost_clock, String microarchitecture, int tdp, String graphic) {

        super(name, price, url);

        if (microarchitecture == null || microarchitecture.isEmpty()) {
            microarchitecture = "";
        }

        if (graphic == null || graphic.isEmpty()) {
            graphic = "";
        }

        if (core_count < 0) {
            core_count = 0;
        }

        if (core_clock < 0) {
            core_clock = 0.0f;
        }

        if (boost_clock < 0) {
            boost_clock = 0.0f;
        }

        if (tdp < 0) {
            tdp = 0;
        }

        this.core_count = core_count;
        this.core_clock = core_clock;
        this.boost_clock = boost_clock;
        this.microarchitecture = microarchitecture;
        this.tdp = tdp;
        this.graphic = graphic;
    }

    @Override
    public String toString() {
        return "CPU {" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", url=" + url +
                ", core_count=" + core_count +
                ", core_clock=" + core_clock + " GHz" +
                ", boost_clock=" + boost_clock + " GHz" +
                ", microarchitecture='" + microarchitecture + '\'' +
                ", tdp=" + tdp + "W" +
                ", graphic='" + graphic + '\'' +
                '}';
    }


}
