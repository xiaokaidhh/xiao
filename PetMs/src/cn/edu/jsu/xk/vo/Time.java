package cn.edu.jsu.xk.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Time {
	
	
	public String getTime() {
	Date date = new Date();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
	String time = simpleDateFormat.format(date);
	return time;
	}
}
