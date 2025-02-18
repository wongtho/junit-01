package com.example.junit_01;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringUtilTest {
	// Check default plural
	@Test
	void plural() {
		Assertions.assertEquals("words", StringUtil.pluralize("word"));
	}
	// Check plural with y
	@Test
	void pluralWithY() {
		Assertions.assertEquals("cities", StringUtil.pluralize("city"));
	}
	// Check if input contains special characters
	@Test
	void illegalArgsException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			StringUtil.pluralize("not%AWord");
		});
	}
	// Check irregular input
	@Test
	void pluralIrregular() {
		Assertions.assertEquals("people", StringUtil.pluralize("person"));
	}
	// Check uncountable input
	@Test
	void pluralUncountable() {
		Assertions.assertEquals("money", StringUtil.pluralize("money"));
	}
	// Check 
}
