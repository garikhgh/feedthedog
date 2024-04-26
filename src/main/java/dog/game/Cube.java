package dog.game;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Cube {

    private static int val = 0;
    private static int ox;
    private static int oy;
    private static int appleOx = new Random().nextInt(1, 9);
    private static int appleOy = new Random().nextInt(1, 29);
    private static int x = 5;
    private static int y = 10;


    public static void composeCube(char key) throws InterruptedException, AWTException, IOException {

        char[][] mas = new char[10][30];
        for (char[] ma : mas) {
            Arrays.fill(ma, 0, 30, '#');
        }
        ;
        int r = 0;
        for (char[] ma : mas) {
            if (r != 0 && r != 9) {
                Arrays.fill(ma, 1, 29, ' ');
            }
            r++;
        }

        ox = x;
        oy = y;
        if (key == 'w') x--;
        if (key == 's') x++;
        if (key == 'a') y--;
        if (key == 'd') y++;
        if (mas[x][y] == '#') {
            x = ox;
            y = oy;
        }
        if (x == appleOx && y == appleOy) {
            mas[appleOx][appleOy] = ' ';
            val++;
            appleOx = new Random().nextInt(1, 9);
            appleOy = new Random().nextInt(1, 29);
        }

        mas[x][y] = '@';
        mas[appleOx][appleOy] = '$';
        drawCube(mas, val);
        clearScreen();
    }

    public static void drawCube(char[][] mas, int value) {

        System.out.println("### Feed the dog...");
        for (char[] row : mas) {
            System.out.println(row);
        }
        System.out.println("Collected=" + value);
    }

    private static void clearScreen() throws InterruptedException {
        Thread.sleep(100);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
