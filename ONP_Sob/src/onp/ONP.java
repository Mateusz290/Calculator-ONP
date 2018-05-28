package onp;

public class ONP {
	public static Stack stack = new Stack(20);
	
	static String result = "";
	
	public static int one=0;
	public static int second=0;
	
	public static int onp(String wyrazenie){
		String statement = wyrazenie;
		boolean sign = true; 
		
		statement = statement.replaceAll(" ","");
		
	
		for (int i=0; i<statement.length(); i++) {
			if (statement.charAt(i) == '(') {
				stack.push("(");
				sign = true;
				result += " ";
			} else if (statement.charAt(i) == ')') {
				result += " " + getFromStackUntilBracket();
				sign = false;
			} else if ((statement.charAt(i) == '+' ||
					    statement.charAt(i) == '-' ||
					    statement.charAt(i) == '*' ||
					    statement.charAt(i) == '/') && !sign) {
				result += " " + getFromStack(statement.substring(i, i+1));
				sign = true;
			} else {
				if (sign && statement.charAt(i) == '-') {
					result += " ";
				}
				result += statement.charAt(i);
				sign = false;				
			}
		}
		result += getAllFromStack();
		result = result.replaceAll("  ", " ");
		
		System.out.println("ONP:" + result);
		getresult();
		System.out.println("Wynik operacji:" + second);
		
		return one;
	}
	
	private static String getFromStackUntilBracket() {
		String result = "";
		String c = null;
		if (!stack.isEmpty()) {
			c =  stack.pop();
			while (!c.equals("(")){
				result = result + " " + c;
				if (stack.isEmpty()) break;
				c =  stack.pop();
			}
		}
		if (result.length() > 0) {
			result = " " + result;
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private static String getFromStack(String operator) {
		String result = "";
		String c = null;
		if (!stack.isEmpty()) {
			c =  stack.pop();
			while (((operator.equals("+") || operator.equals("-")) && !c.equals("(")) ||
			   	   ((operator.equals("/") || operator.equals("*")) && (c.equals("/") || c.equals("*")))){
				result += " " + c;
				if (stack.isEmpty()) break;
				c =  stack.pop();
			}
			stack.push(c);
		}
		stack.push(operator);
		
		return result;
	}
	
	private static String getAllFromStack() {
		String result = "";
		String c = null;
		while (!stack.isEmpty()){
			c = (String) stack.pop();
			result += " " + c;
		}
		
		return result;
	}
	
	public static void getresult(){
		
		char onp;
		
		for(int i=0;i<result.length();i++){
			stack.showstack();
			//onp=result.charAt(i);
			onp=result.charAt(i);
			if(onp=='=') break;
			if(onp!='+' && onp!='-' && onp!='*' && onp!='/' && onp!=' ')
			{
				System.out.println("Liczba");	
			  stack.push(String.valueOf(onp));
			  System.out.println(stack.top());	
			}
			
			else {
				if(onp==' ') continue;
				else {
				System.out.println("Znak"+onp);
				 try {
				         one=Integer.parseInt(stack.pop());
				         second=Integer.parseInt(stack.pop());
				         
				    } catch (NumberFormatException e) {
				        
				    }
				 
				 System.out.println("one "+one+" second = "+second);
				 switch(onp){
				 case '+': second+=one;
				 break;
				 case '-': second-=one;
				 break;
				 case '*': second*=one;
				 break;
				 case '/': second/=one;
				 break;
				 default: break;
				 }
				 stack.push(String.valueOf(second));
				 
				 System.out.println("Po one = "+one+" second = "+second);
				
				}
				
			}
			
			
		}
		stack.clear();
				
	}

}
