package com.example.fargoevent.Retrofit.Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ListItem {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("image_url")
        @Expose
        private String imageUrl;
        @SerializedName("start_date_time")
        @Expose
        private String startDateTime;
        @SerializedName("end_date_time")
        @Expose
        private String endDateTime;
        @SerializedName("location")
        @Expose
        private String location;
        @SerializedName("featured")
        @Expose
        private Boolean featured;

    public ListItem(String title, String startDateTime, String imageUrl) {
        this.title = title;
        this.startDateTime = startDateTime;
        this.imageUrl = imageUrl;
    }

    public ListItem(Integer id, String title, String imageUrl, String startDateTime, String endDateTime, String location, Boolean featured) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.location = location;
        this.featured = featured;
    }

    public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getStartDateTime() {
            return startDateTime;
        }

        public void setStartDateTime(String startDateTime) {
            this.startDateTime = startDateTime;
        }

        public String getEndDateTime() {
            return endDateTime;
        }

        public void setEndDateTime(String endDateTime) {
            this.endDateTime = endDateTime;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Boolean getFeatured() {
            return featured;
        }

        public void setFeatured(Boolean featured) {
            this.featured = featured;
        }

    @Override
    public String toString() {
        return "ListItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", startDateTime='" + startDateTime + '\'' +
                ", endDateTime='" + endDateTime + '\'' +
                ", location='" + location + '\'' +
                ", featured=" + featured +
                '}';
    }
}
