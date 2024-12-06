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
            for (int j = 0; j < inputArray.length; j++) {
                String character = inputArray[i][j];
                if (character.equals("X")) {

                }
            }
        }
        return ans;
    }

    public static int partTwo(String[][] inputArray) {
        int ans = 0;

        return ans;
    }

    public static boolean checkFowards(int a, int b) {
        if
    }

}