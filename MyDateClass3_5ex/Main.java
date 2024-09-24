package MyDateClass3_5ex;

public class Main {
	public static void main(String[] args) {
		MyDate d1 = new MyDate(2012, 2, 28);
		System.out.println(d1); // Tuesday 28 Feb 2012
		System.out.println(d1.nextDay()); // Wednesday 29 Feb 2012
		System.out.println(d1.nextDay()); // 1 Mar 2012
		System.out.println(d1.nextMonth()); // Sunday 1 Apr 2012
		System.out.println(d1.nextYear()); // Monday 1 Apr 2013

		MyDate d2 = new MyDate(2012, 1, 2);
		System.out.println(d2); // Monday 2 Jan 2012
		System.out.println(d2.previousDay()); // Sunday 1 Jan 2012
		System.out.println(d2.previousDay()); // Saturday 31 Dec 2011
		System.out.println(d2.previousMonth()); // Wednesday 30 Nov 2011
		System.out.println(d2.previousYear()); // Tuesday 30 Nov 2010

		MyDate d3 = new MyDate(2012, 2, 29);
		System.out.println(d3.previousYear()); // Monday 28 Feb 2011

		// MyDate d4 = new MyDate(2099, 11, 31); // Invalid year, month, or day!
		// MyDate d5 = new MyDate(2011, 2, 29); // Invalid year, month, or day!
	}
}

class MyDate {
	private int year;
	private int month;
	private int day;

	public static final String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
			"Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

	public static final String[] DAYS = { "Sunday", "Monday", "Tuesday", "Wednesday",
			"Thursday", "Friday", "Saturday" };

	public static final int[] DAYS_IN_MONTHS = { 31, 28, 31, 30, 31, 30,
			31, 31, 30, 31, 30, 31 };

	public MyDate(int year, int month, int day) {
		if (isValidDate(year, month, day)) {
			this.year = year;
			this.month = month;
			this.day = day;
		} else {
			System.out.println("Invalid date!");
		}
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public void setYear(int year) {
		if (isValidDate(year, this.month, this.day)) {
			this.year = year;
		} else {
			System.out.println("Invalid year!");
		}
	}

	public void setMonth(int month) {
		if (isValidDate(this.year, month, this.day)) {
			this.month = month;
		} else {
			System.out.println("Invalid month!");
		}
	}

	public void setDay(int day) {
		if (isValidDate(this.year, this.month, day)) {
			this.day = day;
		} else {
			System.out.println("Invalid day!");
		}
	}

	public void setDate(int year, int month, int day) {
		if (isValidDate(year, month, day)) {
			this.year = year;
			this.month = month;
			this.day = day;
		} else {
			System.out.println("Invalid date!");
		}
	}

	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	public static boolean isValidDate(int year, int month, int day) {
		if (year < 1 || year > 9999 || month < 1 || month > 12) {
			return false;
		}

		int maxDay = DAYS_IN_MONTHS[month - 1];
		if (month == 2 && isLeapYear(year)) {
			maxDay = 29;
		}

		return day >= 1 && day <= maxDay;
	}

	public static String getDayOfWeek(int year, int month, int day) {
		int q = day;
		int m = (month < 3) ? month + 12 : month;
		int k = year % 100;
		int j = year / 100;

		int h = (q + (13 * (m + 1)) / 5 + k + (k / 4) + (j / 4) + 5 * j) % 7;
		return DAYS[(h + 5) % 7];
	}

	public MyDate nextDay() {
		if (isValidDate(year, month, day + 1)) {
			day++;
		} else if (month < 12) {
			month++;
			day = 1;
		} else {
			year++;
			month = 1;
			day = 1;
		}
		return this;
	}

	public MyDate previousDay() {
		if (isValidDate(year, month, day - 1)) {
			day--;
		} else if (month > 1) {
			month--;
			day = DAYS_IN_MONTHS[month - 1];
			if (month == 2 && isLeapYear(year)) {
				day = 29;
			}
		} else {
			year--;
			month = 12;
			day = 31;
		}
		return this;
	}

	public MyDate nextMonth() {
		if (month == 12) {
			year++;
			month = 1;
		} else {
			month++;
		}
		if (!isValidDate(year, month, day)) {
			day = DAYS_IN_MONTHS[month - 1];
		}
		return this;
	}

	public MyDate previousMonth() {
		if (month == 1) {
			year--;
			month = 12;
		} else {
			month--;
		}
		if (!isValidDate(year, month, day)) {
			day = DAYS_IN_MONTHS[month - 1];
		}
		return this;
	}

	public MyDate nextYear() {
		year++;
		if (!isValidDate(year, month, day)) {
			day = (month == 2 && isLeapYear(year)) ? 29 : 28;
		}
		return this;
	}

	public MyDate previousYear() {
		year--;
		if (!isValidDate(year, month, day)) {
			day = (month == 2 && isLeapYear(year)) ? 29 : 28;
		}
		return this;
	}

	public String toString() {
		return String.format("%s %02d %s %04d", getDayOfWeek(year, month, day),
				day, MONTHS[month - 1], year);
	}
}
