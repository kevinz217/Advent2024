import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        int total = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String[] line = (fileData.get(i)).split("   ");
            list1.add(Integer.parseInt(line[0]));
            list2.add(Integer.parseInt(line[1]));
        }
        Collections.sort(list1);
        Collections.sort(list2);
        for (int i = 0; i < 1000; i++) {
            total += Math.abs(list1.get(i) - list2.get(i));
        }
        System.out.println(total);
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
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}