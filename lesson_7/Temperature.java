package ru.geekbrains.JAVA2.lesson_7;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {
    private Item minimum;
    private Item maximum;

    public Temperature() {
    }


    @JsonProperty("Minimum")
    public Item getMinimum() { return minimum; }
    @JsonProperty("Minimum")
    public void setMinimum(Item value) { this.minimum = value; }

    @JsonProperty("Maximum")
    public Item getMaximum() { return maximum; }
    @JsonProperty("Maximum")
    public void setMaximum(Item value) { this.maximum = value; }
}
