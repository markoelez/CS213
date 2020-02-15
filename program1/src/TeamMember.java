/**
 * Defines a TeamMember class representing the properties of a team member object.
 * @author  Marko Elez, Aaron Galang
 */
public class TeamMember {
   private String name;
   private Date startDate;
   
   public TeamMember(String nm, Date date) {
       name = nm;
       startDate = date;
   }

   /**
    * StartDate getter.
    * @return StartDate parameter of team member object.
    */
   public Date getStartDate() {
      return startDate;
   }

   /**
    * TeamMember equality check.
    * @param obj Target object we are checking for equality against.
    * @return Whether target TeamMember is equal to this instance.
    */
   public boolean equals(Object obj) {
      if (obj == null) return false;
      else if (!(obj instanceof TeamMember)) return false;
      else return ((TeamMember) obj).name.equals(name) && ((TeamMember) obj).startDate.equals(startDate);
   }

   /**
    * String representation of TeamMember instance
    * @return String representation of this TeamMember's properties.
    */
   public String toString() {
      return name + ' ' + startDate.toString();
   }

   public static void main(String [] args) {
      String testName = "testname";
      Date testDate = new Date("12/12/1231");
      TeamMember tm = new TeamMember(testName, testDate);

      // test date getter
      if (!tm.getStartDate().equals(testDate)) throw new NullPointerException();

      // test equals method
      Date testDate2 = new Date("12/12/1231");
      Date testDate3 = new Date("12/12/1232");
      TeamMember tm2 = new TeamMember("testname", testDate2);
      TeamMember tm3 = new TeamMember("testname2", testDate2);
      TeamMember tm4 = new TeamMember("testname", testDate3);
      if (!tm.equals(tm2)) throw new NullPointerException();
      if (tm.equals(tm3)) throw new NullPointerException();
      if (tm.equals(tm4)) throw new NullPointerException();

   }
}