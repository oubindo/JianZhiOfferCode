package JavaLearn;

/**
 * 这个是为了探究线程和锁的关系
 * Created by oubin on 17-3-10.
 */
public class ThreadLockRelation {

    public static void main(String[] args) throws InterruptedException {
        ThreadB b = new ThreadB("ThreadB");
        //启动计算线程
        b.start();
        //主线程拥有b对象上的锁。线程为了调用wait()或notify()方法，该线程必须是那个对象锁的拥有者
        synchronized (b) {
            System.out.println("等待对象b完成计算。。。");
            //当前线程A等待
            System.out.println(Thread.currentThread());
            Thread.currentThread().wait();
            System.out.println("b对象计算的总和是：" + b.total);
        }
    }
}

class ThreadB extends Thread {
    int total;

    public ThreadB(String name) {
        super(name);
    }

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 101; i++) {
                total += i;
            }
            System.out.println("Run Thread = " + Thread.currentThread());
            //（完成计算了）唤醒在此对象监视器上等待的单个线程，在本例中线程A被唤醒
            notify();
            System.out.println("计算完成 total=" + total);
        }
    }
}

