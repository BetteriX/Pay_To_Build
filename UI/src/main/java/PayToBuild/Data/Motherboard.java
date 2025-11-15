package PayToBuild.Data;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Motherboard extends PCParts {
    String socket;
    int memorySlots;
    int maxSuppMemory;
    String formFactor; //like ATX, Micro ATX
    List<String> color;

    public Motherboard(String name, float price, URL url, String socket, int memorySlots, int maxSuppMemory, String formFactor, List<String> color) {

        super(name, price, url);

        if (color == null) {
            color = new ArrayList<>();
        }

        if (formFactor == null || formFactor.isEmpty()) {
            formFactor = "";
        }

        if (socket == null || socket.isEmpty()) {
            socket = "";
        }

        if (maxSuppMemory < 0) {
            maxSuppMemory = 0;
        }

        if (memorySlots < 0) {
            memorySlots = 0;
        }

        this.socket = socket;
        this.memorySlots = memorySlots;
        this.maxSuppMemory = maxSuppMemory;
        this.formFactor = formFactor;
        this.color = color;
    }
}