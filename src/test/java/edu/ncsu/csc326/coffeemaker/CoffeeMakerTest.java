/*
 * Copyright (c) 2009,  Sarah Heckman, Laurie Williams, Dright Ho
*/ 
 
package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;




/**
 * 
 */
/**
 * Unit tests for CoffeeMaker class.
 * 
 * @author Sarah Heckman
 */
public class CoffeeMakerTest {
	
	/**
	 * The object under test.
	 */
	private CoffeeMaker coffeeMaker;
	
	private RecipeBook recipeBookStub;

	private Recipe [] stubRecipies; 

	/**
	 * The coffee maker -- our object under test.
	 */
	//private CoffeeMaker coffeeMaker;
	
	// Sample recipes to use in testing.
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;
	private Recipe recipe5;
	private Recipe recipe6;

	/**
	 * Initializes some recipes to test with and the {@link CoffeeMaker} 
	 * object we wish to test.
	 * 
	 * @throws RecipeException  if there was an error parsing the ingredient 
	 * 		amount when setting up the recipe.
	 */
	@Before
	public void setUp() throws RecipeException {
		coffeeMaker = new CoffeeMaker();
		
		//Set up for r1
		recipe1 = new Recipe();
		recipe1.setName("Coffee");
		recipe1.setAmtChocolate("0");
		recipe1.setAmtCoffee("3");
		recipe1.setAmtMilk("1");
		recipe1.setAmtSugar("1");
		recipe1.setPrice("50");
		
		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Mocha");
		recipe2.setAmtChocolate("20");
		recipe2.setAmtCoffee("3");
		recipe2.setAmtMilk("1");
		recipe2.setAmtSugar("1");
		recipe2.setPrice("75");
		
		//Set up for r3
		recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for r4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");		
		
	}
	
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with well-formed quantities
	 * Then we do not get an exception trying to read the inventory quantities.
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test
	public void testAddInventory() throws InventoryException {
		coffeeMaker.addInventory("4","7","0","9");
	}
	
	@Test
	public void testAddInventory_1() throws InventoryException {
		coffeeMaker.addInventory("3","1","1","0");
	}
	
	@Test
	public void testAddInventory_2() throws InventoryException {
		coffeeMaker.addInventory("0","7","6","9");
	}
	
	@Test
	public void testAddInventory_3() throws InventoryException {
		coffeeMaker.addInventory("4","0","6","9");
	}
	
	@Test
	public void testAddInventory_4() throws InventoryException {
		coffeeMaker.addInventory("4","7","6","0");
	}
	
	
	//more than 15 values
	
	@Test
	public void testAddInventory_fail_1() throws InventoryException {
		coffeeMaker.addInventory("20","7","0","9");
	}
	
	@Test
	public void testAddInventory_fail_2() throws InventoryException {
		coffeeMaker.addInventory("4","20","0","9");
	}
	
	@Test
	public void testAddInventory_fail_3() throws InventoryException {
		coffeeMaker.addInventory("4","7","20","9");
	}
	
	@Test
	public void testAddInventory_fail_4() throws InventoryException {
		coffeeMaker.addInventory("4","7","0","20");
	}
	
	
	//all inputs 0  
	
	@Test
	public void testAddInventory_fail_0() throws InventoryException {
		coffeeMaker.addInventory("0","0","0","0");
	}
	
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantities (i.e., a negative 
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException() throws InventoryException {
		coffeeMaker.addInventory("4", "-1", "asdf", "3");
	}
	
	// letters
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_letter1() throws InventoryException {
		coffeeMaker.addInventory("a", "5", "8", "10");
	}
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_letter2() throws InventoryException {
		coffeeMaker.addInventory("8", "s", "8", "10");
	}
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_letter3() throws InventoryException {
		coffeeMaker.addInventory("7", "5", "j", "10");
	}
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_letter4() throws InventoryException {
		coffeeMaker.addInventory("2", "5", "8", "c");
	}
	
	//negative values
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_negative_1() throws InventoryException {
		coffeeMaker.addInventory("-2", "5", "8", "10");
	}
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_negative_2() throws InventoryException {
		coffeeMaker.addInventory("2", "-5", "8", "10");
	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryException_negative_3() throws InventoryException {
		coffeeMaker.addInventory("2", "5", "-8", "10");
	}
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_negative_3_1() throws InventoryException {
		coffeeMaker.addInventory("2", "5", "-3", "10");
	}
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_negative_4() throws InventoryException {
		coffeeMaker.addInventory("2", "5", "8", "-10");
	}
	
	//more letters
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_letters_1() throws InventoryException {
		coffeeMaker.addInventory("asd", "5", "8", "10");
	}
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_letters_2() throws InventoryException {
		coffeeMaker.addInventory("2", "jdg", "8", "10");
	}
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_letters_3() throws InventoryException {
		coffeeMaker.addInventory("6", "5", "kiy", "10");
	}
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_letters_4() throws InventoryException {
		coffeeMaker.addInventory("8", "5", "8", "xuy");
	}
	
	
	
	//decimal numbers
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_decimal_1() throws InventoryException {
		coffeeMaker.addInventory("8.5", "5", "8", "2");
	}
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_decimal_2() throws InventoryException {
		coffeeMaker.addInventory("8", "5.5", "8", "2");
	}

	@Test(expected = InventoryException.class)
	public void testAddInventoryException_decimal_3() throws InventoryException {
		coffeeMaker.addInventory("8", "5", "7.5", "2");
	}
	
	@Test(expected = InventoryException.class)
	public void testAddInventoryException_decimal_4() throws InventoryException {
		coffeeMaker.addInventory("8", "5", "8", "2.9");
	}
	
	
	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying more than 
	 * 		the coffee costs
	 * Then we get the correct change back.
	 */
	@Test
	public void testMakeCoffee() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals(25, coffeeMaker.makeCoffee(0, 75));
	}
	
	//change 
	
	@Test
	public void testMakeCoffee_change_1() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals(50, coffeeMaker.makeCoffee(0, 100));
	}
	

