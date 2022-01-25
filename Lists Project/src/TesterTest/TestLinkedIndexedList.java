package TesterTest;

import static org.junit.Assert.*;
import Lists.LinkedIndexedList;

import org.junit.Test;

public class TestLinkedIndexedList
{

	@Test
	public void testConstruction()
	{
		LinkedIndexedList<String> lils = new LinkedIndexedList<>();
		assertNotNull("Expected construction to succeed", lils);
		assertTrue("Expected empty list to be empty", lils.isEmpty());
		assertEquals("Expected an empty list to be size zero", 0, lils.size());
	}

	@Test
	public void TestAdd()
	{
		LinkedIndexedList<String> lils = new LinkedIndexedList<>();

		lils.add("M");
		assertEquals("Expected 1 item list to be size 1", 1, lils.size());
		assertEquals("Expected list to have inserted item", "[ M ]", lils.toString());

		lils.add("P");
		assertEquals("Expected 2 item list to be size 2", 2, lils.size());
		assertEquals("Expected list to have inserted item", "[ M, P ]", lils.toString());
	}

	@Test
	public void TestAddIndex()
	{
		LinkedIndexedList<String> lils = new LinkedIndexedList<>();

		lils.add(0, "M");
		assertEquals("Expected 1 item list to be size 1", 1, lils.size());
		assertEquals("Expected list to have inserted item", "[ M ]", lils.toString());

		lils.add(1, "P");
		assertEquals("Expected 2 item list to be size 2", 2, lils.size());
		assertEquals("Expected list to have inserted item", "[ M, P ]", lils.toString());

		lils.add(0, "L");
		assertEquals("Expected 3 item list to be size 3", 3, lils.size());
		assertEquals("Expected list to have inserted item", "[ L, M, P ]", lils.toString());

		lils.add(2, "N");
		assertEquals("Expected 4 item list to be size 4", 4, lils.size());
		assertEquals("Expected list to have inserted item", "[ L, M, N, P ]", lils.toString());

		boolean expectedExceptionCaught = false;

		try
		{
			lils.add(100, "Z");
			fail("Expected to fail adding at an index greater than list size");
		} catch (IndexOutOfBoundsException exc)
		{
			expectedExceptionCaught = true;
		} catch (Exception exc)
		{

		}
		assertTrue("Expected an IndexOutOfBounds Exception to be thrown", expectedExceptionCaught);

		try
		{
			lils.add(-1, "Z");
			fail("Expected to fail adding at an index less than 0");
		} catch (IndexOutOfBoundsException exc)
		{
			expectedExceptionCaught = true;
		} catch (Exception exc)
		{

		}
		assertTrue("Expected an IndexOutOfBounds Exception to be thrown", expectedExceptionCaught);
	}

	@Test
	public void testRemove()
	{
		LinkedIndexedList<String> lils = new LinkedIndexedList<>();
		
		boolean expectedExceptionCaught = false;

		try
		{
			lils.remove(0);
			fail("Expected to fail removing from an empty list");
		} 
		catch (IndexOutOfBoundsException exc)
		{
			expectedExceptionCaught = true;
		} 
		catch (Exception exc)
		{
		}
		
		try
		{
			lils.remove(100);
			fail("Expected to fail removing with an index greater than list size");
		} 
		catch (IndexOutOfBoundsException exc)
		{
			expectedExceptionCaught = true;
		} 
		catch (Exception exc)
		{
		}
		assertTrue("Expected an IndexOutOfBounds Exception to be thrown", expectedExceptionCaught);

		try
		{
			lils.remove(-1);
			fail("Expected to fail adding at an index less than 0");
		} 
		catch (IndexOutOfBoundsException exc)
		{
			expectedExceptionCaught = true;
		} 
		catch (Exception exc)
		{
		}
		assertTrue("Expected an IndexOutOfBounds Exception to be thrown", expectedExceptionCaught);
		
		String p = lils.remove(1);
		assertEquals("expected removing P to give us back a P", "p", p);
		
	}

}
