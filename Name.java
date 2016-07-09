import java.util.Scanner;

public class Name
{
   public Name(String lastname, String firstName, char mI)
   {
      setFirst(firstName);
	  setMI(mI);
	  setLast(lastname);
   }
   
   public void setFirst(String f)
   {  
      if (f == null || f.length() == 0){
	    Scanner s = new Scanner(System.in);
		do {
		  System.out.println("Cannot have no first name");
		  System.out.println("Enter first name: ");
		  f = s.nextLine();
		} while (f.length() == 0);
	  }
	  
	  first = f;
   }

   public void setLast(String l)
   {  
      if (l == null || l.length() == 0){
	    Scanner s = new Scanner(System.in);
		do {
		  System.out.println("Cannot have no last name");
		  System.out.println("Enter last name: ");
		  l = s.nextLine();
		} while (l.length() == 0);
	  }
	  
	  last = l;
   }   
   
   public void setMI(char m)
   {  
      if (Character.isAlphabetic(m) == false){
	    Scanner s = new Scanner(System.in);
	    do {
		  System.out.println("Middle initial should be a letter in the alphabet");
		  System.out.println("Enter middle initial: ");
		  m = s.nextLine().charAt(0);
		} while (!Character.isAlphabetic(m));
	  }
	  
	  midInit = m;
   }    
   
   public String getFirst()
   { 
      return first;
   }
 
   public String getLast()
   { 
      return last;
   }

   public char getMI()
   { 
      return midInit;
   }
   
   public String toString()
   {
	   return last + ", " + first + ", " + midInit + ".";
   }

   private String first;
   private String last;
   private char   midInit;
}