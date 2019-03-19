package test.thread;

public class MyThread extends Thread {
    public String str;

    public MyThread(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        testParamSync(str);
    }

    public void testParamSync(String str) {
        synchronized (str) {

            System.out.println("hahahaha " + this.getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
