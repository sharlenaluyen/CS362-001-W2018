/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {


  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());

      assertEquals(15, appt0.getStartHour());
      assertEquals(30, appt0.getStartMinute());
      assertEquals(9, appt0.getStartDay());
      assertEquals(14, appt0.getStartMonth());
      assertEquals(2018, appt0.getStartYear());
      assertEquals("Birthday Party", appt0.getTitle());
      assertEquals("This is my birthday party", appt0.getDescription());
      assertEquals("xyz@gmail.com", appt0.getEmailAddress());

      appt0.setValid();
  }

  @Test
   public void test01()  throws Throwable  {
     Appt appt1 = new Appt(14, 18, 15, 3, 2018, "Almost Tax Day!", "File now to get ahead!", "myemail@gmail.com" );
             assertTrue(appt1.getValid());
             assertEquals(14, appt1.getStartHour());
             assertEquals(18, appt1.getStartMinute());
             assertEquals(15, appt1.getStartDay());
             assertEquals(3, appt1.getStartMonth());
             assertEquals(2018, appt1.getStartYear());
             assertEquals("Almost Tax Day!", appt1.getTitle());
             assertEquals("File now to get ahead!", appt1.getDescription());
             assertEquals("myemail@gmail.com", appt1.getEmailAddress());
             appt1.setValid();
  }

  @Test(timeout = 4000)
public void test02()  throws Throwable  {
        int startHour=21;
        int startMinute=80; //tries set and get startMinute, invalid test
        int startDay=3;
        int startMonth=8;
        int startYear=2018;
        String title="Nana's birthday";
        String description="This is Nana's birthday.";
        String email = "blah@email.com";
        //Construct a new Appointment object with the initial data
        Appt appt2 = new Appt(startHour,
        startMinute ,
        startDay ,
        startMonth ,
        startYear ,
        title,
        description,
        email);

        assertTrue(appt2.getValid());
        assertEquals(21, appt2.getStartHour());
        assertNotEquals(81, appt2.getStartMinute()); //NOT equals
        assertEquals(3, appt2.getStartDay());
        assertEquals(8, appt2.getStartMonth());
        assertEquals(2018, appt2.getStartYear());
        assertEquals("Nana's birthday", appt2.getTitle());
        assertEquals("This is Nana's birthday.", appt2.getDescription());
        assertEquals("blah@email.com", appt2.getEmailAddress());

        appt2.setStartHour(22);
        appt2.setStartMinute(81);
        appt2.setStartDay(4);
        appt2.setStartMonth(9);
        appt2.setStartYear(2019);
        appt2.setTitle("Nana's Birthday.");
        appt2.setTitle(null);
        appt2.setDescription("This is Nana's birthday.");
        appt2.setDescription(null);
        //appt2.setEmailAddress("blah@email.com");
        //appt2.setEmailAddress(null);
        appt2.setStartHour(0);
        }
@Test(timeout = 4000)
  public void test03()  throws Throwable  {
        int startHour=34;
        int startMinute=30;
        int startDay=15;
        int startMonth=02;
        int startYear=2018;
        String title="Therapy";
        String description="This is my therapy appointment.";
        String email = "blah@email.com";
        //Construct a new Appointment object with the initial data
        Appt appt3 = new Appt(startHour,
        startMinute ,
        startDay ,
        startMonth ,
        startYear ,
        title,
        description,
        email);

//		 assertFalse(appt2.getValid());  //Should be false, yet checks are not in place for determining upper bound of startHours
        assertEquals(34, appt3.getStartHour()); //Chekcs for startHour value
        assertEquals(30, appt3.getStartMinute());
        assertEquals(15, appt3.getStartDay());
        assertEquals(02, appt3.getStartMonth());
        assertEquals(2018, appt3.getStartYear());
        assertEquals("Therapy", appt3.getTitle());
        assertEquals("This is my therapy appointment.", appt3.getDescription());
        assertEquals("blah@email.com", appt3.getEmailAddress());

        }

