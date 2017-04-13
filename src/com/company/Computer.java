package com.company;

/**
 * Created by User on 11.04.2017.
 */
public class Computer {
    int [][][]field ;

    Computer(int[][][]field){
        this.field = field;
    }

    int start = 0;
    int finish = 7;

    void add_ship(){
        boolean chek = false;

        for (int n = 0; n < 8; n++){
            while (chek == false){

                int x = 1 + start + (int) (Math.random() * finish);
                int y = 1 + start + (int) (Math.random() * finish);
                int z = 1 + start + (int) (Math.random() * finish);


                if ((field[x][y][z] == 13) || (field[x][y][z] == 1)) {
                    chek = false;
                }
                else
                {
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