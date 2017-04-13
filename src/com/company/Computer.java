package com.company;

import java.util.Scanner;

/**
 * Created by User on 11.04.2017.
 */
public class Computer {
    int [][][]field ;

    Computer(int[][][]field){
        this.field = field;
    }

    int start = 0;
    int finish1 = 5;
    int finish2 = 6;

    void add_ship(){
        boolean chek = false;

        for (int n = 0; n < 8; n++){
            while (chek == false){

                int x = 1 + start + (int) (Math.random() * finish1);
                int y = 1 + start + (int) (Math.random() * finish1);
                int z = 1 + start + (int) (Math.random() * finish2);


                if ((field[x][y][z] == 13) || (field[x][y][z] == 1)) {
                    chek = false;
                }
                else {
                    chek = true;

                    field[x][y][z] = 1;

                    for (int i = 0; i < 3; i++) {
                        for (int l = 0; l < 3; l++) {
                            for (int q = 0; q < 3; q++) {
                                if (field[x][y][z] != 1) {
                                    field[x + i - 1][y + l - 1][z + q - 1] = 13;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    void add_fleet(){
        for (int i = 0; i < 5; i++){
            add_ship();
        }
    }

    int[][][] ret_field(){
        return field;
    }

    void change(int[][][] f){
        field = f;
    }

    boolean shoot(){
        boolean chek = false;
        boolean shot = false;

        while (chek == false) {

            int x = 1 + start + (int) (Math.random() * finish1);
            int y = 1 + start + (int) (Math.random() * finish1);
            int z = 1 + start + (int) (Math.random() * finish2);

            if (field[x][y][z] == 9){
            }
            else {
                chek = true;

                field[x][y][z] = 6;
                if(field[x][y][z] == 1){
                    for (int i = 0; i < 3; i++) {
                        for (int l = 0; l < 3; l++) {
                            for (int q = 0; q < 3; q++) {
                                if (field[x][y][z] != 6 ) {
                                    field[x + i - 1][y + l - 1][z + q - 1] = 9;
                                }
                            }
                        }
                    }
                    shot = true;
                }
            }
        }
        return shot;
    }

    void win(){
        System.out.println("Ваш флот разгромил соперник");
    }
}