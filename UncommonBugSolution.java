import java.util.*;

public class UncommonBugSolution {
    public static void main(String[] args) {
        int[] arr = new int[10];
        try {
            //Solution: Check array index before accessing
            if(10 < arr.length) System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e);
        }

        // Solution for ConcurrentModificationException: Use an iterator and remove using iterator methods
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (i == 3) {
                iterator.remove();
            }
        }
        System.out.println(list);

        // Solution for deadlock: Acquire locks in a consistent order
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                synchronized (lock2) {
                    System.out.println("Thread 1 acquired both locks");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock1) {
                synchronized (lock2) {
                    System.out.println("Thread 2 acquired both locks");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}