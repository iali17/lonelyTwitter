package ca.ualberta.cs.lonelytwitter;

/**
 * Created by iali1 on 1/12/16.
 */

/**
 * This class represents the current mood of the person. They can call this to initially create
 * a mood object with their mood. Then they can set the mood or get the mood.
 */
public abstract class CurrentMood {
    protected String mood;

    /**
     * This is the constructor when they call this it creates an object with the mood of their choice
     * @param mood this is the mood they are in
     */
    public CurrentMood(String mood) {
        this.mood = mood;
    }

    /**
     * This will get the mood that they are in
     * @return the mood
     */
    public String getMood() {
        return mood;
    }

    /**
     * This will set the mood to whatever mood they want
     * @param mood this is the mood they are in
     */
    public void setMood(String mood) {
        this.mood = mood;
    }
}
