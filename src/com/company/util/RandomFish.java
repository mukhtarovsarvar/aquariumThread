package com.company.util;

import com.company.dto.FishDTO;
import com.company.enums.Gender;
import com.company.factory.FishFactory;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomFish {

    private static Random random = ThreadLocalRandom.current();

    public static FishDTO randomFish() {

        FishDTO dto = new FishDTO();

        if (random.nextBoolean()) {
            dto.setGender(Gender.M);
        } else {
            dto.setGender(Gender.F);
        }

        dto.setLive(random.nextInt(0, FishFactory.liveTime));
        dto.setX(random.nextInt(0, FishFactory.x));
        dto.setY(random.nextInt(0, FishFactory.y));

        return dto;
    }


    public static Gender getRandomGender() {
        if (random.nextBoolean()) {
            return Gender.M;
        } else {
            return Gender.F;
        }
    }

    public static int getRandom(int n) {
        return random.nextInt(n);
    }


    public static int getRandom(int m,int n) {
        return random.nextInt(m,n);
    }

}
