package Pra6;
class Test{
    int n;
    boolean valueSet = false;

    synchronized int get() throws InterruptedException {
        while (!valueSet) {
            wait();
        }
        System.out.println("Got value "+n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n) throws InterruptedException {
        while (valueSet) {
            wait();
        }
        this.n = n;
        valueSet = true;
        System.out.println("Put value "+n);
        notify();
    }
}
class Producer implements Runnable{

    Test test;
    public Producer(Test test) {
        this.test = test;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        int value = 0;
        while (value <= 10) {
            try {
                test.put(value++);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable{

    Test test;
    public Consumer(Test test) {
        this.test = test;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        int i = 0;
        while (i <= 10) {
            try {
                test.get();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
public class P6_5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("This program is made by 21CE143 Jay");
        Test test = new Test();
        Thread producer = new Thread(new Producer(test));
        Thread consumer = new Thread(new Consumer(test));
        producer.start();
        consumer.start();
    }

}