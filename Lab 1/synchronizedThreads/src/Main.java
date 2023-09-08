public class Main {
    public static void main(String[] args) throws InterruptedException {

        long beginning = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Running.runTogether("thread1");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Running.runTogether("thread2");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Where running: " + (System.currentTimeMillis() - beginning) + " millis");
        System.out.println("List 1 size: " + Running.list1);
        System.out.println("List 2 size: " + Running.list2);

    }
}

