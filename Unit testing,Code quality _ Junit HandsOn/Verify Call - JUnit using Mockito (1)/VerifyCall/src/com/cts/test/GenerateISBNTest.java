package com.cts.test;

import org.junit.After;
import org.junit.Before;
import org.junit.rules.ExpectedException;

import com.cts.utility.Book;
import com.cts.utility.GenerateISBN;

import org.mockito.runners.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;


import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
//Provide necessary Annotation to class, attributes and test methods
@RunWith(MockitoJUnitRunner.class)
public class GenerateISBNTest {
	    @Mock
        Book book;
	    @InjectMocks
        GenerateISBN service;
        @Rule
        public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
    @Test
	public void testSuccess() {
	    	//fill code
	    	service.assignISBN("ISBN0000");
		    Mockito.verify(book).setIsbn("ISBN0000");

	}
	@Test
	public void testFailed() {
	    	//fill code
	    	try{
	    	    service.assignISBN("101");
	    	}
	    	catch(RuntimeException e) {
	    	    Mockito.verify(book, Mockito.times(0)).setIsbn("101");
	    	}
	    	
		    
	}
    @Test
	public void testException() {
	    	//fill code
	    	try {
    			service.assignISBN("101");
    			//fail("Invalid amount");
    		}catch (RuntimeException e) {
    		    
    			assertEquals("Invalid Code", e.getMessage());
    		}

	}
}
