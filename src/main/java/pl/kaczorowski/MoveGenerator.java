package pl.kaczorowski;

import java.util.Random;

public class MoveGenerator {

    Random mvGenerator = new Random();

    public Integer moveGenerator() {
        return mvGenerator.nextInt(3) + 1;
    }

}