	@Test
	public void testMakeCoffee_change_4() {
		coffeeMaker.addRecipe(recipe3);
		assertEquals(100, coffeeMaker.makeCoffee(0, 200));
	}
	
	@Test
	public void testMakeCoffee_change_5() {
		coffeeMaker.addRecipe(recipe3);
		assertEquals(50, coffeeMaker.makeCoffee(0, 150));
	}
	
	@Test
	public void testMakeCoffee_change_6() {
		coffeeMaker.addRecipe(recipe4);
		assertEquals(10, coffeeMaker.makeCoffee(0, 75));
	}
	
	@Test
	public void testMakeCoffee_change_7() {
		coffeeMaker.addRecipe(recipe4);
		assertEquals(35, coffeeMaker.makeCoffee(0, 100));
	}
	
	
	//paid amount is same the cost
	
	@Test
	public void testMakeCoffee_same_1() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals(0, coffeeMaker.makeCoffee(0, 50));
	}
	
	@Test
	public void testMakeCoffee_same_3() {
		coffeeMaker.addRecipe(recipe3);
		assertEquals(0, coffeeMaker.makeCoffee(0, 100));
	}
	
	@Test
	public void testMakeCoffee_same_4() {
		coffeeMaker.addRecipe(recipe4);
		assertEquals(0, coffeeMaker.makeCoffee(0, 65));
	}
	
	//paid amount is less than the cost 
	
	@Test
	public void testMakeCoffee_less_1() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals(10, coffeeMaker.makeCoffee(0, 10));
	}
	
	@Test
	public void testMakeCoffee_less_2() {
		coffeeMaker.addRecipe(recipe2);
		assertEquals(10, coffeeMaker.makeCoffee(0, 10));
	}
	
	@Test
	public void testMakeCoffee_less_3() {
		coffeeMaker.addRecipe(recipe3);
		assertEquals(10, coffeeMaker.makeCoffee(0, 10));
	}
	
	@Test
	public void testMakeCoffee_less_4() {
		coffeeMaker.addRecipe(recipe4);
		assertEquals(10, coffeeMaker.makeCoffee(0, 10));
	}
	
	
	//more than 3 recepies
	
	@Test
	public void testMakeCoffee_more_9() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals(100, coffeeMaker.makeCoffee(3, 100));
	}
	
	@Test
	public void testMakeCoffee_more_10() {
		coffeeMaker.addRecipe(recipe2);
		assertEquals(100, coffeeMaker.makeCoffee(3, 100));
	}
	
	@Test
	public void testMakeCoffee_more_11() {
		coffeeMaker.addRecipe(recipe3);
		assertEquals(100, coffeeMaker.makeCoffee(3, 100));
	}
	
	@Test
	public void testMakeCoffee_more_12() {
		coffeeMaker.addRecipe(recipe4);
		assertEquals(100, coffeeMaker.makeCoffee(3, 100));
	}
	
	//add recipe
	
	@Test
	public void testaddrecipe_1(){
		assertTrue(coffeeMaker.addRecipe(recipe1));
	
	}
	
	
	@Test
	public void testaddrecipe_2(){
		assertTrue(coffeeMaker.addRecipe(recipe2));
	
	}
	
	@Test
	public void testaddrecipe_3(){
		assertTrue(coffeeMaker.addRecipe(recipe3));
	
	}
	
	@Test
	public void testaddrecipe_4(){
		assertTrue(coffeeMaker.addRecipe(recipe4));
	
	}
	
	
	
	 // addRecipe method in CoffeeMaker class

	@Test
	public void testAddRecipe1()
	{
		assertEquals(true,coffeeMaker.addRecipe(recipe1));
		assertEquals(true,coffeeMaker.addRecipe(recipe2));
		assertEquals(true,coffeeMaker.addRecipe(recipe3));
		assertEquals(false,coffeeMaker.addRecipe(recipe4));
	}
		
	
	//make coffee
	
	@Test
	public void testMakeCoffee1() {
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		coffeeMaker.addRecipe(recipe3);
		coffeeMaker.addRecipe(recipe4);
		assertEquals(75, coffeeMaker.makeCoffee(4, 75));
	}
		
	@Test
	public void testMakeCoffee2() {
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		coffeeMaker.addRecipe(recipe3);
		assertEquals(25, coffeeMaker.makeCoffee(0, 75));
	}	
		
	//delete recipe
	
	@Test
	public void testDeleteRecipe4(){   
		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		coffeeMaker.addRecipe(recipe3);
		coffeeMaker.addRecipe(recipe4);
		assertEquals("Coffee",coffeeMaker.deleteRecipe(0));
		assertEquals("Mocha",coffeeMaker.deleteRecipe(1));
		assertEquals("Latte",coffeeMaker.deleteRecipe(2));
		assertEquals(null,coffeeMaker.deleteRecipe(3));
	}
		
		
		
}
