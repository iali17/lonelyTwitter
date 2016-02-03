package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The main activity for a small, personal Twitter app to capture notes and comments.
 * <p>It saves the input tweets in the json files.</p>
 * A sample code as:<br>
 *     <code>
 *         for(int i = 0; i < 10; i++){
 *             for (int j = 0; j < 1; j++) {
 *                 doSomething();
 *             }
 *         }
 *     </code>
 * The list of important activities in this class are as follows:
 * <ul>
 *     <li>item 1</li>
 *     <li>item 2</li>
 *     <li>item 3</li>
 *     <li>item 4</li>
 * </ul>
 * @since 1.2.1
 * @see LonelyTwitterActivity for more information
 * @author Imran
 * @deprecated
 */

public class LonelyTwitterActivity extends Activity {
    /**
     * This arraylist is for keeping the tweets and their data of posting <br>
     * This is blah blah
     * @see #loadFromFile()
     */
    public ArrayList<String> listOfItems;
    static final String GENERAL_FILE_NAME = "fileName.json";

    /**
     * gets the tweet size
     * @return suppose to return the tweet size
     */
    private int calculateTweetSize(){
        return -1;
    }

    /**
     * Removes the stop words from the text
     * @param text this is the text we receieve to remove the stop words
     * @return returns the new string without stop words
     */
    private String removeStopWords(String text){
        return "";
    }

    /**
     * This starts the next activity which is blah blah.
     * @param intent this is the intent to be run immediately after hitting "start" button
     */
    private void startSecondActivity(Intent intent){

    }

    /**
     * Supposed to evaluate the other activity
     * @param intent this is the intent that gets evaluated
     * @return if the activity is good then return true or else false
     */
    public boolean evaluateOtherActivity(Intent intent){
        int count = 0;
        String s = "";
        String expression = "" ,expression2 = "" ,expression3 = "" ,expression4 = "";

        Intent intent1 = new Intent();
        startSecondActivity(intent1);
        String S = someMethod(expression + expression2 +expression3 + expression4);

        try {
            int a = 1;
            int b = 2;

            if (a < 2) {
                someMethod("First choice");
            }else {
                someMethod("Second choice");
            }

            while (1 < 2) {
                int j = 0;

            }
        }catch (Exception e){}
        return true;
    }

    /**
     * This method does something
     * @param s is some parameter
     * @return The value that is used for some job
     * @throws ...
     * @deprecated
     */
    public String someMethod(String s) {
        return "";
    }

    private static final String FILENAME = "file.sav";
    private EditText bodyText;
    private ListView oldTweetsList;

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    private ArrayAdapter<Tweet> adapter;

    /**
     * This starts when the activity is first started
     * This has the click listeners for when they click save and clear
     * @param savedInstanceState All the saved instances
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        Button clearButton = (Button) findViewById(R.id.clear);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

        saveButton.setOnClickListener(new View.OnClickListener() {
            /**
             * When they click on the save button we get the text that was in the textfield and
             * we add it to the tweets list, notify the adapter that something has changed and
             * save in the file
             * @param v gets the view
             */
            public void onClick(View v) {
                setResult(RESULT_OK);
                String text = bodyText.getText().toString();
                Tweet latestTweet = new NormalTweet(text);
                ImportantTweet latestImportantTweet = new ImportantTweet(text);
                // latestTweet.setMessage(latestTweet.getMessage() + "!");
                tweets.add(latestTweet);
                adapter.notifyDataSetChanged();
                saveInFile();
                //saveInFile(text, new Date(System.currentTimeMillis()));
                //finish();

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            /**
             * When they click on the clear button we clear the tweets list and tell the adapter
             * that something has changed. This updates the list and displays that the list is clear
             * then we save in file
             * @param v
             */
            public void onClick(View v){
                setResult(RESULT_OK);
                tweets.clear();
                adapter.notifyDataSetChanged();
                saveInFile();
            }
        });
    }

    /**
     * This function is called when the program starts.
     * <p>We load from the file and set the adapter to the list so we can update the adapter</p>
     */
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        //String[] tweets = loadFromFile();
        loadFromFile();
        adapter = new ArrayAdapter<Tweet>(this,
                R.layout.list_item, tweets);
        oldTweetsList.setAdapter(adapter);
    }

    /**
     * We open a specified file. Then we read from it. We then set what we read to the list of tweets
     */
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

            // Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 01-19 2016
            Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
            tweets = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            tweets = new ArrayList<Tweet>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    /**
     * Opens the file that we want to save in. Then we read from the Json and write what we read
     * to the file. Then we flush the writer and close the file.
     */
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson = new Gson();
            gson.toJson(tweets, out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }
}