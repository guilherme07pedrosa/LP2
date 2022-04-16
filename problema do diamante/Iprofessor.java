
/**
 * professor
 */

public interface Iprofessor
{
    // Default method
    default void show()
    {
        System.out.println("Professor");
    }
}