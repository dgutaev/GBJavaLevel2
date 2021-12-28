package Lesson1;

// "Hey, Teacher, leave those kids alone!
// All in all it's just another brick in the wall."
// Pink Floyd: The Wall

public class Wall implements Events {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean running(int maxLength) {
        return false;
    }

    @Override
    public boolean jumping(int maxHeight) {
        return (maxHeight >= height);
    }

    @Override
    public String toString() {
        return "стену высотой " + height + " м.";
    }
}
