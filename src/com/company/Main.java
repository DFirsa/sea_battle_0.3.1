package com.company;

public class Main {

    public static void main(String[] args) {
        int[][][] gamers_field = new int[10][10][10];
        int[][][] computers_field = new int[10][10][10];
        for (int i = 0; i < 10; i++) {
            for (int l = 0; l < 10; l++) {
                for (int q = 0; q < 10; q++) {
                    if ((i == 0) || (l == 0) || (q == 0)) {
                        gamers_field[i][l][q] = 13;
                        computers_field[i][l][q] = 13;
                    } else {
                        gamers_field[i][l][q] = 0;
                        computers_field[i][l][q] = 0;
                    }
                }
            }
        }

        Gamer gamer = new Gamer(gamers_field);
        Computer comp = new Computer(computers_field);

        


    }
}
