package prac.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionalThread {

	private Lock lock = new ReentrantLock();
	private Condition added = lock.newCondition();
	private Condition removed = lock.newCondition();
	private int count = 0;
	private int MAX_COUNT = 3;
	
	public void produce() throws InterruptedException {
		lock.lock();
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName);
			try {
				while(count == MAX_COUNT)
					removed.await();
				count++;
				added.signal();
			}finally {
				lock.unlock();
			}
		
	}
	
	public void consume() throws InterruptedException {
		lock.lock();
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName);
			try {
				while(count == 0)
					added.await();
				count--;
				removed.signal();
			}finally {
				lock.unlock();
			}
	}
	
	public class ProducerTask implements Runnable{

		@Override
		public void run() {
			try {
				while(true) 
					produce();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public class ConsumerTask implements Runnable{

		@Override
		public void run() {
			try {
				while(true) 
					consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		ConditionalThread th = new ConditionalThread();
		Thread t1 = new Thread(th.new ProducerTask(),"producer-thread");
		Thread t2 = new Thread(th.new ConsumerTask(),"consumer-thread");
		t2.start();
		t1.start();
	}
}
