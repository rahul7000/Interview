package com.rahul.practice.multithreading;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Constants {
	public final static Object POISION = "POISION";
	public static final BlockingQueue<Object> QUEUE = new LinkedBlockingQueue<>();
	public static final ExecutorService THREAD_POOL = Executors.newCachedThreadPool();
	public static final String FILETOSEARCH = "NCounter";
	public static final String ROOTDIRECTORY = "C:\\Users\\rahul\\Downloads";
	public static final List<String> FOUNDLOCATIONS = new ArrayList<>();
	public static final CountDownLatch LATCH = new CountDownLatch(1);
}

class DirProducer implements Runnable {

	private BlockingQueue<Object> obj;
	private Object objToInsert = null;;

	public DirProducer(BlockingQueue<Object> obj, Object objToInsert) {
		this.obj = obj;
		this.objToInsert = objToInsert;
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		try {
			obj.put(objToInsert);
			System.out.println("Produced " + ((File) objToInsert).getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void putPoision() {
		try {
			obj.put(Constants.POISION);
			System.out.println("Producer Queue Size is: " + obj.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class DirConsumer implements Runnable {

	private BlockingQueue<Object> obj;
	private Object objTaken = null;

	public DirConsumer(BlockingQueue<Object> obj) {
		this.obj = obj;
	}

	public void startConsumerThread() {
		final Thread thread = new Thread(this);
		thread.setName("myConsumerThread");
		thread.start();
		System.out.println("Consumer thread started in background");
	}

	@Override
	public void run() {
		while (true) {
			try {
				objTaken = obj.take();
				if (objTaken == Constants.POISION) {
					System.out.println(Constants.FOUNDLOCATIONS);
					System.out.println("Consumer Thread: "+ Thread.currentThread().getName());
					System.out.println("Consumer thread Shutdown Complete!");
					break;
				} else {
					// System.out.println("Consumer: " + ((File) objTaken).getName());

					// Fire peocessFiles
					SearchFilesUsingMultiThreadingTest.processFiles(Constants.THREAD_POOL, ((File) objTaken).getPath(),
							Constants.FILETOSEARCH);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class CheckString implements Callable<Boolean> {
	private String filename;
	private String contain;

	public CheckString(String filename, String contains) {
		this.filename = filename;
		this.contain = contains;

	}

	@Override
	public Boolean call() throws Exception {
		Boolean exist = Boolean.FALSE;
		if (filename.contains(contain)) {
			exist = Boolean.TRUE;
			System.out.println("Thread: " + Thread.currentThread().getName());
		}
		return exist;

	}

}

public class SearchFilesUsingMultiThreadingTest {

	public static void main(String[] args) {
		DirConsumer consumer = new DirConsumer(Constants.QUEUE);
		consumer.startConsumerThread();
		processFiles(Constants.THREAD_POOL, Constants.ROOTDIRECTORY, Constants.FILETOSEARCH);

		try {
			// main thread needs to stop to complete async calls of consumer thread
			Thread.sleep(7000);

			if (Constants.QUEUE.size() == 0) {
				Constants.THREAD_POOL.shutdown();
				if (Constants.THREAD_POOL.awaitTermination(60000, TimeUnit.SECONDS)) {
					Constants.QUEUE.add(Constants.POISION);
					System.out.println("Completed search: "+((ThreadPoolExecutor) Constants.THREAD_POOL).getCompletedTaskCount());
					System.out.println("All worker threads are done");
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void processFiles(ExecutorService executorService, String directory, String name) {

		File file = new File(directory);
		File[] fileArray = file.listFiles();

		for (File f : fileArray) {
			if (!f.isDirectory()) {
				Future<Boolean> returnObject = executorService.submit(new CheckString(f.getName(), name));
				try {
					if (returnObject.get()) {
						Constants.FOUNDLOCATIONS.add(f.getCanonicalPath());
					}
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				Constants.QUEUE.add(f);
			}
		}
	}

}
