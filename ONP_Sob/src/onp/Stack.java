package onp;

public class Stack {

	String[] tab;
	int count;
	
	public Stack(int maxsize){
		tab=new String[maxsize];
		count=0;
	}
	
	int getSizeofStack(){
		return tab.length;
	}
	
	public int getSize(){
		return count;
	}
	
	public void push(String word)  throws ArrayIndexOutOfBoundsException{
		if(count<tab.length){
			tab[count]=word;
			count++;
		}
		else throw new ArrayIndexOutOfBoundsException("Stos zostal przepelniony!");
		
	}
	
	public String pop() throws IndexOutOfBoundsException {
		if(count<=0) throw new IndexOutOfBoundsException("Stos jest pusty!");
		else {
			String word=tab[count-1];
			count--;
			return word;
		}
	}
	
	public String top()  throws IndexOutOfBoundsException{
		if(count<=0) throw new IndexOutOfBoundsException("Stos jest pusty!");
		else return tab[count-1];
	}
	
	
	
	public void showstack()  throws IndexOutOfBoundsException{
		if(count==0) throw new IndexOutOfBoundsException();
		else {
			int index=count-1;
			System.out.print("Stos: ");
			for(int i=index;i>=0;i--){
				System.out.print(tab[i]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	public boolean isEmpty() {
		if(count==0) return true;
		else return false;
	}
	

	
	
	
}
