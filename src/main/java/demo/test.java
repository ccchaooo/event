package demo;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dengchao
 * @date 2019/8/27 0027 20:26
 */
public class test {
    public static void main(String[] args) {
        Dice dice = new Dice();
//        for (int i=0;i<100;i++){
//            System.out.println(dice.roll());
//        }
        System.out.println(dice.rollAndEqual(1));
        System.out.println(dice.rollAndBiggerThan(3));
        System.out.println(dice.rollAndLitterThan(3));
        //System.out.println(dice.rollAndMatchSpecifiedSequence(Stream.of(6,9,4,5).collect(Collectors.toList())));
        System.out.println(dice.rollAndMatchSpecifiedSequence(Stream.of(6,5,4,5).collect(Collectors.toList())));
    }
}
