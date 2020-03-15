package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class HourDate {

	Calendar dateManual = Calendar.getInstance();
	Calendar dateCurrent = new GregorianCalendar();
	int y; 
	int m;
	int d;
	int h;
	int min;
	int sec;
	
	public String showDateCurrent(int y, int m, int d, int h, int min, int sec) {
		String mss="";

		y = dateCurrent.get(Calendar.YEAR);
        m = dateCurrent.get(Calendar.MONTH);
        d = dateCurrent.get(Calendar.DAY_OF_MONTH);
        h = dateCurrent.get(Calendar.HOUR_OF_DAY);
        min = dateCurrent.get(Calendar.MINUTE);
        sec = dateCurrent.get(Calendar.SECOND);
        
        mss= ("date curerent:"+"/"+d+"/"+m+1+"/"+y+"  hour current:"+h+":"+min+":"+sec);
		return mss;
	}
	
	public void showDateManual(int y, int m, int d, int h, int min, int sec) {
		dateManual.set(y,m,d,h,min,sec);
	}

}
