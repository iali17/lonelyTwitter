package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by iali1 on 1/12/16.
 */

/**
 * This Class extends from the tweet class and uses the interface "tweetable"<br>
 * It makes the tweet important with it's own special message
 * @see Tweet for what the tweet class is
 * @see Tweetable for the interface
 */
public class ImportantTweet extends Tweet implements Tweetable {

    /**
     * The isImportant is from tweet and this sets it to true because it's an important tweet
     * @return that the tweet is important
     */
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    /**
     * When this is called it creates an important tweet with the specified date and message
     * @param date the date
     * @param message the message
     */
    public ImportantTweet(Date date, String message) {
        super(date, message);
    }

    /**
     * When called it creates an important tweet with the specified message and the date is set
     * to a default
     * @param message the message
     */
    public ImportantTweet(String message) {
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
     * Gets the message with a special message to imply it's important
     * @return the new message
     */
    public String getMessage() {
        return "!IMPORTANT! " + this.message;
    }
}