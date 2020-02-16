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

   /**
    * Main method for testing TeamMember.java
    * Tests each method and constructor in TeamMember.java
    */
   public static void main(String [] args) {
      // Creates TeamMember Object for testing
      System.out.println();
      String testName = "Turing";
      Date testDate = new Date("6/23/1912");
      TeamMember tm = new TeamMember(testName, testDate);

      // use toString() method to display the content of the object
      System.out.println("Testing constructor and toString() method by displaying content of the Test Object:");
      System.out.println();
      System.out.println("Expected Output:\tTuring 6/23/1912");
      System.out.println("Actual Output:\t\t"+tm.toString());
      System.out.println("\n");

      // test getStartDate
      System.out.println("Testing getStartDate()\n");
      // Print start date
      System.out.println("Print Start Date: ");
      System.out.println("Expected Output:\t6/23/1912");
      System.out.println("Actual Output:\t\t"+tm.getStartDate().toString());
      System.out.println();
      // Check if Date is Valid
      System.out.println("Check if Date is Valid: ");
      System.out.println("Expected Output:\ttrue");
      System.out.println("Actual Output:\t\t"+tm.getStartDate().isValid());
      System.out.println("\n");

      //Testing the equals() method
      System.out.println("Testing the .equals() method");
      System.out.println();
      //Case Equal
      TeamMember tm2 = new TeamMember(testName, testDate);
      System.out.println("Case 1, Equal TeamMember");
      System.out.println("Expected Output:\ttrue");
      System.out.println("Actual Output:\t\t"+tm.equals(tm2));
      System.out.println();
      //Case Name Unequal
      tm2 = new TeamMember("Alan", testDate);
      System.out.println("Case 2, Unequal Name");
      System.out.println("Expected Output:\tfalse");
      System.out.println("Actual Output:\t\t"+tm.equals(tm2));
      System.out.println();
      //Case Date Unequal
      tm2 = new TeamMember(testName, new Date("2/14/2020"));
      System.out.println("Case 3, Unequal Date");
      System.out.println("Expected Output:\tfalse");
      System.out.println("Actual Output:\t\t"+tm.equals(tm2));
   }
}