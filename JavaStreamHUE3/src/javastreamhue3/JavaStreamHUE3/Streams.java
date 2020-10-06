package javastreamhue3.JavaStreamHUE3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public double average(int[] numbers) {
        double[] darray=Arrays.stream(numbers).mapToDouble(Number::doubleValue);
        return Arrays.stream(darray).average().getAsDouble();
    }
    
    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings)
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
    }
    
    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        //implement this
    }
    
    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        //implement this
    }
    
    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        //implement this
    }
    
    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        //implement this
    }
    
    public List<String> toNameList(List<Weapon> weapons) {
        //implement this
    }
    
    public int[] toSpeedArray(List<Weapon> weapons) {
        //implement this
    }
    
    public int sumUpValues(List<Weapon> weapons) {
        //implement this
    }
    
    public long sumUpHashCodes(List<Weapon> weapons) {
        //implement this
    }
    
    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        //implement this
    }
    
    public void increaseValuesByTenPercent(List<Weapon> weapons) {
       //implement this
    }
}
