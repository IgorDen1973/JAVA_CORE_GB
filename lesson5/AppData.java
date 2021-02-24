package ru.geekbrains.JAVA2.lesson5;

import java.util.Arrays;

public class AppData {
    private String [] header;
    private int [][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    @Override  // как на занятии делали
    public String toString() {
        return "AppData: " +
                "header = " + Arrays.toString(header) +"\n"+
        "         data   = " + Arrays.toString(data[0])+" "+Arrays.toString(data[1]);
    }
}
