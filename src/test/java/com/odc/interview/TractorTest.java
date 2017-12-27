package com.rbs.odc.interview;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

/**
 * @author Ben
 *
 */
public class TractorTest {

	@Test
	public void testShouldMoveForward(){
		Tractor tractor = new Tractor();
		tractor.move("F");
		assertEquals(0, tractor.getPositionX());
		assertEquals(1, tractor.getPositionY());
	}

	@Test
	public void testShouldTurn(){
		Tractor tractor = new Tractor();
		tractor.move("T");
		assertEquals("E", tractor.getOrientation());
		tractor.move("T");
		assertEquals("S", tractor.getOrientation());
		tractor.move("T");
		assertEquals("W", tractor.getOrientation());
		tractor.move("T");
		assertEquals("N", tractor.getOrientation());
	}

	@Test
	public void testShouldTurnAndMoveInTheRightDirection(){
		Tractor tractor = new Tractor();
		tractor.move("T");
		tractor.move("F");		
		assertEquals(1, tractor.getPositionX());
		assertEquals(0, tractor.getPositionY());
		tractor.move("T");
		tractor.move("F");		
		assertEquals(1, tractor.getPositionX());
		assertEquals(-1, tractor.getPositionY());
		tractor.move("T");
		tractor.move("F");		
		assertEquals(0, tractor.getPositionX());
		assertEquals(-1, tractor.getPositionY());
		tractor.move("T");
		tractor.move("F");		
		assertEquals(0, tractor.getPositionX());
		assertEquals(0, tractor.getPositionY());		
	}

	@Test
	public void testShouldThrowExceptionIfFallsOffPlateau(){
		Tractor tractor = new Tractor();
		tractor.move("F");
		tractor.move("F");
		tractor.move("F");
		tractor.move("F");
		tractor.move("F");
		try{
			tractor.move("F");
			fail("Tractor was expected to fall off the plateau");
		}catch(TractorInDitchException expected){
		}
	}
}
