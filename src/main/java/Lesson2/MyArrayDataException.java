package Lesson2;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j) {
        super("В ячейке ["+i+"]["+j+"] не числовое значение");
    }
}
