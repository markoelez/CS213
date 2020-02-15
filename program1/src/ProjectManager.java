import java.util.Scanner;

/**
 * Defines a TeamMember class representing the properties of a team member object.
 * @author  Marko Elez, Aaron Galang
 */
public class ProjectManager {

   Scanner stdin;
   Team cs213;

   /**
    * Main loop - waits for terminal inputs and processes commands.
    */
   public void run() {

      System.out.println("Let's start a new team!");
      cs213 = new Team();
      stdin = new Scanner(System.in);

      while (true) {
         try {
            String command = stdin.next();
            switch (command) {
               case "A" :
                  add();
                  break;
               case "R":
                  remove();
                  break;
               case "P":
                  print();
                  break;
               case "Q":
                  print();
                  System.out.println("The team is ready to go!");
                  return;
               default:
                  System.out.println("Command " + "'" + command + "'" + " is not supported!");
                  stdin.next();
                  stdin.next();
                  break;
            }
         } catch (Exception e) {
            System.out.println(e);
         }
      }
      //write java code before you terminate the program
   } //run()

   /**
    * Add command - adds new team member to current team.
    */
   private void add() {
      String name = stdin.next();
      Date date = new Date(stdin.next());
      if (!date.isValid()) {
         System.out.println(date.toString() + " is not a valid date!");
         return;
      }
      TeamMember tm = new TeamMember(name, date);
      if (cs213.contains(tm)) {
         System.out.println(tm.toString() + " is already in the team.");
         return;
      }
      cs213.add(tm);
      System.out.println(tm.toString() + " has joined the team.");
   }

   /**
    * Remove command - finds specified team member and removes them from team.
    */
   private void remove() {
      String name = stdin.next();
      Date date = new Date(stdin.next());
      if (!date.isValid()) {
         System.out.println(date.toString() + " is not a valid date!");
         return;
      }
      TeamMember tm = new TeamMember(name, date);
      if (!cs213.contains(tm)) {
          System.out.println(tm.toString() + " is not a team member.");
          return;
      }
      cs213.remove(tm);
      System.out.println(tm.toString() + " has left the team.");
   }

   /**
    * Print command - prints all team members in current team.
    */
   private void print() {
      if (cs213.isEmpty()) {
         System.out.println("We have 0 team members!");
         return;
      }
       System.out.println("We have the following team members:");
      cs213.print();
      System.out.println("-- end of the list --");
   }
} //ProjectManager
