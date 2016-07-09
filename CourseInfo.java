import java.util.ArrayList;
import java.text.DecimalFormat;

/** This class represents a model of a course.
  * 
  * @author Nathalie Rose Lim-Cheng
  * @version 1.0
  */
public class CourseInfo
{
   
   public CourseInfo(String code, String title,
                     double units, int term,
					 String schoolyear)
   {
	   setCode("OBJECTP");
       setCode(code);
	   setTitle(title);
	   setUnits(units);
	   setTerm(term);
	   setAY(schoolyear);
   }
   
   public CourseInfo(String code, String title,
                     int term,
					 String schoolyear)
   {   this(code, title, 3.0, term, schoolyear);
   }
 
   public CourseInfo(String code, String title,
                     String schoolyear)
   {   this(code, title, 3.0, 1, schoolyear);
   }
 
   public void setUnits(double units)
   {
	   if (units == 0.5 || units == 1.0 ||
	       units == 2.0 || units == 3.0 ||
		   units == 4.0)
   	     this.units = units;
	   else this.units = 3.0;
	   
	   /* Alternative solution:
	   if (isValidUnits(units))
		   this.units = units;
	   else this.units = 3.0;
	   */
   }
   
   public void setTerm(int term)
   {
	   if (term >= 1 && term <= 3)
		   this.term = term;
	   else {
		   System.out.println("Invalid term " + term);
		   System.out.println("Assuming default of Term 1");
		   this.term = 1;
	   }
   }
   
   public void setAY(String schoolYear)
   {
	   ay = schoolYear;
   }
   
   /** This method updates the course code only if the
     * parameter is exactly 7 characters.
	 *
	 * @param code the new course code
	 */
   public void setCode(String code)
   {
       if (code.length() == 7)
	      courseCode = code;
	   else System.out.println("Invalid course code");	  
   }
   
   public void setTitle(String t)
   {
	   title = t;
   }
   
   public double getUnits()
   {
	   return units;
   }
   
   public String getTitle()
   {
	   return title;
   }

   public String getAY()
   {
	   return ay;
   }

   public int getTerm()
   {
	   return term;
   }
   
   public String getCode()
   {
	   return courseCode;
   }

   /** This method returns the String equivalent of
     * the state of the course object.   
	 *
	 * @return the String equivalent of the contents of
	 *         of the course object
	 */
   public String toString()
   {
	   DecimalFormat df = new DecimalFormat("0.0");
	   return term + " " + ay + " " + courseCode + " " + title +
	          " " + df.format(getUnits());
   }
   
    /** This method will only be used within the object to 
     * determine if the parameter units is a valid value.
	 *
	 * @param units the value to check for validity
	 * @return boolean result signifying that units is one
	 *         of the possible acceptable values: 0.5, 1.0,
	 *         2.0, 3.0, or 4.0
	 */
   private boolean isValidUnits(double units)
   {
	   return (units == 0.5 || units == 1.0 ||
	           units == 2.0 || units == 3.0 ||
		       units == 4.0);
   }
				 
   private String courseCode;
   private String title;
   private double units;
   private int term;
   private String ay;
   
   protected void finalize()
   {
	   System.out.println("Destroying " + toString());
   }
  
}