public class UncommonBug {
    public static void main(String[] args) {
        int[] arr = new int[10];
        try {
            System.out.println(arr[10]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e);
        }

        // Uncommon bug scenario: ConcurrentModificationException
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        for (int i : list) {
            if (i == 3) {
                list.remove(Integer.valueOf(i)); // ConcurrentModificationException
            }
        }
        System.out.println(list);

        //Another uncommon bug scenario: Deadlock
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Thread 1 acquired both locks");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("Thread 2 acquired both locks");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}