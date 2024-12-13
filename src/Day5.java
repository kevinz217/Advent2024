import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day5Input.txt");
        ArrayList<String> rules = new ArrayList<>();
        ArrayList<String> pageLists = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).equals(" ")){
                //nvm this doesnt work
                break;
            }
            rules.add(fileData.get(i));
        }
        boolean start = false;
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).equals(" ")){
                start = true;
            }
            if (start) {
                pageLists.add(fileData.get(i));
            }
        }

        for (int i = 0; i < rules.size(); i++) {
            System.out.println(rules.get(i));
        }
        System.out.println();

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