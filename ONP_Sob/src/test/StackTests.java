package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import onp.Stack;

public class StackTests {

private static Stack stos=null;
	
	static int i=0;
	
	String word="word";
	
	@BeforeClass
	public static void preparation(){
		stos=new Stack(10);
	}
	
	@AfterClass
	public static void cleanity(){
		stos=null;
	}
	
	@Before
	public void prepare(){
		//stos=new Stack(10);
		
	}
	
	@After
	public void clean(){
		//stos=null;
		System.out.println("po tescie");
	}
	
	@Test
	public void test0(){ // sprawdzanie czy metoda isEmpty stosu zwróci true
		System.out.println("0 Test");	
		Assert.assertTrue(stos.isEmpty());
	}
	
	@Test(expected=IndexOutOfBoundsException.class) // sprawdzanie czy metoda top() stosu wyrzuci wyjątek
	public void test1(){
		System.out.println("1 Test");	
		stos.top();
	}
	
	@Test(expected=IndexOutOfBoundsException.class) // sprawdzanie czy metoda pop() wyrzuci wyjatek
	public void test2(){
		System.out.println("2 Test");	
		stos.pop();
	}
	
	@Test
	public void test3(){ //dodanie wartości "String" na stos i sprawdzanie wartosci na szczycie stosu
		System.out.println("3 Test");	
		
		stos.push(word);
		
		String word=stos.top();
		
		Assert.assertEquals(word, stos.top());
		Assert.assertEquals(word, stos.top());
		Assert.assertEquals(word, stos.top());
		Assert.assertEquals(word, stos.top());
		
		Assert.assertFalse(stos.isEmpty());
		
	}
	
	@Test
	public void test4(){ //zjecie wartosci ze szczytu stosu i sprawdzanie czy stos jest pusty
		System.out.println("4 Test");
		
		Assert.assertSame(word, stos.pop());
		
		Assert.assertTrue(stos.isEmpty());
		
	}
	
	@Test(expected=IndexOutOfBoundsException.class) // sprawdzanei czy wywolanie pop() wyrzuci wyjątek
	public void test5(){
		System.out.println("5 Test");	
		stos.pop();
	}
	
	@Test
	public void test6(){ // "dodanie kilku wartosci na stos i sprawdzenie zawartosci stosu z dodanymi wcześniej wartościami
		System.out.println("6 Test");	
		
		String []words={"word","word1","word2","word3","word4"};
		for(int i=0;i<words.length;i++) stos.push(words[i]);
		
		for(int i=stos.getSize()-1;i>=0;i--){
			Assert.assertEquals(words[i], stos.pop());
		}
		
	}
	
	@Test
	public void test7(){ // dodanie wartości null na stos
		System.out.println("7 Test");	
		
		stos.push(null);
		
		Assert.assertEquals(null, stos.pop());
		
	}
	
}
