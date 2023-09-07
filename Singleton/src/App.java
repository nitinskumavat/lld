import SingletonClass.SingletonClass;

public class App implements Runnable {
    public static void main(String[] args) throws Exception {

        // multiple threads create db instance
        Thread t1 = new Thread(new App());
        Thread t2 = new Thread(new App());
        Thread t3 = new Thread(new App());
        Thread t4 = new Thread(new App());
        Thread t5 = new Thread(new App());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    @Override
    public void run() {
        SingletonClass instance = SingletonClass.getInstance();
        System.out.println(instance);
    }

}
