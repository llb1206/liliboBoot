package com.ThreadPoolExecutors;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 配置线程池的四种拒绝策略
 * */
public class RejectPolicy {
	
	/**
	 * 丢弃任务并抛出RejectedExecutionException异常
	 * */
	public static RejectedExecutionHandler abortPolicy = 
			new ThreadPoolExecutor.AbortPolicy();
	
	/**
	 * 丢弃任务但是不抛出异常
	 * */
	public static RejectedExecutionHandler discardPolicy = 
			new ThreadPoolExecutor.DiscardPolicy();
	
	/**
	 * 丢弃队列最前面的任务，最新任务入列
	 * */
	public static RejectedExecutionHandler discardOldestPolicy = 
			new ThreadPoolExecutor.DiscardOldestPolicy();
	
	/**
	 * 由调用线程处理该任务
	 * */
	public static RejectedExecutionHandler callerRunsPolicy = 
			new ThreadPoolExecutor.CallerRunsPolicy();
}