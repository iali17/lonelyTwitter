package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by iali1 on 1/12/16.
 */

/**
 * An abstract class that is used for normal and important tweet. Implements comparable so we can
 * compare the tweets based on date
 * @see NormalTweet to see how we use it
 * @see ImportantTweet another way to use it
 */
//comparable function implementation http://stackoverflow.com/questions/5927109/sort-objects-in-arraylist-by-date
public abstract class Tweet implements Comparable<Tweet> {
    protected Date date;
    protected String message;
    protected ArrayList<CurrentMood> moods;

    /**
     * This is the boolean to check if its important
     * @return when set in other classes it returns whether it's important or not
     */
    public abstract Boolean isImportant();

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
     * Compares the tweet objects
     * @param o A tweet object
     * @return -1 for < than, 0 for equal, 1 for greater **I think
     */
    public int compareTo(Tweet o){
        return getDate().compareTo(o.getDate());
    }

    /**
     * Constructor that creates a tweet with the date and message
     * @param date the date
     * @param message the message
     */
    public Tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    /**
     * Constructor that creates a tweet with the message and a default date
     * @param message the message
     */
    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    /**
     * Sets the message
     * @param message the message
     * @throws TweetTooLongException Thrown when the message is too long
     * @see TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Sets the date
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * When used in a string (Eg. "" + tweetObject) it will cast it to this
     * @return date and message combined in a string
     */
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}