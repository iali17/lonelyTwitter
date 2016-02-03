package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by iali1 on 1/12/16.
 */

/**
 * Creates a sad mood that extends from Current mood
 * @see CurrentMood
 */
public class Sad extends CurrentMood {
    protected Date date;
    private String mood = "sad";

    /**
     * Sets the mood to sad with the specified date
     * @param mood the mood
     * @param date the date
     */
    public Sad(String mood, Date date) {
        super(mood);
        this.date = date;
    }

    /**
     * Gets the mood
     * @return the mood
     */
    @Override
    public String getMood() {
        return mood;
    }

    /**
     * Gets the date
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Shows the mood of the user
     * @return something that shows they are sad
     */
    public String showMood(){
        return ":(";
    }

}

