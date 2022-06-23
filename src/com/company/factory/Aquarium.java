package com.company.factory;

import com.company.dto.FishDTO;
import com.company.enums.Gender;

import java.util.LinkedList;
import java.util.List;

public class Aquarium {

    private List<FishDTO> fishList = new LinkedList<>();

    public void start() {

        if (fishList.isEmpty()) {
            for (int i = 0; i < FishFactory.initialCount; i++) {

                FishDTO generate = FishFactory.generate(this);
                fishList.add(generate);

                generate.start();
            }
        }

        printDetail();


    }


    private void printDetail() {

        int m = 0;
        int f = 0;

        for (FishDTO fishDTO : fishList) {

            if (fishDTO.getGender().equals(Gender.M)) {
                m++;
            } else {
                f++;
            }

            System.out.println(fishDTO);
        }
        System.out.println("Male   -> " + m);
        System.out.println("FeMale -> " + f);
        System.out.println("Total  -> " + fishList.size());
    }


    public void remove(FishDTO fishDTO) {
        fishList.remove(fishDTO);
    }


    public void checkForCollision(FishDTO fishDTO){
        
    }

}
