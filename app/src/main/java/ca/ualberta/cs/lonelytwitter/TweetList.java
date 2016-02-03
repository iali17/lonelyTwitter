package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by iali1 on 1/26/16.
 */

/**
 * Tweet list class that uses the Tweet class and makes a list of them
 * @see Tweet for what the a tweet object is
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * This will add a tweet to the list. If the tweet is already in there it will throw an
     * IllegalArgumentException.
     * @param tweet the tweet they want to add.
     */
    public void addTweet(Tweet tweet){
        if (this.hasTweet(tweet) == Boolean.FALSE){
            tweets.add(tweet);
        }else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Checks if the list contains the tweet
     * @param tweet the tweet we want to check it contains
     * @return whether it contains it or not
     */
    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    /**
     * It makes a new object of Tweetlist so they cannot edit our original data, and we sort using
     * collections and return the new sorted list
     * @return the new sorted list
     * @see Tweet to see how we sort
     */
    public TweetList getTweets(){
        TweetList sortedTweetList = new TweetList();
        sortedTweetList.tweets.addAll(tweets);
        Collections.sort(sortedTweetList.tweets);
        return sortedTweetList;
    }

    /**
     * Gets the tweet
     * @param index which index the tweet is in
     * @return the tweet at the index
     */
    public Tweet getTweet(int index){
       return tweets.get(index);
    }

    /**
     * Removes a tweet from the list
     * @param tweet the tweet we wish to remove
     */
    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    /**
     * Gets how many tweets are in the list
     * @return the number of tweets
     */
    public int getCount(){
        return tweets.size();
    }
}
