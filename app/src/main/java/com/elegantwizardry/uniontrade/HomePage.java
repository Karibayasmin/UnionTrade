package com.elegantwizardry.uniontrade;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class HomePage implements Serializable {

    @SerializedName("error")
    private Integer error;
    @SerializedName("error_report")
    private String error_report;
    @SerializedName("report")
    private List<Report> reportList;

    public HomePage(Integer error, String error_report, List<Report> reportList) {
        this.error = error;
        this.error_report = error_report;
        this.reportList = reportList;
    }

    public Integer getError() {
        return error;
    }

    public String getError_report() {
        return error_report;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    public class Report implements Serializable {

        @SerializedName("Id")
        private String Id;
        @SerializedName("Title")
        private String Title;
        @SerializedName("Price")
        private String Price;
        @SerializedName("Image")
        private String Image;

        public Report(String id, String title, String price, String image) {
            Id = id;
            Title = title;
            Price = price;
            Image = image;
        }

        public String getId() {
            return Id;
        }

        public String getTitle() {
            return Title;
        }

        public String getPrice() {
            return Price;
        }

        public String getImage() {
            return Image;
        }
    }
}
