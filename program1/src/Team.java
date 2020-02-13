/**
  
 @author  
 */
public class Team {
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;
   
   public Team() {
      team = new TeamMember[GROW_SIZE];
      numMembers = 0;
   }
   
   private int find(TeamMember m) {
       for (int i = 0; i < team.length; ++i) {
          if (m.equals(team[i])) {
             return i;
          }
       }
       return NOT_FOUND;
   }
   
   private void grow() {
       TeamMember[] tmp = new TeamMember[numMembers + GROW_SIZE];
       for (int i = 0; i < team.length; ++i) {
          tmp[i] = team[i];
       }
       team = tmp;
   }
   
   public boolean isEmpty() {
       return numMembers == 0;
   }
   
   public void add(TeamMember m) {
      if (numMembers + 1 > team.length) grow();
      for (int i = 0; i < team.length; ++i) {
         if (team[i] == null) {
            team[i] = m;
            ++numMembers;
            return;
         }
      }
   }
   
   public boolean remove(TeamMember m) {
       if (!contains(m) || isEmpty()) return false;
       TeamMember tmp = team[numMembers - 1];
       team[numMembers - 1] = null;
       for (int i = 0; i < team.length; ++i) {
          if (team[i].equals(m)) {
             team[i] = tmp;
             return true;
          }
       }
       return false;
   } 
   
   public boolean contains(TeamMember m) {
      for (TeamMember tm : team) {
         if (m.equals(tm)) return true;
      }
      return false;
   } 
   
   public void print() {
       if (isEmpty()) return;
       for (TeamMember m : team) System.out.println(m.toString());
   }
}
