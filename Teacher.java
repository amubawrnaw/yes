public class Teacher
{
   public Teacher(Name name, int id)
   { 
      this(name, id, null);
   }

   public Teacher(Name name, int id, String[] list)
   { 
      this.name = name;
            
      if (id >= 11600000 && id <= 99999999)
         this.id = id;
      else this.id = 11600001;

      area = list;
   }

   public Name getName()
   {   
      return name;
   }

   public int getID()
   {
      return id;
   }

   public String[] getArea()
   {
      return area;
   }
   
   public void setArea(String[] content)
   {
	   if (area != null)
		   System.out.println("Replacing old entry");
	
       area = content;
   }

   public String toString()
   {  String temp = "";
      int x;
      if (area != null)
        for (x = 0; x < area.length; x++) 
           temp = temp + area[x] + "\n";  

      return name.toString() + " (" + id + "): \n" + temp;
   }

/*   
   public boolean isInList(String key)
   {
      boolean found = false;

      if (area == null)
        return false;
      else {
         int i = 0;
         while (i < area.length && !found)
            if (area[i].equalsIgnoreCase(key))
               found = true;
            else i++;
 
         return found;
     }           
   }

   public boolean isSameArea(Teacher otherT)
   {
       if (area == null && otherT.area == null) {
           System.out.println("both are empty");
		   return true;
	   }
       else if (area == null || otherT.getArea() == null)
           return false;
       else {
         int i;
         boolean eq = true;
         for (i = 0; i < otherT.area.length; i++)
           if (isInList(otherT.area[i]) == false)
              eq = false;
         return eq;
      } 
   } 
*/

   private Name         name;
   private final int    id;
   private String[]     area; 
}