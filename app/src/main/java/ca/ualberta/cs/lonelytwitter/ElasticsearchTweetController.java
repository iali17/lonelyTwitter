package ca.ualberta.cs.lonelytwitter;

import android.os.AsyncTask;
import android.util.Log;

import com.searchly.jestdroid.DroidClientConfig;
import com.searchly.jestdroid.JestClientFactory;
import com.searchly.jestdroid.JestDroidClient;

import java.io.IOException;
import java.util.ArrayList;

import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;

/**
 * Created by esports on 2/17/16.
 */
public class ElasticsearchTweetController {
    private static JestDroidClient client;

    //TODO: A function that gets tweets
    public static class GetTweetsTasks extends AsyncTask<String, Void, ArrayList<Tweet>> {
        
        verifyClient();

        return null;
    }

    //TODO: A function that adds a tweet
    public static class AddTweetTask extends AsyncTask<NormalTweet,Void, Void>{
        @Override
        protected Void doInBackground(NormalTweet... tweets){
            verifyClient();

            // Since AsyncTasks works on arrays, we need to work with arrays as wel (>= 1 tweet)
            for (int i = 0; i < tweets.length; i++) {
                NormalTweet tweet = tweets[i];

                Index index = new Index.Builder(tweet).index("testing").type("tweet").build();
                try {
                    DocumentResult result = client.execute(index);
                    if (result.isSucceeded()) {
                        // Set the ID to tweet that elasticsearch told me it was
                        tweet.setId(result.getId());
                    } else {
                        // TODO: Add an error message, because this was puzzling
                        // TODO: Right here it will trigger if the insert fails
                        Log.i("TODO", "We actually failed here, adding a tweet");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    public static void verifyClient() {
        // 1. Verify that 'client' exists
        if (client == null) {
            // 2. If it doesn't, make it
            DroidClientConfig.Builder builder = new DroidClientConfig.Builder("http://cmput301.softwareprocess.es:8080");
            DroidClientConfig config =  builder.build();

            JestClientFactory factory = new JestClientFactory();
            factory.setDroidClientConfig(config);
            client = (JestDroidClient) factory.getObject();
        }

    }
}
