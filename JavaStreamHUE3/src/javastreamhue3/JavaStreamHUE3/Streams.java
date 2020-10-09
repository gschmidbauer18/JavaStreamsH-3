package javastreamhue3.JavaStreamHUE3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public double average(int[] numbers) {
        return Arrays.stream(numbers).average().getAsDouble();
    }

    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings)
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        if (!weapons.isEmpty()) {
            return weapons.stream().min(Comparator.comparing(Weapon::getDamage)).get();
        } else {
            return null;
        }
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        if (!weapons.isEmpty()) {
            return weapons.stream().max(Comparator.comparing(Weapon::getMinStrength)).get();
        } else {
            return null;
        }
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream().filter(w -> w.getDamageType().equals(DamageType.MISSILE)).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        if (!weapons.isEmpty()) {
            return weapons.stream().sorted((w1, w2) -> Integer.compare(w2.getName().length(), w1.getName().length())).findFirst().get();
        } else {
            return null;
        }
    }

    public List<String> toNameList(List<Weapon> weapons) {
        return weapons.stream().map(w -> w.getName()).collect(Collectors.toList());

    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        return weapons.stream().mapToInt(w -> w.getSpeed()).toArray();
    }

    public int sumUpValues(List<Weapon> weapons) {
        return weapons.stream().mapToInt(w -> w.getValue()).reduce(0, (w1, w2) -> w1 + w2);
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        return weapons.stream().mapToInt(w -> w.hashCode()).reduce(0, (w1, w2) -> w1 + w2);
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return weapons.stream().distinct().collect(Collectors.toList());
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        weapons.stream().forEach(w -> w.setValue((int) Math.round(w.getValue() * 1.1)));
    }
}
