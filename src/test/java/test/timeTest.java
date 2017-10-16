package test;

import com.gy612.loan.controller.LoanController;

public class timeTest {

	public static String formatDateTime(long mss) {
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
	
	public static void main(String[] args) {
		//System.out.println(formatDateTime(258900));
		
	}
}
