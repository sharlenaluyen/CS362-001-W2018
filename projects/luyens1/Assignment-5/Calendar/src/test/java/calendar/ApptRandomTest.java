package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur
        }
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur
        }
   /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data
				 //Construct a new Appointment object with the initial data
		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);

			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);
							 if (newTitle == null){
								 assertTrue(appt.getTitle() == "");
							 } else {
								 assertTrue(appt.getTitle() == newTitle);
							 }
						}
						else if (methodName.equals("setRecurDays")){
							int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
							int nullCheck=ValuesGenerator.getRandomIntBetween(random, 1, 2);
							if(nullCheck == 1) {
								int[] recurDays=null;
								int recur=ApptRandomTest.RandomSelectRecur(random);
								int recurIncrement = ValuesGenerator.RandInt(random);
								int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
								appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
								assertNull(appt.getRecurDays());
							}
							else {
								int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
								int recur=ApptRandomTest.RandomSelectRecur(random);
								int recurIncrement = ValuesGenerator.RandInt(random);
								int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
								appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
								for( int j = 0; j < sizeArray; j++) {
									assertEquals(recurDays[j], (appt.getRecurDays()[j]));
								}
							}
					 } else if(methodName.equals("isOn")) {
						 System.out.println("in ISON");
							int newDay=ValuesGenerator.getRandomIntBetween(random, 0, 32);
						 int newMonth=ValuesGenerator.getRandomIntBetween(random, 0, 13);
						 int newYear=ValuesGenerator.getRandomIntBetween(random, -100, 2018);
						 appt.setStartDay(newDay);
						 appt.setStartMonth(newMonth);
						 appt.setStartYear(newYear);
						 assertTrue(appt.isOn(newDay, newMonth, newYear));
						 assertFalse(appt.isOn(newDay+1, newMonth, newYear));
						 assertFalse(appt.isOn(newDay, newMonth+1, newYear));
						 assertFalse(appt.isOn(newDay, newMonth, newYear+1));

						} else if(methodName.equals("________________")) {

						}else if(methodName.equals("________________")) {

						}else if(methodName.equals("________________")) {

						}
				}

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		 System.out.println("Done testing...");
	 }



@Test
public void isOnTestAssignment40000() throws Throwable
{

//	Appt appt = new Appt(100, 3, 3, 3, 2018, "Class", "CS362 class time", "xyz@gmail.com");
	//assertTrue(appt.isOn(03, 03, 2018));
	//System.out.println("in ISON");
	Random random = new Random(randomseed);
	int newDay=ValuesGenerator.getRandomIntBetween(random, 0, 32);
	int newMonth=ValuesGenerator.getRandomIntBetween(random, 0, 13);
	int newYear=ValuesGenerator.getRandomIntBetween(random, -100, 2018);
	appt.setStartDay(newDay);
	appt.setStartMonth(newMonth);
	appt.setStartYear(newYear);
	assertTrue(appt.isOn(newDay, newMonth, newYear));
	assertFalse(appt.isOn(newDay+1, newMonth, newYear));
	assertFalse(appt.isOn(newDay, newMonth+1, newYear));
	assertFalse(appt.isOn(newDay, newMonth, newYear+1));

}
//assertTrue(appt.isOn(1, 2, 2018));




@Test
    public void testIsOn() throws Throwable
    {
        for (int i = 0; i < 1000000; i++) {
            Appt appt = new Appt(100, 3, 3, 3, 2018, "Class", "CS362 class time", "xyz@gmail.com");
            assertTrue(appt.isOn(appt.getStartDay(), appt.getStartMonth(), appt.getStartYear()));
            long randomseed = System.currentTimeMillis();
            Random random = new Random(randomseed);
            int randDay = ValuesGenerator.getRandomIntBetween(random, 0, 32);
            int randMonth = ValuesGenerator.getRandomIntBetween(random, 0, 13);
            int randYear = ValuesGenerator.getRandomIntBetween(random, -100, 2018);
            if (randDay == appt.getStartDay() && randMonth == appt.getStartMonth() && randYear == appt.getStartYear()) {
                continue;
            }
            assertFalse(appt.isOn(randDay, randMonth, randYear));
        }
    }
























}