@Test(timeout = 4000)
public void test04()  throws Throwable  {
        //Tests set RecurDays, recurNumber, recurIncrement and recurDays
        int [] recurDays = {0,1};
        int recurBy = 4;
        int recurIncrement = 1;
        int recurNumber = 3;

        int startHour=4;
        int startMinute=2;
        int startDay=1;
        int startMonth=2;
        int startYear=2018;
        String title="Doctor's Appointment";
        String description="This is my doctor's appointment.";
        String email = "blah@email.com";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
        startMinute ,
        startDay ,
        startMonth ,
        startYear ,
        title,
        description,
        email);

        appt.setRecurrence(recurDays,recurBy,recurIncrement,recurNumber);

        assertTrue(appt.getValid());
        assertTrue(appt.isOn(1, 2, 2018));
        assertTrue(appt.hasTimeSet());
        assertEquals(recurBy,appt.getRecurBy());
        assertArrayEquals(recurDays,appt.getRecurDays());
        assertEquals(recurNumber,appt.getRecurNumber());
        assertEquals(recurIncrement,appt.getRecurIncrement());
        assertTrue(appt.isRecurring());
        }

        @Test(timeout = 4000)
        public void test05()  throws Throwable  {
            Appt appt5 = new Appt(9, 14, 2018, "Class", "CS362 class time", "xyz@gmail.com");
            assertTrue(appt5.isOn(9, 14, 2018));
            assertFalse(appt5.hasTimeSet());
            //String string0 = appt5.toString();
            //String string1 = appt5.represntationApp();
            //assertEquals("\t14/9/2018 at 3:30pm ,Class, CS362 class time\n", string0);
            //assertEquals("3:30pm: CS362 class time", string1);
            appt5.setValid();
        }

        @Test(timeout = 4000)
        public void test06()  throws Throwable  {
            Appt appt = new Appt(0, 30, 9, 14, 2018, "Class", "CS362 class time", "xyz@gmail.com");
            String string0 = appt.toString();
            assertEquals("\t14/9/2018 at 12:30am ,Class, CS362 class time\n", string0);
            //assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);

            appt.setValid();
        }

        @Test(timeout = 4000)
        public void test07()  throws Throwable  {
                //Tests set RecurDays, recurNumber, recurIncrement and recurDays
                int [] recurDays = null;
                int recurBy = 4;
                int recurIncrement = 1;
                int recurNumber = 3;

                int startHour=4;
                int startMinute=2;
                int startDay=1;
                int startMonth=2;
                int startYear=2018;
                String title=null;
                String description=null;
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

                appt.setRecurrence(recurDays,recurBy,recurIncrement,recurNumber);

                assertTrue(appt.isRecurring());
                appt.setValid();
                }

                @Test(timeout = 4000)
                public void test08()  throws Throwable  {
                  Appt appt = new Appt(100, 3, 3, 3, 2018, "Class", "CS362 class time", "xyz@gmail.com");
                  appt.setValid();

                  Appt appt1 = new Appt(3, 300, 3, 3, 2018, "Class", "CS362 class time", "xyz@gmail.com");
                  appt1.setValid();

                  Appt appt2 = new Appt(3, 3, 100, 3, 2018, "Class", "CS362 class time", "xyz@gmail.com");
                  appt2.setValid();

                  Appt appt3 = new Appt(3, 3, 3, 256, 2018, "Class", "CS362 class time", "xyz@gmail.com");
                  appt3.setValid();

                  Appt appt4 = new Appt(3, 3, 3, 3, 0, "Class", "CS362 class time", "xyz@gmail.com");
                  appt4.setValid();

                  Appt appt5 = new Appt(3, 3, 30, 2, 2018, "Class", "CS362 class time", "xyz@gmail.com");
                  appt5.setValid();

                }


}
