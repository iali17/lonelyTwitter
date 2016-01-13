package ca.ualberta.cs.lonelytwitter;

/**
 * Created by iali1 on 1/12/16.
 */
public abstract class CurrentMood {
    protected String mood;

    public CurrentMood(String mood) {
        this.mood = mood;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
