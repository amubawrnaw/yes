import java.util.*;

/** This class represents a model of a course.
  * 
  * @author Nathalie Rose Lim-Cheng
  * @version 1.0
  */
public class Section
{
 	
   public Section(CourseInfo code, String room)
   {
 	   this(code, "S11", room);
   }
   
   public Section(CourseInfo code, String block, 
                 String room)
   {
       setCourse(code);
	   setRoom(room);
	   setSection(block);

	   classlist = new ArrayList<Student>(45);
       maxClassSize = 45;
	   faculty = null;
   }
   
   public Section(CourseInfo code, String room, int classSize)
   {
 	   this(code, "S11", room, classSize);
   }
   
   public Section(CourseInfo code, String block, 
                 String room, int classSize)
   {
       setCourse(code);
	   setRoom(room);
	   setSection(block);
 
       if (classSize < 1) {
          System.out.println("Invalid class size... Reverting to default 45.");
          classSize = 45;
       }
       maxClassSize = classSize;
       classlist = new ArrayList<Student>(classSize);
       faculty = null;
   }
   
   public void setCourse(CourseInfo c)
   {
	   if (c == null) {
	      Scanner s = new Scanner(System.in);
          System.out.println("Cannot have no course info");
		  
		  /* get input for course info */
		  
 	   }

       course = c;	  
   }
   
   /** This method updates the room only if the
     * parameterhas at least 1 character.
	 *
	 * @param room the new room
	 */
   public void setRoom(String room)
   {
	   if (room.length() > 0)
		   this.room = room;
	   else System.out.println("Invalid room");
   }
   
   public void setSection(String block)
   {
	   if (block.length() > 0)
		   section = block;
	   else System.out.println("Invalid section");
   }  
   
   /** This method returns the room.
     *
	 * @return the room attribute of the course object
     */   
   public String getRoom()
   {
	   return room;
   }
   
   public String getSection()
   {
	   return section;
   }
   
   public CourseInfo getCourse()
   {
	   return course;
   }

   /** This method returns the String equivalent of
     * the state of the course object.   
	 *
	 * @return the String equivalent of the contents of
	 *         of the course object
	 */
   public String toString()
   {
	   return course.toString() + " " + section +
	          " " + getRoom();
   }
 
   public boolean addStudent(Student s)
   {
	   int i;
	   
	   if (isInClass(s.getName()) == false) 
               if (classlist.size() < maxClassSize) {
		      classlist.add(s);
		      return true;
		   }
               else {
			   System.out.println("Class is full");
			   return false;
		   }
	   else {
		   System.out.println("Student is in class already");
		   return false;
	   }	   
   }
   
   public ArrayList<Student> getClasslist()
   {
	   return classlist;
   }

   public boolean isInClass(Name name)
   {
	   int i;
	   boolean found = false;
	   if (classlist.isEmpty())
		   return false;
	   else {
		   i = 0;
		   while (i < classlist.size() &&
		          !found)
			  if (classlist.get(i).getName().toString().equalsIgnoreCase(name.toString()))
				  found = true;
			  else i++;
			  
		   return found;
	   }
   }
   
   public void assignFaculty(Teacher t)
   {
	   faculty = t;
   }
   
   public Teacher getFaculty()
   {
	   return faculty;
   }
   

				 
   private CourseInfo course;
   private String section;
   private String room;
   private ArrayList<Student> classlist;
   private Teacher faculty;
   private final int    maxClassSize;
      
   protected void finalize()
   {
	   System.out.println("Destroying " + toString());
   }
  
}