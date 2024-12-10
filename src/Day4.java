import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day4Input.txt");
        int rows = fileData.size();
        int columns = fileData.get(0).length();
        String[][] inputArray = new String[rows][columns];

        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(i).length(); j++) {
                inputArray[i][j] = fileData.get(i).substring(j,j+1);
            }
        }

        System.out.println("Part one answer : " + partOne(inputArray));
        System.out.println("Part two answer : " + partTwo(inputArray));
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }

    public static int partOne(String[][] inputArray) {
        int ans = 0;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                String character = inputArray[i][j];
                if (character.equals("X")) {
                    if (checkForwards(i,j, inputArray)) {ans++;}
                    if (checkBackwards(i,j, inputArray)) {ans++;}
                    if (checkUpwards(i,j, inputArray)) {ans++;}
                    if (checkDownwards(i,j, inputArray)) {ans++;}
                    if (checkTopLeft(i,j, inputArray)) {ans++;}
                    if (checkTopRight(i,j, inputArray)) {ans++;}
                    if (checkBottomLeft(i,j, inputArray)) {ans++;}
                    if (checkBottomRight(i,j, inputArray)) {ans++;}

                }
            }
        }
        return ans;
    }

    public static int partTwo(String[][] inputArray) {
        int ans = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                String character = inputArray[i][j];
                if (character.equals("M")) {
                    if (checkMas(i,j,inputArray)) {ans++;}
                }
            }
        }

        return ans;
    }

    public static boolean checkForwards(int a, int b, String[][] inputArray) {
        if (b <= inputArray[a].length - 3) {
            if (inputArray[a][b + 1].equals("M")) {
                if (inputArray[a][b + 2].equals("A")) {
                    if (inputArray[a][b + 3].equals("S")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkBackwards(int a, int b, String[][] inputArray) {
        if (b >= 2) {
            if (inputArray[a][b - 1].equals("M")) {
                if (inputArray[a][b - 2].equals("A")) {
                    if (inputArray[a][b - 3].equals("S")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkUpwards(int a, int b, String[][] inputArray) {
        if (a >= 3) {
            if (inputArray[a - 1][b].equals("M")) {
                if (inputArray[a - 2][b].equals("A")) {
                    if (inputArray[a - 3][b].equals("S")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkDownwards(int a, int b, String[][] inputArray) {
        if (a <= inputArray.length - 4) {
            if (inputArray[a + 1][b].equals("M")) {
                if (inputArray[a + 2][b].equals("A")) {
                    if (inputArray[a + 3][b].equals("S")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkTopLeft(int a, int b, String[][] inputArray) {
        if (a >= 3) {
            if (b >= 3) {
                if (inputArray[a - 1][b - 1].equals("M")) {
                    if (inputArray[a - 2][b - 2].equals("A")) {
                        if (inputArray[a - 3][b - 3].equals("S")) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkTopRight(int a, int b, String[][] inputArray) {
        if (a >= 3) {
            if (b <= inputArray[a].length - 4) {
                if (inputArray[a - 1][b + 1].equals("M")) {
                    if (inputArray[a - 2][b + 2].equals("A")) {
                        if (inputArray[a - 3][b + 3].equals("S")) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkBottomLeft(int a, int b, String[][] inputArray) {
        if (a <= inputArray.length - 4) {
            if (b >= 3) {
                if (inputArray[a + 1][b - 1].equals("M")) {
                    if (inputArray[a + 2][b - 2].equals("A")) {
                        if (inputArray[a + 3][b - 3].equals("S")) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkBottomRight(int a, int b, String[][] inputArray) {
        if (a <= inputArray.length - 4) {
            if (b <= inputArray[a].length - 4) {
                if (inputArray[a + 1][b + 1].equals("M")) {
                    if (inputArray[a + 2][b + 2].equals("A")) {
                        if (inputArray[a + 3][b + 3].equals("S")) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkMas(int a, int b, String[][] inputArray) {
        if (a <= inputArray.length - 3 && a >= 3) {
            if (b <= inputArray[a].length - 3 && b >= 3) {
                if (checkMBottomLeft(a,b,inputArray) || checkMTopLeft(a,b,inputArray) || checkTopRight(a,b,inputArray) || checkMTopLeft(a,b,inputArray)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkMBottomLeft(int a, int b, String[][] inputArray) {
        if (inputArray[a-1][b+1].equals("A")) {
            if (inputArray[a-2][b+2].equals("S")) {
                if (inputArray[a-2][b].equals("M")) {
                    if (inputArray[a][b+2].equals("S")){
                        String[][] newArray = new String[inputArray.length][inputArray[0].length];
                        newArray[a-1][b+1] = "P";
                        inputArray = newArray;
                        return true;
                    }
                } else if (inputArray[a][b+2].equals("M")) {
                    if (inputArray[a-2][b].equals("S")){
                        String[][] newArray = new String[inputArray.length][inputArray[0].length];
                        newArray[a-1][b+1] = "P";
                        inputArray = newArray;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean checkMTopLeft(int a, int b, String[][] inputArray) {
        if (inputArray[a+1][b+1].equals("A")) {
            if (inputArray[a+2][b+2].equals("S")) {
                if (inputArray[a+2][b].equals("M")) {
                    if (inputArray[a][b+2].equals("S")){
                        String[][] newArray = new String[inputArray.length][inputArray[0].length];
                        newArray[a+1][b+1] = "P";
                        inputArray = newArray;
                        return true;
                    }
                } else if (inputArray[a][b+2].equals("M")) {
                    if (inputArray[a+2][b].equals("S")){
                        String[][] newArray = new String[inputArray.length][inputArray[0].length];
                        newArray[a-1][b+1] = "P";
                        inputArray = newArray;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkMBottomRight(int a, int b, String[][] inputArray) {
        if (inputArray[a-1][b-1].equals("A")) {
            if (inputArray[a-2][b-2].equals("S")) {
                if (inputArray[a-2][b].equals("M")) {
                    if (inputArray[a][b-2].equals("S")){
                        String[][] newArray = new String[inputArray.length][inputArray[0].length];
                        newArray[a-1][b-1] = "P";
                        inputArray = newArray;
                        return true;
                    }
                } else if (inputArray[a][b-2].equals("M")) {
                    if (inputArray[a-2][b].equals("S")){
                        String[][] newArray = new String[inputArray.length][inputArray[0].length];
                        newArray[a-1][b-1] = "P";
                        inputArray = newArray;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean checkMTopRight(int a, int b, String[][] inputArray) {
        if (inputArray[a-1][b-1].equals("A")) {
            if (inputArray[a-2][b-2].equals("S")) {
                if (inputArray[a+2][b].equals("M")) {
                    if (inputArray[a][b-2].equals("S")){
                        String[][] newArray = new String[inputArray.length][inputArray[0].length];
                        newArray[a+1][b+1] = "P";
                        inputArray = newArray;
                        return true;
                    }
                } else if (inputArray[a][b-2].equals("M")) {
                    if (inputArray[a+2][b].equals("S")){
                        String[][] newArray = new String[inputArray.length][inputArray[0].length];
                        newArray[a-1][b+1] = "P";
                        inputArray = newArray;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}