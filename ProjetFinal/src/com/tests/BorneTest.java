package com.tests;

import com.metier.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class BorneTest {
private Borne b,b2;
private TypeCharge t1,t2;
@Before
public void setUp() throws Exception {
t1=new TypeCharge(1, "normale", 3);
t2=new TypeCharge(2, "semi-rapide",24);
b=new Borne(2, "25/09/2014", t1,1);
b2=new Borne("14/09/2013",t1,1);
}
@After
public void tearDown() throws Exception {
b=null;
b2=null;
t1=null;
t2=null;
}
@Test
public void testBorne() {
assertNotNull(b);
assertNotNull(b2);
}
@Test
public void testGetDateMiseEnService() {
assertEquals("25/09/2014", b.getDateMiseEnService());
assertEquals("14/09/2013",b2.getDateMiseEnService());
}
@Test
public void testSetDateMiseEnService() {
b.setDateMiseEnService("26/09/2014");
assertEquals("26/09/2014", b.getDateMiseEnService());
b2.setDateMiseEnService("01/01/0401");
assertEquals("01/01/0401",b2.getDateMiseEnService());
}
@Test
public void testGetEtat() {
assertEquals("ES", b.getEtat());
assertEquals("ES", b2.getEtat());
}
@Test
public void testSetEtat() {
b.setEtat("HS");
b2.setEtat("HS");
assertEquals("HS", b.getEtat());
assertEquals("HS", b2.getEtat());
}
@Test
public void testGetTypeCharge() {
assertEquals(t1, b.getTypeCharge());
assertEquals(t1, b2.getTypeCharge());
}
@Test
public void testSetTypeCharge() {
b.setTypeCharge(t2);
assertEquals(t2, b.getTypeCharge());
b2.setTypeCharge(t2);
assertEquals(t2, b2.getTypeCharge());
}
@Test
public void testGetIdBorne() {
assertEquals(2, b.getIdBorne());
}
}
