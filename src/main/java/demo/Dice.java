package demo;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dengchao
 * @date 2019/8/27 0027 20:20
 */
public class Dice {
    private Set<Integer> pointSet;

    public Dice() {
        this.pointSet = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toSet());
    }

    public Set<Integer> getPointSet() {
        return pointSet;
    }

    public Integer roll() {
        int rn = Math.abs(new Random().nextInt()) % (pointSet.size());
        int i = 0;
        for (Integer e : pointSet) {
            if (i == rn) {
                return e;
            }
            i++;
        }
        return null;
    }

    public float rollAndEqual(Integer num) {
        if (pointSet.contains(num)) {
            return (float) 1 / pointSet.size();
        } else {
            throw new RuntimeException("Specified value is out of Boundary");
        }
    }

    public float rollAndBiggerThan(Integer num) {
        int size = pointSet.stream().filter(e -> e > num).collect(Collectors.toSet()).size();
        return (float) 1 / size;
    }

    public float rollAndLitterThan(Integer num) {
        int size = pointSet.stream().filter(e -> e < num).collect(Collectors.toSet()).size();
        return (float) 1 / size;
    }

    public float rollAndMatchSpecifiedSequence(List<Integer> list) {
        Set<Integer> outOfBoundary = list.stream().filter(e -> e > 6 || e < 0).collect(Collectors.toSet());
        if (outOfBoundary.size() > 0) {
            throw new RuntimeException("Specified value is out of Boundary");
        }
        return (float) 1 / (pointSet.size() * list.size());
    }
}
