package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;
import java.util.IllegalFormatException;

/**
 * Created by iali1 on 1/26/16.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test tweet");

        tweets.addTweet(tweet);

        assertTrue(tweets.hasTweet(tweet));

       try{
           tweets.addTweet(tweet);
           fail();
       }catch (IllegalArgumentException e){
       }
    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Hello");

        assertFalse(tweets.hasTweet(tweet));

        tweets.addTweet(tweet);
        tweets.hasTweet(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test Tweet");

        tweets.addTweet(tweet);
        tweets.removeTweet(tweet);

        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test Tweet");
        Tweet tweet1 = new NormalTweet("Testing");

        tweets.addTweet(tweet);
        tweets.addTweet(tweet1);
        TweetList returnedTweet = tweets.getTweets();

        assertTrue(returnedTweet.getTweet(0).getDate().compareTo(tweet1.getDate()) >= 0);
        assertTrue(returnedTweet.getTweet(1).getDate().compareTo(tweet1.getDate()) >= 0);
    }

    public void testGetTweets(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        Tweet tweet1 = new NormalTweet("test2");

        tweets.addTweet(tweet1);
        tweets.addTweet(tweet);

        TweetList returnedList = tweets.getTweets();

        assertTrue(returnedList.getTweet(0).getDate().compareTo(returnedList.getTweet(1).getDate()) >= 0);

    }

    public void testGetCount() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Test Tweet");
        Tweet tweet1 = new NormalTweet("Testing");

        tweets.addTweet(tweet);
        tweets.addTweet(tweet1);
        int counter = tweets.getCount();
        assertEquals(counter, 2);
    }


}
