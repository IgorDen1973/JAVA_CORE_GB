package ru.geekbrains.JAVA2.lesson_7;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Night {
    private long icon;
    private String iconPhrase;
    private boolean hasPrecipitation;
    private String precipitationType;
    private String precipitationIntensity;

    public Night() {
    }

    public Night(long icon, String iconPhrase, boolean hasPrecipitation) {
        this.icon = icon;
        this.iconPhrase = iconPhrase;
        this.hasPrecipitation = hasPrecipitation;
    }

    @JsonProperty("Icon")
    public long getIcon() { return icon; }
    @JsonProperty("Icon")
    public void setIcon(long value) { this.icon = value; }

    @JsonProperty("IconPhrase")
    public String getIconPhrase() { return iconPhrase; }
    @JsonProperty("IconPhrase")
    public void setIconPhrase(String value) { this.iconPhrase = value; }

    @JsonProperty("HasPrecipitation")
    public boolean getHasPrecipitation() { return hasPrecipitation; }
    @JsonProperty("HasPrecipitation")
    public void setHasPrecipitation(boolean value) { this.hasPrecipitation = value; }

    @JsonProperty("PrecipitationType")
    public String getPrecipitationType() { return precipitationType; }
    @JsonProperty("PrecipitationType")
    public void setPrecipitationType(String value) { this.precipitationType = value; }

    @JsonProperty("PrecipitationIntensity")
    public String getPrecipitationIntensity() { return precipitationIntensity; }
    @JsonProperty("PrecipitationIntensity")
    public void setPrecipitationIntensity(String value) { this.precipitationIntensity = value; }

}
