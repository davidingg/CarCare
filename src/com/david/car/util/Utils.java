/**
 * 
 */
package com.david.car.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Date;
import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * @author david
 * 項目公用方法
 * 2011/10/8 下午4:02:35
 */
public class Utils {
	public static final String TAG_RETDATA = "PAGE_RETDATA";//後臺頁面返回結果
	public static final String TAG_FORM = "PAGE_FORM";
	/**
  　　 * 獲取前日期是星期几
  　　 *
  　　 * @param dt 傳入日期
  　　 * @return 前日期是星期几
  　　 */
    public String getWeekOfDate(Date dt) {
    	String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(dt);
    	
    	int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
    	if (w < 0)
    	w = 0;
    	return weekDays[w];
    }
    /**
     * 兩個日期相差的天數.
     * @param str1 開始日期
     * @param str2 結束日期
     * @return 相差天數
     * @throws ParseException
     */
    public long diffDate(String str1, String str2) throws ParseException {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = formater.parse(str1);
        Date date2 = formater.parse(str2);
        long result = (date2.getTime() - date1.getTime()) / (1000 * 3600 * 24); // A day in milliseconds
        return result;
    }

    /**
     * 格式化日期(yyyy/MM/dd).
     * 
     * @param date 傳入的日期
     * @return 格式化後的日期
     */
    public String formatDate(Date date) {
        String result = "";
        if (date != null) {
            result = new SimpleDateFormat("yyyy/MM/dd").format(date);
            if (result.equals("1900/01/01")) {
                result = "";
            }
        }
        return result;
    }
    public final static int YEAR = Calendar.YEAR;
    public final static int MONTH = Calendar.MONTH;
    public final static int DATE = Calendar.DATE;
	public double diffDate(String str,String str1,String str2) throws ParseException {
		double result = 0;
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  				
			Date date1 = formatter.parse(str1);
			Date date2 = formatter.parse(str2);
			if(str.equals("HH")) {
				result = (date2.getTime() - date1.getTime()) / (1000 * 3600.0);
			}
			if(str.equals("MM")){
				result = (date2.getTime()  - date1.getTime() )/ (24*60*60*1000);
			}
		return result;
	}
    /**
     * 格式化日期, 並做加減日期功能.
     * 
     * @param date 傳入的日期.
     * @param field 日期欄位 Utils.YEAR, Utils.MONTH, Utils.DATE 三個值.
     * @param dateDiff 加減多少.
     * @return 格式化後的日期.
     */
    public String formatDate(Date date, int field, int dateDiff) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(field, dateDiff);
        return this.formatDate(cal.getTime());
    }
    
    /**
     * 格式化日期, 並做加減日期功能.
     * 
     * @param date 傳入的日期.
     * @param field 日期欄位 Utils.YEAR, Utils.MONTH, Utils.DATE 三個值.
     * @param dateDiff 加減多少.
     * @return 格式化後的日期.
     */
    public String formatDate(String date, int field, int dateDiff) throws ParseException {
    	SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
    	Calendar cal = Calendar.getInstance();
    	Date date1 = formater.parse(date);
        cal.setTime(date1);
        cal.add(field, dateDiff);
        return this.formatDate(cal.getTime());
    }
}