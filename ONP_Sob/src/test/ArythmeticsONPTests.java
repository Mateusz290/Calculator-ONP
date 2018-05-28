package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import onp.ONP;
import onp.Stack;

public class ArythmeticsONPTests {

private Stack stos=null;
	

	
	
	@BeforeClass
	public static void prepare() {
		
	}
	
	@AfterClass
	public static void afterclass(){
		
	}
	
	@Before 
	public void before(){
	}
	
	@After
	public void after(){
		ONP.one=0;
		ONP.second=0;
	}
	
	@Test
	public void test1(){
		ONP.onp("7+5");
		
		Assert.assertEquals(12, ONP.one);
		
	}
	
	@Test
	public void test2(){
		ONP.onp("7*5");
		
		Assert.assertEquals(35, ONP.one);
		
	}
	
	@Test
	public void test3(){
		ONP.onp("9/3");
		
		Assert.assertEquals(3, ONP.one);
		
	}
	
	@Test
	public void test4(){
		ONP.onp("(9+1)*2");
		
		Assert.assertEquals(20, ONP.one);
		
	}
}
