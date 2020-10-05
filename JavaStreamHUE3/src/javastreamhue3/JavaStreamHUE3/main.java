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

/**
 *
 * @author 43676
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
                br.readLine();
            }
        } catch (IOException e) {
        }
    
        weapons.forEach(System.out::println);
    }

}
