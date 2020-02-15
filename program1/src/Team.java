/**
 * Defines a "growable" container representing a Team object.
 * @author  Marko Elez, Aaron Galang
 */
public class Team {
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team;
   private int numMembers;

    /**
     * Team constructor - initializes "growable" container.
     */
   public Team() {
      team = new TeamMember[GROW_SIZE];
      numMembers = 0;
   }

    /**
     * Looks for target TeamMember object in the current Team instance.
     * @param m Target TeamMember we are trying to find.
     * @return Index of TeamMember if found, NOT_FOUND otherwise.
     */
   private int find(TeamMember m) {
       for (int i = 0; i < numMembers; ++i) {
           if (m.equals(team[i])) {
              return i;
          }
       }
       return NOT_FOUND;
   }

    /**
     * Increases the size of our underlying array container based on GROW_SIZE.
     */
   private void grow() {
       TeamMember[] tmp = new TeamMember[team.length + GROW_SIZE];
       for (int i = 0; i < team.length; ++i) {
          tmp[i] = team[i];
       }
       team = tmp;
   }

    /**
     * Checks whether the Team instance is currently empty or not.
     * @return True if the Team instance is empty.
     */
   public boolean isEmpty() {
       return numMembers == 0;
   }

    /**
     * Adds target TeamMember object to the current Team instance.
     * @param m Target TeamMember we are adding.
     */
   public void add(TeamMember m) {
      if (numMembers == team.length) grow();
      team[numMembers] = m;
      ++numMembers;
   }

    /**
     * Removes target TeamMember object from the current Team instance.
     * @param m Target TeamMember we are removing.
     * @return Whether the object was successfully removed or not.
     */
   public boolean remove(TeamMember m) {
       if (!contains(m) || isEmpty()) return false;
       int idx = find(m);
       if (idx != -1) {
           // get idx of last TeamMember in Team
           int lastIDX = numMembers - 1;
           // switch last TeamMember and target TeamMember
           TeamMember tmp = team[idx];
           team[idx] = team[lastIDX];
           team[lastIDX] = tmp;
           // set last TeamMember (target) to null and return
           team[lastIDX] = null;
           --numMembers;
           return true;
       }
       return false;
   }

    /**
     * Checks whether current Team instance contains target TeamMember
     * @param m Target TeamMember object we are checking against.
     * @return Whether the Team instance contains the target TeamMember or not.
     */
   public boolean contains(TeamMember m) {
      for (TeamMember tm : team) {
         if (m.equals(tm)) return true;
      }
      return false;
   }

    /**
     * Prints TeamMembers currently in the Team instance.
     */
   public void print() {
       if (isEmpty()) return;
       for (int i = 0; i < numMembers; ++i) {
           System.out.println(team[i]);
       }
   }
}
