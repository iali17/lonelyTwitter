package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by iali1 on 1/12/16.
 */

/**
 * Extends the tweet class and implements the Tweetable interface
 * @see Tweet - for the tweet
 * @see Tweetable the interface
 */
public class NormalTweet extends Tweet implements Tweetable {
    /**
     * Constructor that creates the normal tweet with the message and date
     * @param date the date
     * @param message the message
     */
    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    /**
     * Constructor that creates the normal tweet with the message and a default date
     * @param message the message
     */
    public NormalTweet(String message) {
        super(message);
    }

    /**
     * Gets the date
     * @return the date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Gets the message
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * This is to ensure that a normal tweet cannot be important
     * @return that it's not a normal
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}