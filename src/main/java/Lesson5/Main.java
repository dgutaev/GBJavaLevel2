package Lesson5;

public class Main {
    final static int SIZE = 10000000;
    public static void main(String[] args) {
        singleThread();
        doubleThread();
    }

    static void singleThread() {
         float[] arr = new float[SIZE];
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1.0f;
        }
        System.out.println("Время заполнения единичками в один поток: " + (System.currentTimeMillis() - startTime) + " мс.");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время заполнения хитрой формулой в один поток: " + (System.currentTimeMillis() - startTime) + " мс.");
        System.out.println();
    }

    static void doubleThread() {
        final int H = SIZE / 2;
        long a;
        float[] arr = new float[SIZE];
        float[] a1 = new float[H];
        float[] a2 = new float[H];
        a = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, H, H);
        System.out.println("Время разбивки массива на два: " + (System.currentTimeMillis() - a) + " мс.");
        //   a = System.currentTimeMillis();

        Runnable task1 = () -> {
            long timeA = System.currentTimeMillis();
            for (int i = 0; i < H; i++) {
                a1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Время заполнения первой части: " + (System.currentTimeMillis() - timeA) + " мс.");
        };
        Thread thread1 = new Thread(task1);

        Runnable task2 = () -> {
            long timeB = System.currentTimeMillis();
            for (int i = 0; i < H; i++) {
                a2[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Время заполнения второй части: " + (System.currentTimeMillis() - timeB) + " мс.");
        };
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long b = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, H, H);
        System.out.println("Время склеивания двух кусков: " + (System.currentTimeMillis() - b) + " мс.");
    }
}
