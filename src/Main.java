public class Main extends Thread{

    @Override
    public void run() {
        while(true) {
            Needs.setter();
            Needs.needsMinus();
            Needs.checker();
            try {
                Thread.sleep(12000);
            } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        Main thread1 = new Main();
        Gui thread2 = new Gui();
        thread1.start();
        thread2.start();
    }

}