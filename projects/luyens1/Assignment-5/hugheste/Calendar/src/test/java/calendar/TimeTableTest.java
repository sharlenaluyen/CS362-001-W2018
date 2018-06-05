package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.*;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 boolean diagnose = true;
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 int thisMonth = rightnow.get(Calendar.MONTH)+1;
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();

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

		 assertEquals(calDays,timeTable.getApptRange(listAppts,today,tomorrow));
        assertEquals(today,calDays.getFirst());
	    assertEquals(tomorrow,calDays.getLast());
	    timeTable.deleteAppt(listAppts, listAppts.get(1));
	    int [] p = {1,2,3};
	    timeTable.permute(listAppts,p);
     }
	 @Test
	  public void test02()  throws Throwable  {
         boolean diagnose = true;
         Calendar rightnow = Calendar.getInstance();
         //current month/year/date is today
         int thisMonth = rightnow.get(Calendar.MONTH)+1;
         int thisYear = rightnow.get(Calendar.YEAR);
         int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
         LinkedList<Appt> listAppts = new LinkedList<Appt>();

         GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
         GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
         tomorrow.add(Calendar.DAY_OF_MONTH,1);
         String todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
         String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);

         int startHour=-1;
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

         assertEquals(calDays,timeTable.getApptRange(listAppts,today,tomorrow));
         timeTable.deleteAppt(listAppts, listAppts.get(1));
         int [] p = {1,2,3};
         timeTable.permute(listAppts,p);
     }

    @Test
    public void test03()  throws Throwable  {
        boolean diagnose = true;
        Calendar rightnow = Calendar.getInstance();
        //current month/year/date is today
        int thisMonth = rightnow.get(Calendar.MONTH)+1;
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
        LinkedList<Appt> listAppts = new LinkedList<Appt>();

        GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
        GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
        GregorianCalendar nextDay = (GregorianCalendar)today.clone();
        tomorrow.add(Calendar.DAY_OF_MONTH,1);
        nextDay.add(Calendar.DAY_OF_MONTH,1);
        String todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
        String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);
        String nextDate=nextDay.get(Calendar.MONTH)+ "/"+ nextDay.get(Calendar.DAY_OF_MONTH)+"/"+nextDay.get(Calendar.YEAR);

        int startHour=15;
        int startMinute=30;
        int startDay=thisDay+1;
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
        int [] recurDays = {1,2};
        int recurBy = 2;
        int recurIncrement = 2;
        int recurNumber = 2;
        appt1.setRecurrence(recurDays,recurBy,recurIncrement,recurNumber);
        listAppts.add(appt1);

        int sHour=15;
        int sMinute=30;
        int sDay=thisDay+2;
        int sMonth=thisMonth;
        int sYear=thisYear;
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

        listAppts.add(appt2);

        sHour=15;
        sMinute=30;
        sDay=thisDay+3;
        sMonth=thisMonth;
        sYear=thisYear;
        t="Birthday Party";
        d="This is my birthday party.";
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
        listAppts.add(appt3);


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

        assertEquals(calDays,timeTable.getApptRange(listAppts,today,tomorrow));
        timeTable.deleteAppt(listAppts, listAppts.get(0));
        timeTable.deleteAppt(listAppts, listAppts.get(2));
        timeTable.deleteAppt(listAppts, listAppts.get(1));
        int [] p = {1,2,3};
        timeTable.permute(listAppts,p);
    }

    @Test
    public void test04()  throws Throwable  {
        boolean diagnose = true;
        Calendar rightnow = Calendar.getInstance();
        //current month/year/date is today
        int thisMonth = rightnow.get(Calendar.MONTH)+1;
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
        LinkedList<Appt> listAppts = new LinkedList<Appt>();

        GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
        GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
        GregorianCalendar nextDay = (GregorianCalendar)today.clone();
        tomorrow.add(Calendar.DAY_OF_MONTH,1);
        nextDay.add(Calendar.DAY_OF_MONTH-3,1);
        String todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
        String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);
        String nextDate=nextDay.get(Calendar.MONTH)+ "/"+ nextDay.get(Calendar.DAY_OF_MONTH)+"/"+nextDay.get(Calendar.YEAR);

        tomorrow.set(2017,04,21);

        int startHour=10;
        int startMinute=35;
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
        int[] recurDaysArr={1,2,3,4,5,6};
        //appt1.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 10, Appt.RECUR_NUMBER_FOREVER);
        //int [] recurDays = {1,2};
        int recurBy = 1;
        int recurIncrement = 1;
        int recurNumber = 2;
        appt1.setRecurrence(recurDaysArr,1,10,10);
        listAppts.add(appt1);



        int sHour=10;
        int sMinute=30;
        int sDay=thisDay;
        int sMonth=thisMonth;
        int sYear=thisYear;
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

        listAppts.add(appt2);

        sHour=17;
        sMinute=40;
        sDay=thisDay;
        sMonth=thisMonth;
        sYear=thisYear;
        t="Birthday Party";
        d="This is my birthday party.";
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
        listAppts.add(appt3);

        sHour=17;
        sMinute=70;
        sDay=thisDay;
        sMonth=thisMonth;
        sYear=thisYear;
        t="Birthday Party";
        d="This is my birthday party.";
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
        listAppts.add(appt4);

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

        assertEquals(calDays,timeTable.getApptRange(listAppts,today,nextDay));

        timeTable.deleteAppt(listAppts, listAppts.get(1));
        timeTable.permute(listAppts, null);
        int [] p = {1,2,3};
        timeTable.permute(listAppts,p);
    }

    @Test
    public void test05()  throws Throwable  {
        boolean diagnose = true;
//        Calendar rightnow = Calendar.getInstance();
        //current month/year/date is today
        long randomseed = System.currentTimeMillis(); //10
        //			System.out.println(" Seed:"+randomseed );
        Random random = new Random(randomseed);
        int startHour = ValuesGenerator.getRandomIntBetween(random, 6, 11);
        int startMinute = ValuesGenerator.RandInt(random);
        int thisDay = ValuesGenerator.RandInt(random);

        int thisMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
        int thisYear = ValuesGenerator.RandInt(random);
        String title = "Birthday Party";
        String description = "This is my birthday party.";

        LinkedList<Appt> listAppts = new LinkedList<Appt>();

        GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
        GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
        GregorianCalendar nextDay = new GregorianCalendar(2060,02,20);
        tomorrow.add(Calendar.DAY_OF_MONTH,1);
        nextDay.add(Calendar.DAY_OF_MONTH,1);
        String todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
        String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);
        String nextDate=nextDay.get(Calendar.MONTH)+ "/"+ nextDay.get(Calendar.DAY_OF_MONTH)+"/"+nextDay.get(Calendar.YEAR);

        startHour=23;
        startMinute=30;
        int startDay=thisDay;
        int startMonth=thisMonth;
        int startYear=thisYear;
        title="Birthday Party";
        description="This is my birthday party.";
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

        int sHour=15;
        int sMinute=30;
        int sDay=thisDay+2;
        int sMonth=1;
        int sYear=thisYear+2;
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

        sHour=15;
        sMinute=30;
        sDay=31;
        sMonth=03;
        sYear=2017;
        t="Birthday Party";
        d="This is my birthday party.";
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


        sHour=15;
        sMinute=30;
        sDay=211;
        sMonth=04;
        sYear=2050;
        t="Birthday Party";
        d="This is my birthday party.";
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
        appt4.setRecurrence(null,Appt.RECUR_BY_WEEKLY,2,4);
        listAppts.add(appt4);

        //Appt appt5 = null;
        //listAppts.add(appt5);
        Appt appt5 = new Appt(sHour,
                sMinute ,
                33 ,
                thisMonth ,
                sYear ,
                t,
                d);
        if(diagnose){
            System.out.println(appt2.toString());
        }
        int [] rec = {1,2};

        appt5.setRecurrence(rec,Appt.RECUR_BY_WEEKLY,2,5);
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
            timeTable.deleteAppt(listAppts, listAppts.get(4));
            assertEquals(listAppts, timeTable.getApptRange(listAppts,today,nextDay));
            assertEquals(listAppts, timeTable.getApptRange(listAppts,today,tomorrow));
            assertNotEquals(null,timeTable.deleteAppt(listAppts, listAppts.get(2)));

            assertNull(timeTable.deleteAppt(lAppts, lAppts.get(0)));

            assertEquals(null, timeTable.deleteAppt(listAppts, listAppts.get(3)));
            assertEquals(null, timeTable.deleteAppt(lAppts, lAppts.get(0)));

            int[] pv = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            assertNotEquals(listAppts,timeTable.permute(listAppts, pv));
            int [] p = {1,2,1};
            timeTable.permute(listAppts,p);
        }
        //timeTable.getNextApptOccurrence(listAppts,listAppts.get(2));
	 }

}
