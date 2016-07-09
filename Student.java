import java.util.Scanner;
import java.util.ArrayList;

/** This class represents a model of a DLSU
  * student.
  * @author Nathalie Rose Lim-Cheng
  * @version 1.0
  */
public class Student
{
   public Student(int id, Name name)
   {
	   if (!(id >= 10000000 && id <= 99999999 )) {
		   Scanner s = new Scanner(System.in);
		   do{
		     System.out.println("Invalid id"); 
			 System.out.println("Enter 8-digit ID number: ");
			 id = s.nextInt();
		   } while (!(id >= 10000000 && id <= 99999999 )) ;
       }
	   
       IDnum = id;	   
	   this.name = name;
	   enrolIn = new ArrayList<CourseInfo>();
   }
 
   /** This method returns the ID number attribute
     * @return id number of the student object
	 */
   public int getID()
   {
	   return IDnum;
   }
   
   /** This method returns the name of the student.
     * @return name of the student object
     */   
   public Name getName()
   {
	   return name;
   }

   public ArrayList<CourseInfo> getEnrolledCourses()
   {
	   return enrolIn;
   }
   
   public boolean enrol(CourseInfo course)
   {
	   if (countUnitsEnrolled() + course.getUnits() <= 18) {
	      enrolIn.add(course);
          return true;		   
	   }
	   else {
		   System.out.println("Enrolling not allowed.. will exceed 18 units");
		   return false;
	   }
   }
   
   private double countUnitsEnrolled()
   {   double total = 0;
       if (!enrolIn.isEmpty())
	     for (int i = 0; i < enrolIn.size(); i++ )
			 total += enrolIn.get(i).getUnits();
		
	   return total;
   }

   private final int      IDnum;
   private final Name     name;
   private ArrayList<CourseInfo> enrolIn;
}