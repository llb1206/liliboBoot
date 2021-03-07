package com.ThreadPoolExecutors;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 配置线程池的四种阻塞队列
 * */
public class Queue {
	
	private static final Integer idlePoolSize = 2;
	
	/**
	 * 基于数组的有界阻塞队列
	 * */
	public static ArrayBlockingQueue<Runnable> arrayBlockingQueue = 
			new ArrayBlockingQueue<Runnable>(idlePoolSize);
	
	/**
	 * 无界有序的阻塞队列
	 * */
	public static PriorityBlockingQueue<Runnable> priorityBlockingQueue = 
			new PriorityBlockingQueue<Runnable>(idlePoolSize);
	
	/**
	 * 有界阻塞队列，线程安全
	 * */
	public static LinkedBlockingQueue<Runnable> linkedBlockingQueue = 
			new LinkedBlockingQueue<Runnable>(idlePoolSize);
	
	/**
	 * 无缓冲等待队列，是一个不存储元素的等待队列，会直接将任务交给消费者，必须等队列中的添加元素全部被消费之后才能继续添加元素
	 * */
	public static SynchronousQueue<Runnable> synchronous = 
			new SynchronousQueue<Runnable>();
 
}