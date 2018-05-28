package onp;

public class Console {
	
	 public static void printPrompt(String prompt) {  System.out.print(prompt + " ");
     System.out.flush();
  }
	 
	 public static String readString(){  
	   	  int ch;
	      String r = "";
	      boolean done = false;
	      while (!done)
	      {  try
	         {  ch = System.in.read();
	            if (ch < 0 || (char)ch == '\n')
	               done = true;
	            else if ((char)ch != '\r') 
	               r = r + (char) ch;
	         }
	         catch(java.io.IOException e)
	         {  done = true;
	         }
	      }
	      return r;
	   }
	 
	  public static String readString(String prompt){  
	      printPrompt(prompt);
	      return readString();
	   }
	  
	  public static String readWord()
	   {  int ch;
	      String r = "";
	      boolean done = false;
	      while (!done)
	      {  try
	         {  ch = System.in.read();
	            if (ch < 0 
	               || java.lang.Character.isWhitespace((char)ch))
	               done = true;
	            else
	               r = r + (char) ch;
	         }
	         catch(java.io.IOException e)
	         {  done = true;
	         }
	      }
	      return r;
	   }
	  
	  public static int readInt(String prompt)
	   {  while(true)
	      {  printPrompt(prompt);
	         try
	         {  return Integer.valueOf
	               (readString().trim()).intValue();
	         } catch(NumberFormatException e)
	         {  System.out.println
	               ("Forkert valg, Pr?v igen!");
	         }
	      }
	   }
	  
	  public static double readDouble(String prompt)
	   {  while(true)
	      {  printPrompt(prompt);
	         try
	         {  return Double.valueOf
	               (readString().trim()).doubleValue();
	         } catch(NumberFormatException e)
	         {  System.out.println
	         ("Not a floating point number. Please try again!");
	         }
	      }
	   }

}
