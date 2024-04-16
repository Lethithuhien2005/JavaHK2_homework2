package MultiClock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import javax.swing.JFrame;

public class NewTime extends JFrame implements Runnable {
	MultiClock multiClock = new MultiClock();
	@Override
	public void run() {
		int timeZone = Integer.parseInt(multiClock.jTextField_timeZone.getText());
		// Kiem tra mui gio hop le:
		if (timeZone>=0 && timeZone<=23) {
			 String zoneIdString = "UTC" + (timeZone >= 0 ? "+" : "") + timeZone;
			 TimeZone timeZoneName = TimeZone.getTimeZone(zoneIdString);
			 LocalTime time = LocalTime.now(timeZoneName.toZoneId()); 
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
             String formattedTime = time.format(formatter);
             multiClock.jLabel_clock.setText(formattedTime);
		}
	}

}
