
package com.vue;
import static org.junit.Assert.assertEquals;

import com.metier.*;
import com.persistance.*;

import java.util.ArrayList;
import java.sql.*;
public class ProgPrin {
	
	
	

	public static void main(String[] args) {
		TypeCharge t=new TypeCharge("tres rapide",100);
		AccesData.addTypeCharge(t);
	}

}
