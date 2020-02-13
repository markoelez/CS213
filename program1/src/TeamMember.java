/**
 * Defines a TeamMember class representing the properties of a team member object.
 * @author  Marko Elez
 */
public class TeamMember {
   private String name;
   private Date startDate;
   
   public TeamMember(String nm, Date date) {
       name = nm;
       startDate = date;
   }

   /**
    * startDate getter.
    * @return startDate parameter.
    */
   public Date getStartDate() {
      return startDate;
   }

   /**
    * TeamMember equality check.
    * @param obj target object we are checking for equality against.
    * @return true if obj is a TeamMember equal to this instance.
    */
   public boolean equals(Object obj) {
      if (obj == null) return false;
      else if (!(obj instanceof TeamMember)) return false;
      else return ((TeamMember) obj).name.equals(name) && ((TeamMember) obj).startDate == startDate;
   }

   /**
    * String representation of TeamMember instance
    * @return string representation of this TeamMember's properties.
    */
   public String toString() {
      return name + ' ' + startDate.toString();
   }

   public static void main(String [] args) {
      //testbed main; you must include test cases that exercise 
      //the constructor and all methods in this class.
   }
}