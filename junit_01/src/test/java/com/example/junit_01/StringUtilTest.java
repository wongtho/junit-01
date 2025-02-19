package com.example.junit_01;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilTest {
	// Check Null input
	@Test
    void testNullInput() {
		Assertions.assertNull(StringUtil.pluralize(null));
    }
	// Check default plural
	@Test
	void testRegular() {
		Assertions.assertEquals("words", StringUtil.pluralize("word"));
		Assertions.assertEquals("apples", StringUtil.pluralize("apple"));
		// Edge case for louse -> lice
		Assertions.assertEquals("blouses", StringUtil.pluralize("blouse"));
	}
	// Check end with y
	@Test
	void testEndWithY() {
		Assertions.assertEquals("cities", StringUtil.pluralize("city"));
		// Cases: (c2 != 'a' || c2 != 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u')
			// Incorrect logic, true every case
		Assertions.assertEquals("days", StringUtil.pluralize("day"));		// Test -ay: c2 != 'e' -> 1
		Assertions.assertEquals("monkeys", StringUtil.pluralize("monkey"));	// Test -ey: c2 != 'a' -> 1
		Assertions.assertEquals("boys", StringUtil.pluralize("boy"));		// Test -oy: c2 == 'o' -> 1
		Assertions.assertEquals("guys", StringUtil.pluralize("guy"));		// Test -uy: c2 == 'u' -> 1
	}
	// Check valid input (contains special char or multiple words)
	@Test
	void testIllegalArgsException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			StringUtil.pluralize("not%AWord");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			StringUtil.pluralize("two words");
		});
	}
	// Check irregular input
	@Test
    void testIrregular() {
		Assertions.assertEquals("children", StringUtil.pluralize("child"));
		Assertions.assertEquals("people", StringUtil.pluralize("person"));
		Assertions.assertEquals("knives", StringUtil.pluralize("knife"));
    }
	// Check uncountable input
	@Test
	void testUncountable() {
		Assertions.assertEquals("money", StringUtil.pluralize("money"));
	}
	// Check end with o
	@Test
	void testEndWithO() {
		Assertions.assertEquals("heroes", StringUtil.pluralize("hero"));
		Assertions.assertEquals("tomatoes", StringUtil.pluralize("tomato"));
	}
	// Check end with x
	@Test
	void testEndWithX() {
		Assertions.assertEquals("oxen", StringUtil.pluralize("ox"));
		// Subset, end with ox
		Assertions.assertEquals("boxes", StringUtil.pluralize("box"));
		Assertions.assertEquals("foxes", StringUtil.pluralize("fox"));
	}
	// Check end with f
	@Test
	void testEndWithF() {
		Assertions.assertEquals("shelves", StringUtil.pluralize("shelf"));
		Assertions.assertEquals("roofs", StringUtil.pluralize("roof"));
	}
	// Return original word if already plural
	@Test
	void testAlreadyPlural() {
		Assertions.assertEquals("apples", StringUtil.pluralize("apples"));
	}
}
