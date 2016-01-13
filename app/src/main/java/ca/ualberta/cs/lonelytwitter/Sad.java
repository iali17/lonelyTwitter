package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by iali1 on 1/12/16.
 */
public class Sad extends CurrentMood {
    protected Date date;
    private String mood = "sad";

    public Sad(String mood, Date date) {
        super(mood);
        this.date = date;
    }

    @Override
    public String getMood() {
        return mood;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String showMood(){
        return ":(";
    }

}

