package com.zlk.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class ZlkUtil {

	/**
	 * 获得唯一字符串的方法（str+"_"+毫秒数+4位随机数）（循环添加的时候不建议用，可能出现重复）
	 * 
	 * @param str
	 * @return
	 */
	public static String getCoustomKeyID(String str) {
		Random rand = new Random();
		return str + "_" + Calendar.getInstance().getTimeInMillis()+ (rand.nextInt(9999 - 1000 + 1) + 1000);
	}

	/**
	 * 单例模式生成唯一字符串
	 * 
	 * @return
	 */
	public static synchronized String getUniqueString() {
		if (generateCount > 99999) generateCount = 0;
		String uniqueNumber = Long.toString(System.currentTimeMillis())+ Integer.toString(generateCount);
		generateCount++;
		return uniqueNumber;
	}
	private static final int MAX_GENERATE_COUNT = 99999;
	private static int generateCount = 0;
	
	/**
	 * 字符串类型转时间类型
	 * @param pattern  时间格式
	 * @param test 字符传
	 * @return
	 */
	public Date String2Date(String pattern, String test)
	{
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		Date d = null;
		try
		{
			d = sf.parse(test);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 时间类型转字符传
	 * @param pattern
	 * @param date
	 * @return
	 */
	public String Date2PatternStr(String pattern, Date date)
	{
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		return sf.format(date);
	}

	/**
	 * 字符串比对这则表达式的方法
	 * @param pattern
	 * @param test
	 * @return
	 */
	public boolean strMaches(String pattern, String test)
	{
		boolean b = false;
		if (test != null && pattern != null)
			b = test.matches(pattern);
		return b;
	}

	/**
	 * 判断字符串是不是正整数
	 * @param test
	 * @return
	 */
	public boolean strIsInt(String test)
	{
		return strMaches("^(-)?\\d+$", test);
	}

	/**
	 * 判断字符串是不是一个数字
	 * @param test
	 * @return
	 */
	public boolean strIsNum(String test)
	{
		return strMaches("^(-)?\\d+(\\.\\d+)?$", test);
	}

	/**
	 * 判断文件是否存在
	 * @param f
	 * @return
	 */
	public boolean fileIsExist(File f)
	{
		boolean b = false;
		if (f == null)
			return false;
		if (f.exists())
			b = true;
		return b;
	}

	/**
	 * 删除文件
	 * @param f
	 */
	public void deleteFile(File f)
	{
		if (fileIsExist(f))
			f.delete();
	}


}
