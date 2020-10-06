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
        
        weapons.sort((Weapon o1, Weapon o2) -> o1.getName().compareTo(o2.getName()));        
        
        Printable pa=(Weapon weapon) -> {
            System.out.println(weapon.getName() + ", CombatType: " + weapon.getCombatType().toString() + ", damageType: " + weapon.getDamageType().toString() + ", damage: " + weapon.getDamage() + ", speed: " + weapon.getSpeed() + ", minStrength: " + weapon.getMinStrength() + ", value: " + weapon.getValue());
        };
        
        Printable pa2= (Weapon weapon) -> {
            int länge;
            String längeString="";
            
            tabellenStrich();
            
            int leer=16-weapon.getName().length();
            for(int i=0;i<=leer;i++)
            {
                längeString=längeString+" ";
            }
            System.out.print("|"+weapon.getName()+längeString+"|");
            längeString="";
            
            leer=16-weapon.getCombatType().toString().length();
            for(int i=0;i<=leer;i++)
            {
                längeString=längeString+" ";
            }
            System.out.print(weapon.getCombatType().toString()+längeString+"|");
            längeString="";
            
            leer=16-weapon.getDamageType().toString().length();
            for(int i=0;i<=leer;i++)
            {
                längeString=längeString+" ";
            }
            System.out.print(weapon.getDamageType()+längeString+"|");
            längeString="";
            
            String damage=Integer.toString(weapon.getDamage());
            leer=16-damage.length();
            for(int i=0;i<=leer;i++)
            {
                längeString=längeString+" ";
            }
            System.out.print(weapon.getDamage()+längeString+"|");
            längeString="";
            
            String speed=Integer.toString(weapon.getSpeed());
            leer=16-speed.length();
            for(int i=0;i<=leer;i++)
            {
                längeString=längeString+" ";
            }
            System.out.print(weapon.getSpeed()+längeString+"|");
            längeString="";
            
            String strength=Integer.toString(weapon.getMinStrength());
            leer=16-strength.length();
            for(int i=0;i<=leer;i++)
            {
                längeString=längeString+" ";
            }
            System.out.print(weapon.getMinStrength()+längeString+"|");
            längeString="";
            
            String value=Integer.toString(weapon.getValue());
            leer=16-value.length();
            for(int i=0;i<=leer;i++)
            {
                längeString=längeString+" ";
            }
            System.out.print(weapon.getValue()+längeString+"|");
            längeString="";
            
            System.out.println("");
        };
        
        weapons.forEach((weapon)->pa2.print(weapon));
    }
    
    private static void tabellenStrich()
    {
        for(int i=0;i<=6;i++)
            
                {
                    
                    System.out.print("+-----------------");
                }
        System.out.println("+");
                //System.out.println("+-----------------+");
    }

}
