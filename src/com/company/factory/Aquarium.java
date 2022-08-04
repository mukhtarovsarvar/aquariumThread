package com.company.factory;

import com.company.dto.FishDTO;
import com.company.enums.Gender;
import com.company.util.RandomFish;

import java.util.*;

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
        }
        System.out.println("-----------Fish-----------");
        System.out.println("Male   -> " + m);
        System.out.println("FeMale -> " + f);
        System.out.println("Total  -> " + fishList.size());
        System.out.println("--------------------------");
    }


    public synchronized void remove(FishDTO fishDTO) {
        fishList.remove(fishDTO);
    }


    public synchronized void checkForCollision(FishDTO fishDTO){

        if(fishList.size() >= FishFactory.size){
            System.err.println("no love");
            return;
        }


        for (FishDTO dto : Objects.requireNonNull(fishList)) {
            if(dto.getX() == fishDTO.getX() && dto.getY() == fishDTO.getY()){
                if(!dto.getGender().equals(fishDTO.getGender())){
                    FishDTO generate = FishFactory.generate(this);
                    fishList.add(generate);
                    generate.start();
                    System.out.println(generate);
                    fishDTO.setTimeOut(RandomFish.getRandom(10));
                    System.out.println("---------------Collision----------------");
                    System.out.println(fishDTO + " " + Thread.currentThread().getName());
                    System.out.println(dto + " " + Thread.currentThread().getName());
                    System.out.println(generate + " BABY ");
                    System.out.println("-----------------------------------------");

                    return;
                }
            }
        }
    }

}
