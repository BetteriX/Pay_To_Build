package PayToBuild.Data;

import java.util.List;

public class Motherboard extends PCParts {
    String socket;
    int memorySlots;
    int maxSuppMemory;
    String formFactor; //like ATX, Micro ATX
    List<String> color;

    public Motherboard(List<String> color, String formFactor, int maxSuppMemory, int memorySlots, String socket) {

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

        this.color = color;
        this.formFactor = formFactor;
        this.maxSuppMemory = maxSuppMemory;
        this.memorySlots = memorySlots;
        this.socket = socket;
    }
}