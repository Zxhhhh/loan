package com.gy612.loan.utils;

/**
 * 时间工具类
 * @author K550J
 *
 */
public class TimeUtils {
	
	/**
	 * 将毫秒转化为天，时，分，秒
	 * @param mss
	 * @return
	 */
	public static String formatDateTime(long mss) {
		mss = mss/1000;//将毫秒转化为秒
		String DateTimes = null;
		long days = mss / (60 * 60 * 24);
		long hours = (mss % (60 * 60 * 24)) / (60 * 60);
		long minutes = (mss % (60 * 60)) / 60;
		long seconds = mss % 60;
		if (days > 0) {
			DateTimes = days + "天" + hours + "小时" + minutes + "分钟" + seconds
					+ "秒";
		} else if (hours > 0) {
			DateTimes = hours + "小时" + minutes + "分钟" + seconds + "秒";
		} else if (minutes > 0) {
			DateTimes = minutes + "分钟" + seconds + "秒";
		} else {
			DateTimes = seconds + "秒";
		}
		return DateTimes;
	}

}
