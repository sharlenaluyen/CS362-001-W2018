package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests TimeTable Class.
     */

	@Test
	public void randTest()  throws Throwable  {

        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

        System.out.println("Start testing...");

		boolean diagnose = true;
		Calendar rightnow = Calendar.getInstance();
		//current month/year/date is today


		LinkedList<Appt> listAppts = new LinkedList<Appt>();

        for (int iteration = 0; elapsed < TestTimeout; iteration++) {
            long randomseed = System.currentTimeMillis(); //10
            //			System.out.println(" Seed:"+randomseed );
            Random random = new Random(randomseed);
            int thisMonth = ValuesGenerator.getRandomIntBetween(random, 2, 4);
            int thisYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2022);
            int thisDay = ValuesGenerator.getRandomIntBetween(random, 26, 28);

		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		int randYear = ValuesGenerator.getRandomIntBetween(random, 2060, 2070);
		int randMonth = ValuesGenerator.getRandomIntBetween(random, 2, 5);
		int randDay = ValuesGenerator.getRandomIntBetween(random, 15, 25);
		GregorianCalendar nextDay = new GregorianCalendar(randYear,randMonth,randDay);
		tomorrow.add(Calendar.DAY_OF_MONTH,1);
		nextDay.add(Calendar.DAY_OF_MONTH,1);
		String todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
		String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);
		String nextDate=nextDay.get(Calendar.MONTH)+ "/"+ nextDay.get(Calendar.DAY_OF_MONTH)+"/"+nextDay.get(Calendar.YEAR);

		int startHour=ValuesGenerator.getRandomIntBetween(random, 22, 24);
		int startMinute=ValuesGenerator.getRandomIntBetween(random, 20, 35);
		int startDay=thisDay;
		int startMonth=thisMonth;
		int startYear=thisYear;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		if(diagnose){
			System.out.println(appt1.toString());
		}
		int [] recurDays = {1,2,3,4,5,6};
		int recurBy = 2;
		int recurIncrement = 1;
		int recurNumber = 100;
		appt1.setRecurrence(recurDays,Appt.RECUR_BY_YEARLY,recurIncrement,recurNumber);
		listAppts.add(appt1);

		int sHour=ValuesGenerator.getRandomIntBetween(random, 10, 16);
		int sMinute=ValuesGenerator.getRandomIntBetween(random, 20, 40);
		int sDay=ValuesGenerator.getRandomIntBetween(random, thisDay, thisDay+3);
		int sMonth=ValuesGenerator.getRandomIntBetween(random, 1, 2);
		int sYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2020);
		String t="Birthday Party";
		String d="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt2 = new Appt(sHour,
				sMinute ,
				sDay ,
				sMonth ,
				sYear ,
				t,
				d);
		if(diagnose){
			System.out.println(appt2.toString());
		}
		int [] recurs = {1};
		appt2.setRecurrence(recurDays,Appt.RECUR_BY_MONTHLY,recurIncrement,recurNumber);

		listAppts.add(appt2);

		sDay=ValuesGenerator.getRandomIntBetween(random, 25, 31);
		sYear=ValuesGenerator.getRandomIntBetween(random, 2015, 2017);
		//Construct a new Appointment object with the initial data
		Appt appt3 = new Appt(sHour,
				sMinute ,
				sDay ,
				sMonth ,
				sYear ,
				t,
				d);
		if(diagnose){
			System.out.println(appt2.toString());
		}
		int [] recurd = {1,2};
		appt3.setRecurrence(recurd,Appt.RECUR_BY_MONTHLY,2,Appt.RECUR_NUMBER_FOREVER);
		listAppts.add(appt3);

		sDay=ValuesGenerator.getRandomIntBetween(random, 200, 230);
		sMonth=ValuesGenerator.getRandomIntBetween(random, 3, 5);
		sYear=ValuesGenerator.getRandomIntBetween(random, 2050, 2060);
		//Construct a new Appointment object with the initial data
		Appt appt4 = new Appt(sHour,
				sMinute ,
				sDay ,
				sMonth ,
				sYear ,
				t,
				d);
		if(diagnose){
			System.out.println(appt2.toString());
		}
		int [] recurds = {};
		int recInt = ValuesGenerator.getRandomIntBetween(random, 2, 3);
		int recNum = ValuesGenerator.getRandomIntBetween(random, 3, 5);
		appt4.setRecurrence(null,Appt.RECUR_BY_WEEKLY,recInt,recNum);
		listAppts.add(appt4);

		int tempDay = ValuesGenerator.getRandomIntBetween(random, 33, 40);
		Appt appt5 = new Appt(sHour,
				sMinute ,
				tempDay,
				thisMonth ,
				sYear ,
				t,
				d);
		if(diagnose){
			System.out.println(appt2.toString());
		}
		int [] rec = {1,2};

		appt5.setRecurrence(rec,Appt.RECUR_BY_WEEKLY,recInt,recNum);
		listAppts.add(appt5);

		TimeTable timeTable=new TimeTable();
		//Create a linked list of calendar days to return
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		if (diagnose) {

			System.out.println("The number of appointments between " + todatDate + " and " + tomorrowDate);
			calDays = new LinkedList<CalDay>();
			calDays = timeTable.getApptRange(listAppts, today, nextDay);
			for (int i = 0; i < calDays.size(); i++) {
				System.out.println(calDays.get(i).toString());
			}

			LinkedList<Appt> lAppts = new LinkedList<Appt>();
			lAppts.add(null);
			timeTable.deleteAppt(listAppts, listAppts.get(2));
			timeTable.deleteAppt(listAppts, null);
          //  timeTable.deleteAppt(null, listAppts.get(0));
//			timeTable.deleteAppt(listAppts, listAppts.get(4));
//			assertEquals(listAppts, timeTable.getApptRange(listAppts,today,nextDay));
//			assertEquals(listAppts, timeTable.getApptRange(listAppts,today,tomorrow));
//			assertNotEquals(null,timeTable.deleteAppt(listAppts, listAppts.get(2)));

//			assertNull(timeTable.deleteAppt(lAppts, lAppts.get(0)));

			assertEquals(null, timeTable.deleteAppt(listAppts, listAppts.get(3)));
			assertEquals(null, timeTable.deleteAppt(lAppts, lAppts.get(0)));

		}
            elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
            if ((iteration % 10000) == 0 && iteration != 0)
                System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

        }

	}

    @Test
    public void randTest2()  throws Throwable  {

        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

        System.out.println("Start testing...");

        boolean diagnose = true;
        Calendar rightnow = Calendar.getInstance();
        //current month/year/date is today


        LinkedList<Appt> listAppts = new LinkedList<Appt>();

        for (int iteration = 0; elapsed < TestTimeout; iteration++) {
            long randomseed = System.currentTimeMillis(); //10
            //			System.out.println(" Seed:"+randomseed );
            Random random = new Random(randomseed);
            int thisMonth = ValuesGenerator.getRandomIntBetween(random, 2, 4);
            int thisYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2022);
            int thisDay = ValuesGenerator.getRandomIntBetween(random, 26, 28);

            GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
            GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
            int randYear = ValuesGenerator.getRandomIntBetween(random, 2060, 2070);
            int randMonth = ValuesGenerator.getRandomIntBetween(random, 2, 5);
            int randDay = ValuesGenerator.getRandomIntBetween(random, 15, 25);
            GregorianCalendar nextDay = new GregorianCalendar(randYear,randMonth,randDay);
            tomorrow.add(Calendar.DAY_OF_MONTH,1);
            nextDay.add(Calendar.DAY_OF_MONTH,1);
            String todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
            String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);
            String nextDate=nextDay.get(Calendar.MONTH)+ "/"+ nextDay.get(Calendar.DAY_OF_MONTH)+"/"+nextDay.get(Calendar.YEAR);

            int startHour=ValuesGenerator.getRandomIntBetween(random, 22, 24);
            int startMinute=ValuesGenerator.getRandomIntBetween(random, 20, 35);
            int startDay=thisDay;
            int startMonth=thisMonth;
            int startYear=thisYear;
            String title="Birthday Party";
            String description="This is my birthday party.";
            //Construct a new Appointment object with the initial data
            Appt appt1 = new Appt(startHour,
                    startMinute ,
                    startDay ,
                    startMonth ,
                    startYear ,
                    title,
                    description);
            if(diagnose){
                System.out.println(appt1.toString());
            }
            int [] recurDays = {1,2,3,4,5,6};
            int recurBy = 2;
            int recurIncrement = 1;
            int recurNumber = 100;
            appt1.setRecurrence(recurDays,Appt.RECUR_BY_YEARLY,recurIncrement,recurNumber);
            listAppts.add(appt1);

            int sHour=ValuesGenerator.getRandomIntBetween(random, 10, 16);
            int sMinute=ValuesGenerator.getRandomIntBetween(random, 20, 40);
            int sDay=ValuesGenerator.getRandomIntBetween(random, thisDay, thisDay+3);
            int sMonth=ValuesGenerator.getRandomIntBetween(random, 1, 2);
            int sYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2020);
            String t="Birthday Party";
            String d="This is my birthday party.";
            //Construct a new Appointment object with the initial data
            Appt appt2 = new Appt(sHour,
                    sMinute ,
                    sDay ,
                    sMonth ,
                    sYear ,
                    t,
                    d);
            if(diagnose){
                System.out.println(appt2.toString());
            }
            int [] recurs = {1};
            appt2.setRecurrence(recurDays,Appt.RECUR_BY_MONTHLY,recurIncrement,recurNumber);

            listAppts.add(appt2);

            sDay=ValuesGenerator.getRandomIntBetween(random, 25, 31);
            sYear=ValuesGenerator.getRandomIntBetween(random, 2015, 2017);
            //Construct a new Appointment object with the initial data
            Appt appt3 = new Appt(sHour,
                    sMinute ,
                    sDay ,
                    sMonth ,
                    sYear ,
                    t,
                    d);
            if(diagnose){
                System.out.println(appt2.toString());
            }
            int [] recurd = {1,2};
            appt3.setRecurrence(recurd,Appt.RECUR_BY_MONTHLY,2,Appt.RECUR_NUMBER_FOREVER);
            listAppts.add(appt3);

            sDay=ValuesGenerator.getRandomIntBetween(random, 200, 230);
            sMonth=ValuesGenerator.getRandomIntBetween(random, 3, 5);
            sYear=ValuesGenerator.getRandomIntBetween(random, 2050, 2060);
            //Construct a new Appointment object with the initial data
            Appt appt4 = new Appt(sHour,
                    sMinute ,
                    sDay ,
                    sMonth ,
                    sYear ,
                    t,
                    d);
            if(diagnose){
                System.out.println(appt2.toString());
            }
            int [] recurds = {};
            int recInt = ValuesGenerator.getRandomIntBetween(random, 2, 3);
            int recNum = ValuesGenerator.getRandomIntBetween(random, 3, 5);
            appt4.setRecurrence(null,Appt.RECUR_BY_WEEKLY,recInt,recNum);
            listAppts.add(appt4);

            int tempDay = ValuesGenerator.getRandomIntBetween(random, 33, 40);
            Appt appt5 = new Appt(sHour,
                    sMinute ,
                    tempDay,
                    thisMonth ,
                    sYear ,
                    t,
                    d);
            if(diagnose){
                System.out.println(appt2.toString());
            }
            int [] rec = {1,2};

            appt5.setRecurrence(rec,Appt.RECUR_BY_WEEKLY,recInt,recNum);
            listAppts.add(appt5);

            TimeTable timeTable=new TimeTable();
            //Create a linked list of calendar days to return
            LinkedList<CalDay> calDays = new LinkedList<CalDay>();
            if (diagnose) {

                System.out.println("The number of appointments between " + todatDate + " and " + tomorrowDate);
                calDays = new LinkedList<CalDay>();
                calDays = timeTable.getApptRange(listAppts, today, nextDay);
                for (int i = 0; i < calDays.size(); i++) {
                    System.out.println(calDays.get(i).toString());
                }

                LinkedList<Appt> lAppts = new LinkedList<Appt>();
                lAppts.add(null);
                timeTable.deleteAppt(listAppts, listAppts.get(2));
                timeTable.deleteAppt(listAppts, null);
                timeTable.deleteAppt(null, listAppts.get(0));
//			timeTable.deleteAppt(listAppts, listAppts.get(4));
//			assertEquals(listAppts, timeTable.getApptRange(listAppts,today,nextDay));
//			assertEquals(listAppts, timeTable.getApptRange(listAppts,today,tomorrow));
//			assertNotEquals(null,timeTable.deleteAppt(listAppts, listAppts.get(2)));

//			assertNull(timeTable.deleteAppt(lAppts, lAppts.get(0)));

                assertEquals(null, timeTable.deleteAppt(listAppts, listAppts.get(3)));
                assertEquals(null, timeTable.deleteAppt(lAppts, lAppts.get(0)));

            }
            elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
            if ((iteration % 10000) == 0 && iteration != 0)
                System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

        }

    }
	
}
