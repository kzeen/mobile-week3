package com.example.mobile_week3;

public class Feedback {
    private String campus;
    private String slideFeature;
    private String classFeature;
    private String assignmentFeature;
    private String topic;
    private float rating;

    public Feedback() {
        this.campus = "";
        this.slideFeature = "";
        this.classFeature = "";
        this.assignmentFeature = "";
        this.topic = "";
        this.rating = 0;
    }

    //    Auto generated (Right click -> Generate)
    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getSlideFeature() {
        return slideFeature;
    }

    public void setSlideFeature(String slideFeature) {
        this.slideFeature = slideFeature;
    }

    public String getClassFeature() {
        return classFeature;
    }

    public void setClassFeature(String classFeature) {
        this.classFeature = classFeature;
    }

    public String getAssignmentFeature() {
        return assignmentFeature;
    }

    public void setAssignmentFeature(String assignmentFeature) {
        this.assignmentFeature = assignmentFeature;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String toString() {
//        Better to use string builder when concatenating many things as strings are immutable
//        So many concatenations will generate many string instances. Sb will create only one
//        instance and is returned at the end.
        StringBuilder sb = new StringBuilder();
        sb.append("Campus: ").append(this.campus).append("\n");
        sb.append("Features Used: ").append(this.slideFeature).append(", ");
        sb.append(this.classFeature).append(", ").append(this.assignmentFeature).append("\n");
        sb.append("Topic:").append(this.topic).append("\n");
        sb.append("Rating: ").append(this.rating);

        return sb.toString();
    }
}
