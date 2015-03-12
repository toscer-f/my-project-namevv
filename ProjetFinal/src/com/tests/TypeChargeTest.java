package com.tests;
import com.metier.TypeCharge;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TypeChargeTest {
private TypeCharge t;
private TypeCharge t2;

@Before
public void setUp() throws Exception {
t=new TypeCharge(1, "normale", 3);
t2=new TypeCharge("normale",3);
}

@After
public void tearDown() throws Exception {
t=null;
}

@Test
public void testTypeCharge() {
assertNotNull(t);
assertNotNull(t2);
}

@Test
public void testGetLibelleTypeCharge() {
assertEquals("normale", t.getLibelleTypeCharge());
assertEquals("normale",t2.getLibelleTypeCharge());
}

@Test
public void testSetLibelleTypeCharge() {
t.setLibelleTypeCharge("new normale");
assertEquals("new normale", t.getLibelleTypeCharge());
}

@Test
public void testGetPuissanceTypeCharge() {
assertEquals(3, t.getPuissanceTypeCharge());
assertEquals(3, t2.getPuissanceTypeCharge());
}

@Test
public void testSetPuissanceTypeCharge() {
t.setPuissanceTypeCharge(5);
assertEquals(5, t.getPuissanceTypeCharge());
}

@Test
public void testGetCodeTypeCharge() {
assertEquals(1, t.getCodeTypeCharge());
}

@Test
public void testToString() {
assertEquals("TypeCharge [codeTypeCharge=1, libelleTypeCharge=normale, puissanceTypeCharge=3]", t.toString());
}
}
