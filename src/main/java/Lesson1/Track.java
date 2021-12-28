package Lesson1;

public class Track implements Events {
    int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public boolean running(int maxLength) {
        return (maxLength >= length);
    }

    @Override
    public String toString() {
        return "дорожку длиной " + length + " м.";
    }

    @Override
    public boolean jumping(int maxHeight) {
        return false;
    }
}
