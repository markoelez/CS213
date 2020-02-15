/**
 * Defines a Date class representing a Date in mm/dd/yyyy format.
 * @author  Marko Elez, Aaron Galang
 */
public class Date {
   private int day;
   private int month;
   private int year;

   /**
    * Date constructor - creates a date from its input.
    * @param d String representation of a date.
    */
   public Date(String d) {
      String[] tokens = d.split("/");
      month = Integer.parseInt(tokens[0]);
      day = Integer.parseInt(tokens[1]);
      year = Integer.parseInt(tokens[2]);
   }
   
   public Date(Date d) {
      //this is a constructor
   }

   /**
    * Date instance validity check.
    * @return Whether this date if valid or not.
    */
   public boolean isValid() {
      // get string representations for regex
      String d = Integer.toString(day);
      String m = Integer.toString(month);
      String y = Integer.toString(year);
      // preliminary check for date formatting
      if (!(m + "/" + d + "/" + y).matches("^(\\d{1,2}/){2}\\d{4}$")) return false;
      // check if the year itself is valid
      if (year > 2020) return false;
      // check if this is a leap year date
      boolean leapYear = false;
      if (year % 4 == 0) {
         if (year % 100 == 0) {
            if (year % 400 == 0) {
               leapYear = true;
            }
         } else {
            leapYear = true;
         }
      }
      // check if the month number is valid
      if (month < 0 || month > 12) return false;

      int[] monthsWith31Days = new int[]{1, 3, 5, 7, 8, 10, 12};
      int[] monthsWith30Days = new int[]{4, 6, 9, 11};

      // check if this date is in february
      if (month == 2) {
         // if this is not a leap year, it must have 28 or less days
         if (!leapYear) {
            return day <= 28;
         } else {
            return day <= 29;
         }
      // if this is a month with 30 days
      } else if (month == 4 || month == 6 || month == 9 || month == 11) {
         return day <= 30;
      // otherwise this is a month with 31 days
      } else {
         return day <= 31;
      }
   }

   /**
    * String conversion override.
    * @return String representation of date instance.
    */
   @Override
   public String toString() {
      return month + "/" + day + "/" + year;
   }

   /**
    * Date equality check.
    * @param obj Target object we are checking for equality against.
    * @return Whether target Date object is equal to this instance.
    */
   @Override
   public boolean equals(Object obj) {
      if (obj == null) return false;
      else if (!(obj instanceof Date)) return false;
      else return ((Date) obj).month == month && ((Date) obj).day == day && ((Date) obj).year == year;
   }

   /**
    * Test bed main method for Date class
    */
   public static void main(String[] args){
      // creates a Date object for testing
      Date testDate = new Date("2/13/2020");
      // creates a String to test with testDate
      String testString = null;

      // tests toString() by printing out the contents of testDate
      System.out.println(testDate.toString());

      // testing isValid function
      System.out.println("is this date valid?(it should be)");
      System.out.println("is " + testDate.toString() + " a valid date?: " + testDate.isValid());
      System.out.println();

      // testing to see valid days, with day -1 and 32 always being false
      System.out.println("Checking valid days");
      System.out.println("Day -1 and 32 should always be FALSE\nDay 28 should always be true\nDay 30 should be true in everywhere but month 2\nDay 31 should be false in months 1,3,5,7,8,10,12");
      System.out.println("-----------------------------------------------------------------");
      for(int i = 1; i < 13; ++i){
         System.out.println("MONTH " + i);
         //checks if -1 is a day
         testString = i + "/-1/2020";
         testDate = new Date(testString);
         System.out.println("is -1 a valid day in month " + i + "?: " + testDate.isValid());
         //checks if 28 is a day
         testString = i + "/28/2020";
         testDate = new Date(testString);
         System.out.println("is 28 a valid day in month " + i + "?: " + testDate.isValid());
         //checks if 30, 31, 32 is a day(32 should be false)
         for(int d = 30; d < 33; ++d){
            testString = i + "/" + d + "/2020";
            testDate = new Date(testString);
            System.out.println("is " + d + " a valid day in month " + i + "?: " + testDate.isValid());
         }
         System.out.println("-----------------------------------------------------------------");
      }
      System.out.println();


      // testing to see valid months, months 0 and 13 are added to make sure their false
      System.out.println("Checking valid months");
      for(int i = 0; i < 14; ++i){
         testString = i + "/13/2020";
         testDate = new Date(testString);
         System.out.println("is " + i + " a valid month?: " + testDate.isValid());
      }
      System.out.println();

      // testing to see valid years
      System.out.println("Checking valid years");
      testString = "2/13/2021";
      testDate = new Date(testString);
      System.out.println("Year 2021 should be FALSE");
      System.out.println("is " + 2021 + " a valid year?(this should be false): " + testDate.isValid());

      // testing to see if equals() works
      System.out.println("Checking equals() method\nThe first test should be true, the rest should obviously be false");
      testDate = new Date("2/13/2020");
      Date testDate2 = new Date("2/13/2020");
      System.out.println("is " + testDate.toString() + " and " + testDate2.toString() + " equivalent?: " + testDate.equals(testDate2));
      testDate = new Date("2/13/2020");
      testDate2 = new Date("1/13/2020");
      System.out.println("is " + testDate.toString() + " and " + testDate2.toString() + " equivalent?: " + testDate.equals(testDate2));
      testDate = new Date("2/13/2020");
      testDate2 = new Date("2/12/2020");
      System.out.println("is " + testDate.toString() + " and " + testDate2.toString() + " equivalent?: " + testDate.equals(testDate2));
      testDate = new Date("2/13/2020");
      testDate2 = new Date("2/13/2019");
      System.out.println("is " + testDate.toString() + " and " + testDate2.toString() + " equivalent?: " + testDate.equals(testDate2));
   }
}





