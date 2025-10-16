package org.example.ui;

import java.util.List;

public class Motherboard extends PCParts{
    String socket;
    int memorySlots;
    int maxSuppMemory;
    String memoryType;
    String formFactor; //like ATX, Micro ATX
    List<String> memorySpeed;
    String color;
    List<String> m2Slots;
    List<String> USB;

    //Later may use Dictionary instead based on how we handle data
    int pcie16Count;
    int pcieSlotCount;
    int sataCount;
}
