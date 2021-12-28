package Lesson1;

public class Human implements Participants {
    String name;
    int maxHeight;
    int maxLength;

    public Human(String name, int maxHeight, int maxLength) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public String toString() {
        return "человек " + name;
    }
}
