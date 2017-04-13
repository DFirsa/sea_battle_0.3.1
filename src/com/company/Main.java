package com.company;

public class Main {

    public static void main(String[] args) {
        int[][][] gamers_field = new int[8][8][9];
        int[][][] computers_field = new int[8][8][9];
        for (int i = 0; i < 8; i++) {
            for (int l = 0; l < 8; l++) {
                for (int q = 0; q < 9; q++) {
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

        gamer.add_fleet();
        comp.add_fleet();

        computers_field = gamer.ret_field();
        gamers_field = comp.ret_field();

        gamer.change(gamers_field);
        comp.change(computers_field);

        int score_g = 0;
        int score_c = 0;

        while ((score_g != 8)||(score_c != 8)){
            boolean hit = true;
            while (hit == true){
                hit = gamer.shoot();
                if(hit == true){
                    score_g ++;
                    System.out.println("Вы уничтожили кораблиь противника");
                    if (score_g == 5){
                        gamer.win();
                    }
                }
            }

            if (score_g == 8){
                break;
            }

            hit =true;
            while (hit == true){
                comp.shoot();
                if(hit == true){
                    score_c ++;
                    System.out.println("Ваш кораблиь уничтожен противниеом");
                    if (score_c == 5){
                        comp.win();
                    }
                }
            }
        }
    }
}
