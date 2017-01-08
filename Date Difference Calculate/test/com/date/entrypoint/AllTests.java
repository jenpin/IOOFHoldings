package com.date.entrypoint;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.date.utils.CalendarUtilTest;
import com.date.utils.InputValidator;
import com.date.utils.InputValidatorTest;

@RunWith(Suite.class)
@SuiteClasses({ DateDifferenceCalculateTest.class
	,InputValidatorTest.class
	,CalendarUtilTest.class })
public class AllTests {

}

