package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
         boolean diagnose = true;

         /** Collection of all of the appointments for the calendar day */
         LinkedList<Appt> listAppts = new LinkedList<Appt>();
         System.out.println("Calendar Main: \n" );


         /** the month the user is currently viewing **/
         int thisMonth;

         /** the year the user is currently viewing **/
         int thisYear;

         /** todays date **/
         int thisDay;

         //get todays date
         Calendar rightnow = Calendar.getInstance();
         //current month/year/date is today
         thisMonth = rightnow.get(Calendar.MONTH)+1;
         thisYear = rightnow.get(Calendar.YEAR);
         thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

         int startHour=15;
         int startMinute=30;
         int startDay=thisDay+1;
         int startMonth=thisMonth;
         int startYear=thisYear;
         String title="Birthday Party";
         String description="This is my birthday party.";
         //Construct a new Appointment object with the initial data
         Appt appt = new Appt(startHour,
                 startMinute ,
                 startDay ,
                 startMonth ,
                 startYear ,
                 title,
                 description);
         if(diagnose){
             System.out.println(appt.toString());
         }

         listAppts.add(appt);

         GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
         GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
         tomorrow.add(Calendar.DAY_OF_MONTH,1);
         String todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
         String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);

         TimeTable timeTable=new TimeTable();
         //Create a linked list of calendar days to return
         LinkedList<CalDay> calDays = new LinkedList<CalDay>();
         if (diagnose) {


             System.out.println("The number of appointments between "+ todatDate +" and " + tomorrowDate);
             calDays = new LinkedList<CalDay>();
             calDays = timeTable.getApptRange(listAppts, today, tomorrow);
             for (int i = 0; i < calDays.size(); i++)
                 System.out.println(calDays.get(i).toString());
         }

 //        assertEquals(null,calDays.get(0).iterator());
//        assertEquals(appt,calDays.get(0).getAppts());
//        assertFalse(calDays.get(3).isValid());
         //listAppts.get(0);
         //assertEquals(null,calday.iterator());



     }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed	
}
