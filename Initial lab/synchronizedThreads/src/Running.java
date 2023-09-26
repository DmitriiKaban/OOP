class Running {
    public static final Object syncLock1 = new Object();
    public static final Object syncLock2 = new Object();

    static int list1;
    static int list2;

    public static void run1(String owner) throws InterruptedException {
        synchronized (syncLock1) {
            for (int i = 0; i < 1_000; i++) {
                list1++;
            }
//            Thread.sleep(1000);

            System.out.println("Run1 " + owner);
        }
    }

    public static void run2(String owner) {
        synchronized (syncLock2) { // sync on an object(every object has a monitor, that allows to enter this run2 method's body only if it is not currently in use)
            for (int i = 0; i < 1_000; i++) {
                list2++;
            }
            System.out.println("Run2 " + owner);
        }
    }

    public static void runTogether(String owner) throws InterruptedException {
        run1(owner);
        run2(owner);
    }

}
