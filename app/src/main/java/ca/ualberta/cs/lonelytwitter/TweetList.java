package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by iali1 on 1/26/16.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet){
        if (this.hasTweet(tweet) == Boolean.FALSE){
            tweets.add(tweet);
        }else{
            throw new IllegalArgumentException();
        }
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public TweetList getTweets(){
        TweetList sortedTweetList = new TweetList();
        sortedTweetList.tweets.addAll(tweets);
        Collections.sort(sortedTweetList.tweets);
        return sortedTweetList;
    }
    public Tweet getTweet(int index){
       return tweets.get(index);
    }

    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public int getCount(){
        return tweets.size();
    }
}
