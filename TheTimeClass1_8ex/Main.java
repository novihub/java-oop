package TheTimeClass1_8ex;

public class Main {
	public static void main(String[] args) {
		// Test constructors and toString()
		Time t1 = new Time(1, 2, 3);
		System.out.println(t1); // toString()

		// Test Setters and Getters
		t1.setHour(4);
		t1.setMinute(5);
		t1.setSecond(6);
		System.out.println(t1); // toString()
		System.out.println("Hour: " + t1.getHour());
		System.out.println("Minute: " + t1.getMinute());
		System.out.println("Second: " + t1.getSecond());

		// Test setTime()
		t1.setTime(23, 59, 58);
		System.out.println(t1); // toString()

		// Test nextSecond();
		System.out.println(t1.nextSecond());
		System.out.println(t1.nextSecond().nextSecond());

		// Test previousSecond()
		System.out.println(t1.previousSecond());
		System.out.println(t1.previousSecond().previousSecond());
	}
}

class Time {
	private int hour;
	private int minute;
	private int second;

	public Time(int hour, int minute, int second) {
		setTime(hour, minute, second);
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	public void setHour(int hour) {
		if (hour >= 0 && hour <= 23) {
			this.hour = hour;
		} else {
			System.out.println("Invalid hour!");
		}
	}

	public void setMinute(int minute) {
		if (minute >= 0 && minute <= 59) {
			this.minute = minute;
		} else {
			System.out.println("Invalid minute!");
		}
	}

	public void setSecond(int second) {
		if (second >= 0 && second <= 59) {
			this.second = second;
		} else {
			System.out.println("Invalid second!");
		}
	}

	public void setTime(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}

	public Time nextSecond() {
		second++;
		if (second >= 60) {
			second = 0;
			minute++;
			if (minute >= 60) {
				minute = 0;
				hour++;
				if (hour >= 24) {
					hour = 0;
				}
			}
		}
		return this;
	}

	public Time previousSecond() {
		second--;
		if (second < 0) {
			second = 59;
			minute--;
			if (minute < 0) {
				minute = 59;
				hour--;
				if (hour < 0) {
					hour = 23;
				}
			}
		}
		return this;
	}

	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
}
