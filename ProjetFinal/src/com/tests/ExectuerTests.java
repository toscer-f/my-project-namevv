package com.tests;

import junit.framework.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;;

@RunWith(Suite.class)
@SuiteClasses(value={ TypeChargeTest.class, BorneTest.class, StationTest.class, ParcTest.class, AccesDataTest.class})
public class ExectuerTests {

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("ExecuterTests");

	}

}
