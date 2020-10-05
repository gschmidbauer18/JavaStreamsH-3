/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastreamhue3.JavaStreamHUE3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 43676
 */
public class mainTest {
    
    public mainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class main.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String filename = "weapons.csv";
        ArrayList<Weapon> weapons=new ArrayList<>();
        
        try (final BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineArr=line.split(";");
                if(!lineArr[0].equals("name"))
                {
                    weapons.add(new Weapon(lineArr[0],CombatType.valueOf(lineArr[1]),DamageType.valueOf(lineArr[2]),Integer.parseInt(lineArr[3]),Integer.parseInt(lineArr[4]),Integer.parseInt(lineArr[5]),Integer.parseInt(lineArr[6])));
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
        
        weapons.sort(new Comparator<Weapon>(){
            @Override
            public int compare(Weapon o1, Weapon o2) {
                return o2.getDamage()-o1.getDamage();
            }
            
        });
        
        assertFalse(weapons.get(0).getName().toLowerCase().equals("carsomyr"));
        
    }
    
    @Test
    public void testMain2() {
        System.out.println("main");
        String filename = "weapons.csv";
        ArrayList<Weapon> weapons=new ArrayList<>();
        
        try (final BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lineArr=line.split(";");
                if(!lineArr[0].equals("name"))
                {
                    weapons.add(new Weapon(lineArr[0],CombatType.valueOf(lineArr[1]),DamageType.valueOf(lineArr[2]),Integer.parseInt(lineArr[3]),Integer.parseInt(lineArr[4]),Integer.parseInt(lineArr[5]),Integer.parseInt(lineArr[6])));
                }
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
        
        weapons.sort((Weapon o1, Weapon o2) -> o1.getName().compareTo(o2.getName()));
        
        assertFalse(weapons.get(0).getName().toLowerCase().equals("carsomyr"));
        
    }
}
