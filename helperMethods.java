import java.util.ArrayList;
import java.util.Date;

//this class contains two methods which will be used by the main method in the alarmClock program.
public class helperMethods {
	
	//This method will loop through, waiting 50 seconds each loop, until all alarms have been set off.
	@SuppressWarnings("deprecation")
	public void waitForAlarms(ArrayList<Integer[]> alarms)
	{
		while(alarms.size() > 0)
		{
			Date dateTime = new Date();
			for(int x = 0; x < alarms.size(); x++)
			{
				if(dateTime.getHours() == alarms.get(x)[0])
				{
					if(dateTime.getMinutes() == alarms.get(x)[1])
					{
						System.out.println("The time is " + dateTime.toString() + ". An alarm has been triggered!");
						alarms.remove(x);
						break;
					}
				}
				//wait 30 seconds, so as not to run the loop too often.
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
		
	//this class will take in a string and return an int[] contains the time
	//the int in position 0 is the hrs, and the number in position 1 is the minutes
	public Integer[] stringToTime(String time)
	{
		String hrs = time.charAt(0) + "" + time.charAt(1);
		String min = time.charAt(3) + "" + time.charAt(4);
		Integer hrsAndMinutes[] = new Integer[2];
		hrsAndMinutes[0] = Integer.parseInt(hrs);
		hrsAndMinutes[1] = Integer.parseInt(min);
		return hrsAndMinutes;
	}
}
