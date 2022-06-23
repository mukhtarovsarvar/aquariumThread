package com.company.factory;

import com.company.dto.FishDTO;
import com.company.enums.Gender;
import com.company.util.RandomFish;

import java.util.Random;

public class FishFactory {

    public static final int liveTime = 100;
    public static final int x = 5;
    public static final int y = 5;
    public static final int initialCount = 5;

    public static FishDTO generate(Aquarium aquarium) {
        Gender g = RandomFish.getRandomGender();

        int live = RandomFish.getRandom(liveTime);



        return new FishDTO(RandomFish.getRandom(x+1),RandomFish.getRandom(y+1),g,live);
    }
}

