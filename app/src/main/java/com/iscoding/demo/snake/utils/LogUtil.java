package com.iscoding.demo.snake.utils;

import android.util.Log;

/**
 * 日志工具类
 * 使打印日志变得简单
 * 自动识别调用日志函数的类名 方法名 与位置
 * 不需要繁琐的TAG
 * @author iscoding
 * QQ 1400100300
 */
public class LogUtil {
 	private static String tag = "AppName";
	private static LogUtil log;
	private LogUtil() {}

	/**
	 * 获取调用log方法的名字
	 * @return Name
	 */
	private String getFunctionName() {
		StackTraceElement[] sts = Thread.currentThread().getStackTrace();
		if (sts == null) {
			return null;
		}
		for (StackTraceElement st : sts) {
			if (st.isNativeMethod()) {
				continue;
			}
			if (st.getClassName().equals(Thread.class.getName())) {
				continue;
			}
			if (st.getClassName().equals(this.getClass().getName())) {
				continue;
			}
			return  "[ " + Thread.currentThread().getName() + ":( "
					+ st.getFileName() + ":" + st.getLineNumber() + ") "
					+ st.getMethodName() + " ]";
		}
		return null;
	}

	
	public static void i(Object str) {
		printLog(Log.INFO, str);
	}

	public static void d(Object str) {
		printLog(Log.DEBUG, str);
	}

	public static void v(Object str) {
		printLog(Log.VERBOSE, str);
	}

	public static void w(Object str) {
		printLog(Log.WARN, str);
	}

	public static void e(Object str) {
		printLog(Log.ERROR, str);
	}

	/**
	 * 调用系统的打印
	 * @param index 
	 * @param str
	 */
	private static void printLog(int index, Object str) {

		if (log == null) {
			log = new LogUtil();
		}
		String name = log.getFunctionName();
		if (name != null) {
			str = name + " - " + str;
		}
		switch (index) {
		case Log.VERBOSE:
			Log.v(tag, str.toString());
			break;
		case Log.DEBUG:
			Log.d(tag, str.toString());
			break;
		case Log.INFO:
			Log.i(tag, str.toString());
			break;
		case Log.WARN:
			Log.w(tag, str.toString());
			break;
		case Log.ERROR:
			Log.e(tag, str.toString());
			break;
		default:
			break;
		}
	}
}
