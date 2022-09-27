package Pra6;

public class P6_2 {

    public static void main(String[] args) {
        System.out.println("This program is made by 21CE143 Jay");
        // TODO Auto-generated method stub
        int array[] = new int[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*100.0 + 1.0);

        }
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int i = 1; i < array.length; i  += 2) {
                    System.out.println("At Odd index : " + i + " , " + array[i]);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int j = 0; j < array.length; j += 2) {
                    System.out.println("At Even index : " + j + " , " + array[j]);
                }
            }
        });
        thread1.start();
        thread2.start();

    }
}