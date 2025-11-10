package PayToBuild.Data;

import java.util.List;

public class Motherboard extends PCParts {
    String socket;
    int memorySlots;
    int maxSuppMemory;
    String formFactor; //like ATX, Micro ATX
    List<String> color;
}