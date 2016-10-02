package org.egov.bootcamp;

import static junit.framework.TestCase.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldThrowNullPointerExceptionIfInputIsNull() throws Exception {
		StackImpl<String> stack= new StackImpl<String>();
		thrown.expect(NullPointerException.class);
		stack.push(null);
		
	}
	@Test
	public void shouldReturnNullOnEmptyStack() throws Exception {
		StackImpl<String> stack= new StackImpl<String>();
		assertEquals(null, stack.pop());
		
	}
	
	@Test
	public void shouldReturnStackSizeOnInsertion() throws Exception {
		StackImpl<String> stack= new StackImpl<String>();
		assertEquals(0, stack.size());
		stack.push("A");
		assertEquals(1, stack.size());
		stack.push("B");
		stack.push("C");
		assertEquals(3, stack.size());
		
	}
	
	@Test
	public void shouldReturnStackArray() throws Exception {
		StackImpl<Object> stack= new StackImpl<Object>();
		stack.push("A");
		stack.push("B");
		assertEquals("B", stack.toArray()[0]);
		assertEquals("A", stack.toArray()[1]);
		
	}
	@Test
	public void checkStackEmpty() throws Exception {
		StackImpl<Object> stack= new StackImpl<Object>();
		assertEquals(true, stack.isEmpty());
		stack.push("A");
		stack.push("B");
		assertEquals(false, stack.isEmpty());
		
	}
	@Test
	public void shouldReturnValueIfContain() throws Exception {
		StackImpl<Object> stack= new StackImpl<Object>();
		stack.push("A");
		stack.push("B");
		assertEquals(true, stack.contains("B"));
		assertEquals(false, stack.contains("C"));
		thrown.expect(NullPointerException.class);
		 stack.contains(null);
	}
	
	@Test
	public void shouldPopTheLastInsertedElement() throws Exception {
		StackImpl<Object> stack= new StackImpl<Object>();
		stack.push("A");
		stack.push("B");
		assertEquals("B", stack.pop());
	}
}


