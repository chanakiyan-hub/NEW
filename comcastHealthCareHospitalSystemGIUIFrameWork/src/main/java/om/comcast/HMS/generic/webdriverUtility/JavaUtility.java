package om.comcast.HMS.generic.webdriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	SimpleDateFormat sim;

	public int getRandomNumber() {
		Random r = new Random();
		int random = r.nextInt();
		return random;

	}
	public int getRanNumTen() {
		Random r = new Random();
		int random = r.nextInt(1000);
		return random;

	}

	public String getSystemDateYYYYDDMM() {
		Date dateObj = new Date();
		sim = new SimpleDateFormat("yyyy-MM-dd");
		String data = sim.format(dateObj);
		return data;

	}

	public String getReguiredDateYYYYDDMM(int days) {

		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String regdate = sim.format(cal.getTime());
		return regdate;

	}

	public StringBuilder getRandomValue(String email) {
		int n = 6;
		// choose a character random from this string
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb;
	}

	public StringBuilder getRandomNum(String dig) {
		int n2 = 9;
		// choose a character random from this string
		String AlphaNumericString2 = "1234567890";
		// create StringBuffer size of AlphaNumericString
		StringBuilder sb2 = new StringBuilder(n2);
		for (int i = 0; i < n2; i++) {
			int index2 = (int) (AlphaNumericString2.length() * Math.random());
			sb2.append(AlphaNumericString2.charAt(index2));
		}
		return sb2;
	}
}
