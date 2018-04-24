
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;
import java.util.Calendar;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {

    /** instance of DataHandler **/
System.out.println("Calendar Main: \n" );



DataHandler dataHandler;
dataHandler = new DataHandler();

DataHandler dataHandler2 = new DataHandler("calendar2.xml",true);
DataHandler dataHandler3 = new DataHandler("calendar2.xml",false);
DataHandler dataHandler4 = new DataHandler("calendar2.xml");
DataHandler dataHandler5 = new DataHandler("boop",true);
DataHandler dataHandler6 = new DataHandler("beep",false);




//get todays date
  Calendar rightnow = Calendar.getInstance();
  //current month/year/date is today
  /** the month the user is currently viewing **/
  int thisMonth = rightnow.get(Calendar.MONTH);
  /** todays date **/
int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
  /** the year the user is currently viewing **/
  int thisYear = rightnow.get(Calendar.YEAR);

//		// Get a calendar which is set to a specified date.
Calendar calendar = new GregorianCalendar(thisYear, thisMonth, thisDay);
// Increment the calendar's date by 1 day.
calendar.add(calendar.DAY_OF_MONTH,1);

 int startHour=15;
 int startMinute=30;
 int startDay=thisDay;
 int startMonth=thisMonth+1;
 int startYear=thisYear;
 String title="Birthday Party";
 String description="This is my birthday party.";
 String emailAddress="aburasa@oregonstate.edu";

 //Construct a new Appointment object with the initial data
     Appt appt1 = new Appt(startHour,
              startMinute ,
              startDay ,
              startMonth ,
              startYear ,
              title,
             description,
             emailAddress);

     System.out.println(appt1.toString());

     dataHandler.saveAppt(appt1);

     //get a list of appointments for one day, which is today
 		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
 		GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth,thisDay);

 		tomorrow.add(today.DAY_OF_MONTH,1);

 		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy");

                 //Create a linked list of calendar days to return
          	        LinkedList<CalDay> calDays = new LinkedList<CalDay>();

          			calDays = (LinkedList<CalDay>) dataHandler.getApptRange(today,tomorrow);

         			System.out.println("The number of appointments between "+ dateFormat.format(today.getTime()) +" (inclusive) and " + dateFormat.format(tomorrow.getTime()) +  " (exclusive) ");
         			for (int i = 0; i < calDays.size(); i++){

         				CalDay calday= calDays.get(i);

         				String str= calday.getFullInfomrationApp(calday);
         				System.out.println(str);

         				LinkedList<Appt>  appts =calDays.get(i).getAppts();
         				for(int index=0; index < appts.size();index++){
         					Appt appt_=appts.get(index);
         					System.out.println("\n\n"+appt_.toString());
         				}
         			}


         //assertEquals(null,calDays.get(0).iterator());
        //assertEquals(appt1,calDays.get(0).getAppts());
      //  assertFalse(calDays.get(3).isValid());

      Appt appt2 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");

      dataHandler.deleteAppt(appt2);
      Appt appt6 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");


      DataHandler dataHandler23 = new DataHandler("calendar2.xml",true);

 		  dataHandler23.saveAppt(appt6);



  }
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
    DataHandler dataHandler;
    dataHandler = new DataHandler();
    DataHandler dataHandlerr;

    //get todays date
      Calendar rightnow = Calendar.getInstance();
      //current month/year/date is today
      /** the month the user is currently viewing **/
      int thisMonth = rightnow.get(Calendar.MONTH);
      /** todays date **/
    int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
      /** the year the user is currently viewing **/
      int thisYear = rightnow.get(Calendar.YEAR);

      Appt appt1 = new Appt(15, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      Appt appt2 = new Appt(15, 30, 9, 11, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      Appt appt3 = new Appt(15, 30, 9, 12, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");


    //		// Get a calendar which is set to a specified date.
    Calendar calendar = new GregorianCalendar(thisYear, thisMonth, thisDay);
    // Increment the calendar's date by 1 day.
    calendar.add(calendar.DAY_OF_MONTH,1);

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

         				String str= calday.getFullInfomrationApp(calday);
         				System.out.println(str);

         				LinkedList<Appt>  appts =calDays.get(i).getAppts();
         				for(int index=0; index < appts.size();index++){
         					Appt appt_=appts.get(index);
         					System.out.println("\n\n"+appt_.toString());
         				}
         			}

  }


  @Test
    public void test03() throws Throwable
    {

      DataHandler datahandler = new DataHandler();
	  Appt appt1 = new Appt(2, 3, 23, 4, 2018, "UGH", "This is gross", "now@gmail.com");
	  datahandler.saveAppt(appt1);
	  datahandler.deleteAppt(appt1);
	  GregorianCalendar day1 = new GregorianCalendar(2018, 2, 6);
	  GregorianCalendar day2 = new GregorianCalendar(2018, 2, 4);
	  Appt appt2 = new Appt(8, 11, 8, 11, 2001, null, null, null);
	  appt2.setValid();
	  datahandler.saveAppt(appt2);
	  datahandler.deleteAppt(appt2);

        Appt appt = new Appt(10, 15, 20, 25, 2018, "Title", "Description", "xyz@gmail.com");
        appt.setValid();
        int[] recurdays = {3, 3, 3};
        appt.setRecurrence(recurdays, 3, 3, 3);
        DataHandler datahandler1 = new DataHandler();
        DataHandler datahandler2 = new DataHandler("calendar2.xml", false);
        assertFalse(datahandler1.deleteAppt(appt));
        appt.setStartMonth(1);
        appt.setValid();
        assertFalse(datahandler1.deleteAppt(appt));
        datahandler1.saveAppt(appt);
        datahandler1.deleteAppt(appt);
        datahandler2.saveAppt(appt);
        assertTrue(datahandler2.deleteAppt(appt));
    }

    @Test
      public void test04() throws Throwable
      {

                Appt appt = new Appt(10, 15, 20, 25, 2018, "Title", "Description", "xyz@gmail.com");
                appt.setValid();
                int[] recurdays = {3, 3, 3};
                appt.setRecurrence(recurdays, 3, 3, 3);
                DataHandler datahandler1 = new DataHandler();
                DataHandler datahandler2 = new DataHandler("calendar2.xml", false);
                assertFalse(datahandler1.deleteAppt(appt));
                appt.setStartMonth(1);
                appt.setValid();
                assertFalse(datahandler1.deleteAppt(appt));
                datahandler1.saveAppt(appt);
                datahandler1.deleteAppt(appt);
                datahandler2.saveAppt(appt);
                assertTrue(datahandler2.deleteAppt(appt));
}


@Test
  public void test05() throws Throwable
  {

    DataHandler datahandler = new DataHandler();
  Appt appt1 = new Appt(2, 3, 23, 4, 2018, "UGH", "This is gross", "now@gmail.com");
  datahandler.saveAppt(appt1);
  datahandler.deleteAppt(appt1);
  GregorianCalendar day1 = new GregorianCalendar(2018, 2, 6);
  GregorianCalendar day2 = new GregorianCalendar(2018, 2, 4);
  Appt appt2 = new Appt(8, 11, 8, 11, 2001, null, null, null);
  appt2.setValid();
  datahandler.saveAppt(appt2);
  datahandler.deleteAppt(appt2);
}





}
