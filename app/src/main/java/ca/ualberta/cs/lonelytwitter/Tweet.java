package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by iali1 on 1/12/16.
 */
//comparable function implementation http://stackoverflow.com/questions/5927109/sort-objects-in-arraylist-by-date
public abstract class Tweet implements Comparable<Tweet> {
    protected Date date;
    protected String message;
    protected ArrayList<CurrentMood> moods;

    public abstract Boolean isImportant();

    public Date getDate() {
        return this.date;
    }

    public String getMessage() {
        return this.message;
    }

    public int compareTo(Tweet o){
        return getDate().compareTo(o.getDate());
    }

    public Tweet(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }


    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}