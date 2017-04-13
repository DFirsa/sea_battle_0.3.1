package com.company;

import java.util.Scanner;

/**
 * Created by User on 11.04.2017.
 */
public class Gamer {
    int[][][] field;

    Gamer(int[][][] field) {
      this.field = field;
    }

    void add_ship() {
        boolean chek = false;

        for (int n = 0; n < 8; n++) {
            while (chek == false) {

                System.out.println("Капитан, введите координаты коробля: x,y,z(от 1 до 8)");
                Scanner sc = new Scanner(System.in);
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();

                if ((x > 8) || (y > 8) || (z > 8) || (x < 1) || (y < 1) || (z < 1)) {
                    System.out.println("Заданной точки не существует");
                }

                if ((field[x][y][z] == 13) || (field[x][y][z] == 1)) {
                    System.out.println("Невозможно разместить корабль в этой точке");
                    chek = false;
                } else {
                    chek = true;
                }
                for (int i = 0; i < 3; i++) {
                    for (int l = 0; l < 3; l++) {
                        for (int q = 0; q < 3; q++) {
                            field[x + i - 1][y + l - 1][z + q - 1] = 13;
                        }
                    }
                }

                field[x][y][z] = 1;

            }
        }
    }
}




