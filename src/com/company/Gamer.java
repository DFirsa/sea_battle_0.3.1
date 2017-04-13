package com.company;

import java.util.Scanner;

/**
 * Created by User on 11.04.2017.
 */
public class Gamer {
    int[][][] field;

    Gamer(int[][][] wrfield) {
      this.field = wrfield;
    }

    void add_ship() {
        boolean chek = false;

        for (int n = 0; n < 8; n++) {
            while (chek == false) {

                System.out.println("Капитан, введите координаты коробля: x,y,z(от 1 до 6-7)");
                Scanner sc = new Scanner(System.in);
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();

                if ((x > 6) || (y > 6) || (z > 7) || (x < 1) || (y < 1) || (z < 1)) {
                    System.out.println("Заданной точки не существует");
                }

                if ((field[x][y][z] == 13) || (field[x][y][z] == 1)) {
                    System.out.println("Невозможно разместить корабль в этой точке");
                    chek = false;
                } else {
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

            System.out.println("Капитан, введите координаты коробля: x,y,z(от 1 до 6-7)");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            if ((x > 6) || (y > 6) || (z > 7) || (x < 1) || (y < 1) || (z < 1)) {
                System.out.println("Заданной точки не существует");

            }

            if (field[x][y][z] == 9){
               System.out.println("Капитан, вы уже стреляли в эту точку");
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
        System.out.println("Вы победили в сражении");
    }


}




