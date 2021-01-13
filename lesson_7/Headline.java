package ru.geekbrains.JAVA2.lesson_7;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName(value = "Headline")
public class Headline {

    private String effectiveDate;
    private long effectiveEpochDate;
    private long severity;
    private String text;
    private String category;
    private String endDate;
    private long endEpochDate;
    private String mobileLink;
    private String link;

    public Headline() {
    }

    @JsonProperty("EffectiveDate")
    public String getEffectiveDate() { return effectiveDate; }
    @JsonProperty("EffectiveDate")
    public void setEffectiveDate(String value) { this.effectiveDate = value; }

    @JsonProperty("EffectiveEpochDate")
    public long getEffectiveEpochDate() { return effectiveEpochDate; }
    @JsonProperty("EffectiveEpochDate")
    public void setEffectiveEpochDate(long value) { this.effectiveEpochDate = value; }

    @JsonProperty("Severity")
    public long getSeverity() { return severity; }
    @JsonProperty("Severity")
    public void setSeverity(long value) { this.severity = value; }

    @JsonProperty("Text")
    public String getText() { return text; }
    @JsonProperty("Text")
    public void setText(String value) { this.text = value; }

    @JsonProperty("Category")
    public String getCategory() { return category; }
    @JsonProperty("Category")
    public void setCategory(String value) { this.category = value; }

    @JsonProperty("EndDate")
    public String getEndDate() { return endDate; }
    @JsonProperty("EndDate")
    public void setEndDate(String value) { this.endDate = value; }

    @JsonProperty("EndEpochDate")
    public long getEndEpochDate() { return endEpochDate; }
    @JsonProperty("EndEpochDate")
    public void setEndEpochDate(long value) { this.endEpochDate = value; }

    @JsonProperty("MobileLink")
    public String getMobileLink() { return mobileLink; }
    @JsonProperty("MobileLink")
    public void setMobileLink(String value) { this.mobileLink = value; }

    @JsonProperty("Link")
    public String getLink() { return link; }
    @JsonProperty("Link")
    public void setLink(String value) { this.link = value; }

}
