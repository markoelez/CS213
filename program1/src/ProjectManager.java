import java.util.Scanner;

/**
  
 @author  
 */
 
public class ProjectManager {

   Scanner stdin;
   Team cs213;

   public void run() {

      System.out.println("Let's start a new team!");
      cs213 = new Team();
      stdin = new Scanner(System.in);

      boolean done = false;
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
            }
         } catch (Exception e) {
            System.out.println(e);
         }
      }
      //write java code before you terminate the program
   } //run()
   
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
   
   private void remove() {
      String name = stdin.next();
      Date date = new Date(stdin.next());
      if (!date.isValid()) {
         System.out.println(date.toString() + " is not a valid date!");
         return;
      }
      TeamMember tm = new TeamMember(name, date);
      cs213.remove(tm);
   }
   
   private void print() {
      if (cs213.isEmpty()) {
         System.out.println("We have 0 team members!");
         return;
      }
      cs213.print();
      System.out.println("-- end of the list --");
   }
} //ProjectManager
