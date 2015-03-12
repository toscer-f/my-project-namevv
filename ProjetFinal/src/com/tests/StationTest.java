package com.tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.metier.*;



	public class StationTest {
		private Station s1,s2,s3;
		Borne b1, b2, b3;
		private ArrayList<Borne> listeBorne1;
		private ArrayList<Borne> listeBorne2;
		private TypeCharge t1, t2;
		@Before
		public void setUp() throws Exception {
		t1=new TypeCharge(1, "normale", 3);
		t2=new TypeCharge(2, "semi-rapide",24);
		b1=new Borne(10, "25/09/2014", t1,1);
		b2=new Borne(20, "25/09/2014", t2,1);
		b3=new Borne(30, "25/09/2014", t1,1);
		listeBorne1=new ArrayList<Borne>();
		listeBorne2=new ArrayList<Borne>();
		listeBorne1.add(b1);
		listeBorne1.add(b2);
		listeBorne2.add(b3);
		s1=new Station(40, "gare MontParnasse");
		s1.setLesBornes(listeBorne1);
		s2=new Station(50, "gare du Nord");
		s3=new Station("gare du nord");
		s3.setLesBornes(listeBorne1);
		}
		@After
		public void tearDown() throws Exception {
		s1=null;
		s2=null;
		b1=null;
		b2=null;
		b3=null;
		t1= null;
		t2=null;
		listeBorne1=null;
		listeBorne2=null;
		}
		@Test
		public void testStation() {
		assertNotNull(s1);
		assertNotNull(s3);
		}
		@Test
		public void testGetLibelleEmplacement() {
		assertEquals("gare MontParnasse", s1.getLibelleEmplacement());
		assertEquals("gare du nord", s3.getLibelleEmplacement());
		}
		@Test
		public void testSetLibelleEmplacement() {
		s1.setLibelleEmplacement("gare de l'Est");
		s3.setLibelleEmplacement("gare de l'Est");
		assertEquals("gare de l'Est", s1.getLibelleEmplacement());
		assertEquals("gare de l'Est", s3.getLibelleEmplacement());
		}
		@Test
		public void testGetLesBornes() {
		assertEquals(listeBorne1, s1.getLesBornes());
		assertEquals(0, s2.getLesBornes().size());
		assertEquals(listeBorne1,s3.getLesBornes());
		}
		@Test
		public void testSetLesBornes() {
		s1.setLesBornes(listeBorne2);
		assertEquals(listeBorne2, s1.getLesBornes());
		s1.setLesBornes(null);
		assertEquals(null, s1.getLesBornes());
		s3.setLesBornes(listeBorne2);
		assertEquals(listeBorne2, s3.getLesBornes());
		s3.setLesBornes(null);
		assertEquals(null, s3.getLesBornes());
		}
		@Test
		public void testGetIdStation() {
		assertEquals(40, s1.getIdStation());
		}
	}
