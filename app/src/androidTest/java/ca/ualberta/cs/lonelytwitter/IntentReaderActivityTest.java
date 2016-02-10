package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sajediba on 2/8/16.
 */
public class IntentReaderActivityTest extends ActivityInstrumentationTestCase2{

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

    //
    //
    public void testSendText() {
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 1");

        setActivityIntent(intent);
        IntentReaderActivity Ira = (IntentReaderActivity) getActivity();

        assertEquals("IntentReaderActivity should get the text from the intent",
                "message 1", Ira.getText());
    }

    public void testDisplayText(){
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 2");

        setActivityIntent(intent);
        IntentReaderActivity Ira = (IntentReaderActivity) getActivity();

        assertEquals("IntentReaderActivity should get the text from the intent",
                "message 2", Ira.getText());

        TextView textView = (TextView) Ira.findViewById(R.id.intentText);
        assertEquals("The text should be displayed!", "message 2",textView.getText().toString());
    }

    public void testDoubleText(){
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 3");
        intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY,
                IntentReaderActivity.DOUBLE);

        setActivityIntent(intent);
        IntentReaderActivity ira = (IntentReaderActivity) getActivity();
        assertEquals("The text should be repeated twice!", "message 3message 3",
                ira.getText());
    }
    //
    //

    //TODO: Add your code here ...
//-------------------------------------------------------------------------------
    public void testReverseText(){
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 4");
        intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY,
                IntentReaderActivity.REVERSE);

        setActivityIntent(intent);
        IntentReaderActivity ira = (IntentReaderActivity) getActivity();
        assertEquals("The text should be backwards!", "4 egassem",
                ira.getText());
    }


    public void testDefaultText(){
        Intent intent = new Intent();

        setActivityIntent(intent);
        IntentReaderActivity ira = (IntentReaderActivity) getActivity();
        assertEquals("The text should be the default message!", "Default text",
                ira.getText());
    }

    public void testTextViewVisible() {
        Intent intent = new Intent();
        intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "message 2");

        setActivityIntent(intent);
        IntentReaderActivity Ira = (IntentReaderActivity) getActivity();
        View view =  (View) Ira.getWindow().getDecorView();

        TextView textView = (TextView) Ira.findViewById(R.id.intentText);

        ViewAsserts.assertOnScreen(view, textView);
    }
//-------------------------------------------------------------------------------
}
