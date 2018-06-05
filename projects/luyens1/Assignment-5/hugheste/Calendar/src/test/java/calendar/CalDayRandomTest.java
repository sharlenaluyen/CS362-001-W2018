package calendar;


import org.junit.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
			 long startTime = Calendar.getInstance().getTimeInMillis();
			 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

			 System.out.println("Start testing...");

			 try {
                 boolean diagnose = true;

                 /** Collection of all of the appointments for the calendar day */
                 LinkedList<Appt> listAppts = new LinkedList<Appt>();
                 System.out.println("Calendar Main: \n" );
				 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
					 long randomseed = System.currentTimeMillis(); //10
					 //			System.out.println(" Seed:"+randomseed );
					 Random random = new Random(randomseed);

					 int startHour = ValuesGenerator.getRandomIntBetween(random, 6, 11);
					 int startMinute = ValuesGenerator.RandInt(random);
					 int startDay = ValuesGenerator.RandInt(random);

					 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
					 int startYear = ValuesGenerator.RandInt(random);
					 String title = "Birthday Party";
					 String description = "This is my birthday party.";
					 //Construct a new Appointment object with the initial data
					 Appt appt = new Appt(startHour,
							 startMinute,
							 startDay,
							 startMonth,
							 startYear,
							 title,
							 description);
                     listAppts.add(appt);

                     startHour = ValuesGenerator.getRandomIntBetween(random, 1, 5);
                     Appt appt1 = new Appt(startHour,
                             startMinute,
                             startDay,
                             startMonth,
                             startYear,
                             title,
                             description);
                     listAppts.add(appt1);

                     startHour = ValuesGenerator.getRandomIntBetween(random, -5, -1);
                     Appt appt2 = new Appt(startHour,
                             startMinute,
                             startDay,
                             startMonth,
                             startYear,
                             title,
                             description);
                     listAppts.add(appt2);

					 if (!appt.getValid()) continue;
					 for (int i = 0; i < NUM_TESTS; i++) {
						 String methodName = ApptRandomTest.RandomSelectMethod(random);
						 if (methodName.equals("setTitle")) {
							 String newTitle = (String) ValuesGenerator.getString(random);
							 appt.setTitle(newTitle);
						 } else if (methodName.equals("setRecurrence")) {
							 int sizeArray = ValuesGenerator.getRandomIntBetween(random, 0, 8);
							 int[] recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
							 int recur = ApptRandomTest.RandomSelectRecur(random);
							 int recurIncrement = ValuesGenerator.RandInt(random);
							 int recurNumber = ApptRandomTest.RandomSelectRecurForEverNever(random);
							 appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						 }
					 }

                     GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDay);
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

//                     assertEquals(null,calDays.get(0).iterator());
//                     assertEquals(appt,calDays.get(0).getAppts());
  //                   assertFalse(calDays.get(3).isValid());


					 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
					 if ((iteration % 10000) == 0 && iteration != 0)
						 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

				 }
			 } catch (NullPointerException e) {

			 }
		 
	 }

    @Test
    public void radnomtest1()  throws Throwable  {
        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

        System.out.println("Start testing...");

        try {
            boolean diagnose = true;

            /** Collection of all of the appointments for the calendar day */
            LinkedList<Appt> listAppts = new LinkedList<Appt>();
            System.out.println("Calendar Main: \n" );
            for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                long randomseed = System.currentTimeMillis(); //10
                //			System.out.println(" Seed:"+randomseed );
                Random random = new Random(randomseed);

                int startHour = ValuesGenerator.getRandomIntBetween(random, 6, 11);
                int startMinute = ValuesGenerator.RandInt(random);
                int startDay = ValuesGenerator.RandInt(random);

                int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int startYear = ValuesGenerator.RandInt(random);
                String title = "Birthday Party";
                String description = "This is my birthday party.";
                //Construct a new Appointment object with the initial data
                Appt appt = new Appt(startHour,
                        startMinute,
                        startDay,
                        startMonth,
                        startYear,
                        title,
                        description);
                listAppts.add(appt);

                startHour = ValuesGenerator.getRandomIntBetween(random, 1, 5);
                Appt appt1 = new Appt(startHour,
                        startMinute,
                        startDay,
                        startMonth,
                        startYear,
                        title,
                        description);
                listAppts.add(appt1);

                startHour = ValuesGenerator.getRandomIntBetween(random, -5, -1);
                startDay = ValuesGenerator.getRandomIntBetween(random, -5, -1);
                startMinute = ValuesGenerator.getRandomIntBetween(random, 62, 64);

                Appt appt2 = new Appt(startHour,
                        startMinute,
                        startDay,
                        startMonth,
                        startYear,
                        title,
                        description);
                listAppts.add(appt2);
                assertFalse(appt2.getValid());

                Appt appt3 = null;
                listAppts.add(appt3);
                GregorianCalendar today = new GregorianCalendar(startYear,startMonth,startDay);
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

//                     assertEquals(null,calDays.get(0).iterator());
//                     assertEquals(appt,calDays.get(0).getAppts());
                //                   assertFalse(calDays.get(3).isValid());


                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                if ((iteration % 10000) == 0 && iteration != 0)
                    System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

            }
        } catch (NullPointerException e) {

        }

    }



}
