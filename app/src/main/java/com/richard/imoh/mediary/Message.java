package com.richard.imoh.mediary;

/**
 * Created by LENOVO on 6/30/2018.
 */

public class Message {
    String feelingEmoji;
    String feelingText;
    String timeStamp;
   String title;

    public Message() {
    }

    public Message(String feelingEmoji, String feelingText, String timeStamp,String title) {
        this.feelingEmoji = feelingEmoji;
        this.feelingText = feelingText;
        this.timeStamp = timeStamp;
        this.title = title;
    }

    public String getFeelingEmoji() {
        return feelingEmoji;
    }

    public void setFeelingEmoji(String feelingEmoji) {
        this.feelingEmoji = feelingEmoji;
    }

    public String getFeelingText() {
        return feelingText;
    }

    public void setFeelingText(String feelingText) {
        this.feelingText = feelingText;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
