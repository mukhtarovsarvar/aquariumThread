package com.company.dto;

import com.company.enums.Gender;
import com.company.factory.Aquarium;
import com.company.factory.FishFactory;
import com.company.util.RandomFish;

public class FishDTO extends Thread {

    private int x;

    private int y;

    private Gender gender;

    private int live;

    private Aquarium aquarium;

    private long timeOut;

    @Override
    public void run() {

        while (live != 0) {
            swim();
            aquarium.checkForCollision(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            live--;
            if(timeOut>0){
                timeOut--;
            }
        }

        aquarium.remove(this);
        System.out.println("DEAD FISH -> " + getName() + " " + toString());
    }


    public void swim() {

        int x = RandomFish.getRandom(4 + 1);

        switch (x) {

            case 1 -> {

                if (getY() != FishFactory.y) {
                    setY(getY() + 1);
                } else {
                    System.out.println("yuromadi -> " + toString());
                }
            }

            case 2 -> {

                if (getX() != FishFactory.x) {
                    setX(getX() + 1);
                } else {
                    System.out.println("yuromadi -> " + toString());
                }
            }

            case 3 -> {
                if (getY() != 0) {
                    setY(getY() - 1);
                } else {
                    System.out.println("yuromadi -> " + toString());
                }

            }

            case 4 -> {
                if (getX() != 0) {
                    setX(getX() - 1);
                } else {
                    System.out.println("yuromadi -> " + toString());

                }
            }
        }
    }


    public FishDTO() {
    }

    public FishDTO(Aquarium aquarium, int x, int y, Gender gender, int live) {
        this.x = x;
        this.y = y;
        this.aquarium = aquarium;
        this.gender = gender;
        this.live = live;
    }


    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "x=" + x +
                ", y=" + y +
                ", gender='" + gender + '\'' +
                ", live=" + live +
                '}';
    }
}
