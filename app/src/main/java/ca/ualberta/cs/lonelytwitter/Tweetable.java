package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by iali1 on 1/12/16.
 */
public interface Tweetable {
    // getMessage returns the tweet message.
    public String getMessage();
    public Date getDate();
}