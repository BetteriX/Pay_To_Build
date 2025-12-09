package PayToBuild.Data;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Motherboard extends PCParts {
    String socket;
    int memory_slots	;
    int max_memory;
    String form_factor; //like ATX, Micro ATX
    String color;

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getMemory_slots() {
        return memory_slots;
    }

    public void setMemory_slots(int memory_slots) {
        this.memory_slots = memory_slots;
    }

    public int getMax_memory() {
        return max_memory;
    }

    public void setMax_memory(int max_memory) {
        this.max_memory = max_memory;
    }

    public String getForm_factor() {
        return form_factor;
    }

    public void setForm_factor(String form_factor) {
        this.form_factor = form_factor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Motherboard(String name, float price, URL url, String socket, int memory_slots	, int max_memory, String form_factor, String color) {

        super(name, price, url);

        if (color == null || color.isEmpty()) {
            color = "";
        }

        if (form_factor == null || form_factor.isEmpty()) {
            form_factor = "";
        }

        if (socket == null || socket.isEmpty()) {
            socket = "";
        }

        if (max_memory < 0) {
            max_memory = 0;
        }

        if (memory_slots	 < 0) {
            memory_slots	 = 0;
        }

        this.socket = socket;
        this.memory_slots	 = memory_slots	;
        this.max_memory = max_memory;
        this.form_factor = form_factor;
        this.color = color;
    }
}