/**
  
 @author  
 */
public class Date {
   private int day;
   private int month;
   private int year;
   
   public Date(String d) {
      String[] tokens = d.split("/");
      month = Integer.parseInt(tokens[0]);
      day = Integer.parseInt(tokens[1]);
      year = Integer.parseInt(tokens[2]);
   }
   
   public Date(Date d) {
      //this is a constructor
   }      
   
   public boolean isValid() {
      // get string representations for regex
      String d = Integer.toString(day);
      String m = Integer.toString(month);
      String y = Integer.toString(year);
      // preliminary check for date formatting
      if (!(m + "/" + d + "/" + y).matches("^(\\d{1,2}/){2}\\d{4}$")) return false;
      // check if the year itself is valid
      if (year > 2020) return false;
      boolean leapYear = false;
      // check if this is a leap year date
      if (year % 4 == 0) {
         if (year % 100 == 0) {
            if (year % 400 == 0) {
               leapYear = true;
            }
         } else {
            leapYear = true;
         }
      }

      int[] monthsWith31Days = new int[]{1, 3, 5, 7, 8, 10, 12};
      int[] monthsWith30Days = new int[]{4, 6, 9, 11};

      // check if this date is in february
      if (month == 2) {
         // if this is not a leap year, it must have 28 or less days
         return leapYear || day <= 28;
      // if this is a month with 30 days
      } else if (month == 4 || month == 6 || month == 9 || month == 11) {
         return day <= 30;
      // otherwise this is a month with 31 days
      } else {
         return day <= 31;
      }
   }
   
   @Override
   public String toString() {
      return month + "/" + day + "/" + year;
   }
   
   @Override
   public boolean equals(Object obj) {
      if (obj == null) return false;
      else if (!(obj instanceof Date)) return false;
      else return ((Date) obj).month == month && ((Date) obj).day == day && ((Date) obj).year == year;
   }
}


