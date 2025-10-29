package org.example.ui;

import java.util.List;

public class Case extends PCParts{
    String color;
    List<String> motherboardFormFactor; //e.g. ATX
    String type;
    //List<String> dimensions; we may need it
    String dimensions;
    List<String> includedFans;
    List<String> USB;
    int videoCardLen;
}
