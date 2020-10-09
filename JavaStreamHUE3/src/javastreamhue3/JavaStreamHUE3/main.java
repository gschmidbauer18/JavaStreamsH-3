/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastreamhue3.JavaStreamHUE3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        List<Weapon> weapons=new ArrayList<>();
        
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
        
        try {
            weapons=Files.lines(new File("weapons.csv").toPath())
                    .skip(1)
                    .map(s -> s.split(";"))
                    .map(s -> new Weapon(
                            s[0],
                            CombatType.valueOf(s[1]),
                            DamageType.valueOf(s[2]),
                            Integer.parseInt(s[3]),
                            Integer.parseInt(s[4]),
                            Integer.parseInt(s[5]),
                            Integer.parseInt(s[6])
                    ))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(" ");
        System.out.println(" ");
        weapons.forEach((weapon)->pa2.print(weapon));
    
        System.out.println(" ");
        System.out.println(" ");
        
        Random random = new Random();
        IntStream intStream = random.ints(0, 10000);
        
        int[] iarr= random.ints(100, 0, 10000).toArray();
        
        int lLimit = 97;//Buchstabe a
        int rLimit = 122; //Buchstabe z
        int länge = 10;
        
        String[] sarr=new String[10];
        for(int i=0;i<10;i++)
        {
            sarr[i]=random.ints(lLimit, rLimit+1)
                    .limit(länge)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
                    
        }
        StringBuilder s=new StringBuilder();
        //ints -> Stream von int inerhalb der begrenzungen
        //limit -> stream mit values die alle inerhalb der festgelegten länge sind
        //appendCodePoint -> wandelt String in char array um
        //append -> fügt etwas an das "appendable" an
        
        final Predicate<Integer> isEven = i -> i%2==0;
        final Predicate<Integer> isPositive = i -> i>=0;
        final Predicate<Integer> isZero = i -> i==0;
        final Predicate<Integer> isNull = i -> i==null;
        
        final Predicate<String> isShortWord = string -> string.length()<=4;
        
        final Predicate<Integer> isEvenAndPos= i -> isEven.test(i)&&isPositive.test(i);
        final Predicate<Integer> isPositivAndUneven= i -> !isEven.test(i)&&isPositive.test(i);
        
        final int result= IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(i -> !isEven.test(i))
                                                            .map(i -> i=i*i)
                                                            .reduce(0, (i1,i2) -> i1+i2);
        
        System.out.println(result);
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
