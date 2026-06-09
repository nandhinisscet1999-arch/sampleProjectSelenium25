package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javaUtility {
	
	public int Randomnum()
	{
		Random ran = new Random();
		int data = ran.nextInt(5000);
		return data;
		
	}
	
	public String getSystemDataYYYY_MM_DD()
	{
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MM_DD");
		String data = sdf.format(dateObj);
		
		return data;
		
	}
	
	public String getRequiredDateYYYY_MM_DD(int days)
	{
		
		SimpleDateFormat sim = new SimpleDateFormat("YYYY_MM_DD");
		Calendar  cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,days);
		return sim.format(cal.getTime());
		
	}

}
