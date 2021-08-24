public class MultiThreading {
    /**
     * Print Odd and Even Numbers
     */

    public int counter = 0;

    public void threadDemo() {
        MultiThreading multiThreading = new MultiThreading();

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                multiThreading.printEvenNumber();
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                multiThreading.printOddNumbers();
            }
        });

        A.start();
        B.start();


    }

    public void printEvenNumber() {
        synchronized (this) {
            try {
                while (counter < 20) {
                    if (counter % 2 != 0) {
                        wait();
                    } else {
                        System.out.println(counter);
                        counter++;
                        notify();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void printOddNumbers() {
        synchronized (this) {
            try {
                while (counter < 20) {
                    if (counter % 2 == 0) {
                        wait();
                    } else {
                        System.out.println(counter);
                        counter++;
                        notify();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
