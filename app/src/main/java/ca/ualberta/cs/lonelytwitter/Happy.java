package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by iali1 on 1/12/16.
 */

/**
 * This class extends from Current mood and the mood here is happy!
 * @see CurrentMood
 */
public class Happy extends CurrentMood{
    protected Date date;
    private String mood = "Happy";

    /**
     * This constructor when called will set their mood and the date
     * @param mood the mood they are in
     * @param date the date
     */
    public Happy(String mood, Date date) {
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
     * Shows the mood
     * @return the mood
     */
    public String showMood(){
        return ":)";
    }
}
