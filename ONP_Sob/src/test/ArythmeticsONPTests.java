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

	@After
	public void after(){
		ONP.one=0;
		ONP.second=0;
	}
	
	@Test
	public void ONPada(){ // dodawanie
		ONP.onp("1+5");
		
		Assert.assertEquals(6, ONP.second);
		
	}
	
	@Test
	public void ONPdiv(){ // odejmowanie
		ONP.onp("9-1");
		
		Assert.assertEquals(8, ONP.second);
		
	}
	
	@Test
	public void ONPmlti(){ // mnożenie
		ONP.onp("9*3");
		
		Assert.assertEquals(27, ONP.second);
		
	}
	
	@Test
	public void ONPcom(){ // dzielenie
		ONP.onp("9/3");
		
		Assert.assertEquals(3, ONP.one);
		
	}
}
