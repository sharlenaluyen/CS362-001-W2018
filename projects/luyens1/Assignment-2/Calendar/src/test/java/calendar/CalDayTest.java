/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.LinkedList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import calendar.DataHandler;



public class CalDayTest{
  public CalDay newCalDay(){
        return new CalDay(new GregorianCalendar(1997, 8, 12));
  }

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {

    DataHandler dataHandler;
    dataHandler = new DataHandler();
      LinkedList<Appt> apptslist = new LinkedList<Appt>();

      /** Stores whether or not this is a valid calendar day */
      boolean valid = true;

      /** Stores the calendar day */
      int day;

      /** Stores the calendar month */
      int month;

      /** Stores the calendar year */
      int year;

      int startHour=4;
      int startMinute=30;
      int startDay=5;
      int startMonth=6;
      int startYear=2018;
      String title="Birthday Party";
      String description="This is my birthday party.";
      String email = null;
      //Construct a new Appointment object with the initial data
      Appt appt = new Appt(startHour,
              startMinute ,
              startDay ,
              startMonth ,
              startYear ,
              title,
              description,
              email);

         if(valid){
             System.out.println(appt.toString());
         }



        //get todays date
    	Calendar rightnow = Calendar.getInstance();
    	//current month/year/date is today
    	/** the month the user is currently viewing **/
    int   thisMonth = rightnow.get(Calendar.MONTH)+1;
      int    thisYear = rightnow.get(Calendar.YEAR);
        int  thisDay = rightnow.get(Calendar.DAY_OF_MONTH);

//		// Get a calendar which is set to a specified date.
		Calendar calendar = new GregorianCalendar(thisYear, thisMonth, thisDay);
	// Increment the calendar's date by 1 day.
		calendar.add(calendar.DAY_OF_MONTH,1);


    //apptslist.addAppt(appt);



    GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
    GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth,thisDay);

    tomorrow.add(today.DAY_OF_MONTH,1);

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy");

                 //Create a linked list of calendar days to return
                    LinkedList<CalDay> calDays = new LinkedList<CalDay>();

                calDays = (LinkedList<CalDay>) dataHandler.getApptRange(today, tomorrow);
                //calDays = (LinkedList<CalDay>) dataHandler.getApptRange(tomorrow, today); - throws an exception


              System.out.println("The number of appointments between "+ dateFormat.format(today.getTime()) +" (inclusive) and " + dateFormat.format(tomorrow.getTime()) +  " (exclusive) ");
              for (int i = 0; i < calDays.size(); i++){

                CalDay calday= calDays.get(i);
                calday.isValid();

                String str= calday.getFullInfomrationApp(calday);
                System.out.println(str);

                LinkedList<Appt>  appts =calDays.get(i).getAppts();
                int sizehere = calDays.get(i).getSizeAppts();
                int sizeagain =calDays.get(i).getDay();

                for(int index=0; index < appts.size();index++){
                  Appt appt_=appts.get(index);
                  System.out.println("\n\n"+appt_.toString());
                }
              }
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {

    CalDay cal2 = new CalDay();
    assertFalse(cal2.isValid());

  CalDay cal = newCalDay();
  LinkedList<Appt> appts = cal.getAppts();
  assertNotNull(appts);
  assertEquals(0, cal.getSizeAppts());
//2018,0,1 year month day

  CalDay cal1 = newCalDay();
  //assertEquals(8, cal1.getDay());
  //assertEquals(12, cal1.getMonth());
  assertEquals(1997, cal1.getYear());
  assertTrue(cal1.isValid());

  CalDay cal3 = newCalDay();
  assertNotNull(cal3.iterator());
  CalDay cal4 = new CalDay();
  assertNull(cal4.iterator());

}

@Test(timeout = 4000)
public void test02()  throws Throwable  {
  CalDay cal = newCalDay();
        Appt appt1 = new Appt(3, 30, 6, 11, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
        Appt appt2 = new Appt(4, 30, 7, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
        Appt appt3 = new Appt(5, 30, 8, 9, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
        appt1.setValid();
        cal.addAppt(appt1);
        assertEquals(1, cal.getSizeAppts());
        //System.out.println("1: " + cal.getSizeAppts());
        appt1.setStartHour(22);

        cal.addAppt(appt1);
        assertEquals(2, cal.getSizeAppts());
        //System.out.println("2: " + cal.getSizeAppts());

        cal.addAppt(appt2);
        assertEquals(3, cal.getSizeAppts());
        //System.out.println("3: " + cal.getSizeAppts());
      }

      @Test(timeout = 4000)
      public void test03()  throws Throwable  {
        CalDay cal1 = newCalDay();
       Appt appt1 = new Appt(0, 0, 1, 1, 1111, "Birthday", "My bday", "xyz@gmail.com");
        cal1.addAppt(appt1);
       assertTrue(appt1.hasTimeSet());
      }


}
