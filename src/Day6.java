import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");

        System.out.println("Part one answer : " + partOne(fileData));
        System.out.println("Part two answer : " + partTwo(fileData));
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

    public static int partOne(ArrayList<String> fileData) {
        int ans = 0;
        return ans;
    }

    public static int partTwo(ArrayList<String> fileData) {
        int ans = 0;

        return ans;
    }

}