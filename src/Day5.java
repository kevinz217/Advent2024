import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day5Input.txt");
        ArrayList<String> rules = new ArrayList<>();
        ArrayList<String> pageListss = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++) {
            if (fileData.get(i).contains("|")){
                //gets all the page rules
                rules.add(fileData.get(i));
            }
            if (fileData.get(i).contains(",")) {
                //gets all the pages 2nd half
                pageListss.add(fileData.get(i));
            }
        }

        System.out.println("Part one answer : " + partOne(rules,pageListss));
        System.out.println("Part two answer : " + partTwo(rules,pageListss));
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

    public static int partOne(ArrayList<String> rules, ArrayList<String> pageLists) {
        int ans = 0;

        for (int pages = 0; pages < pageLists.size(); pages++) {
            //gets a singular line of pages
            ArrayList<String> thePages = new ArrayList<>(Arrays.asList(pageLists.get(pages).split(",")));
            if (checkRules(thePages,rules)) {
                int middleIdx = thePages.size()/2;
                ans += Integer.parseInt(thePages.get(middleIdx));
            }
        }

        return ans;
    }

    public static int partTwo(ArrayList<String> rules, ArrayList<String> pageLists) {
        int ans = 0;

        return ans;
    }

    public static boolean checkRules(ArrayList<String> thePages, ArrayList<String> rules) {
        for (int i = 0; i < rules.size(); i++) {
            String num1 = rules.get(i).substring(0,2);
            String num2 = rules.get(i).substring(3);
            if (thePages.contains(num1) && thePages.contains(num2)) {
                if (thePages.indexOf(num1) > thePages.indexOf(num2)) {
                    return false;
                }
            }
        }
        return true;
    }
}