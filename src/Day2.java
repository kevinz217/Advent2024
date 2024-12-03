import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");

        System.out.println("Part one answer : " + partOne(fileData));
        //System.out.println("Part two answer : " + partTwo());
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
        for (int i = 0; i < fileData.size(); i++) {
            String[] report = (fileData.get(i)).split(" ");
            boolean safe = true;
            boolean increasing = false;

            if (Integer.parseInt((report[0])) < Integer.parseInt(report[1])) {
                increasing = true;
            }

            for (int idx = 1; idx < report.length- 1; idx++) {
                int abs = Math.abs(Integer.parseInt((report[idx])) - Integer.parseInt((report[idx + 1])));
                if (abs > 3 || abs < 1 ) {
                    System.out.println("This is not safe since it has a large difference: " + Arrays.toString(report));
                    safe = false;
                    break;
                }
                if (increasing) {
                    if (Integer.parseInt((report[idx])) > Integer.parseInt(report[idx + 1])) {
                        System.out.println("This is not safe since it is not consistent: " + Arrays.toString(report));
                        safe = false;
                        break;
                    }
                } else {
                    if (Integer.parseInt((report[idx])) < Integer.parseInt(report[idx + 1])) {
                        System.out.println("This is not safe it is not consistent: " + Arrays.toString(report));
                        safe = false;
                        break;
                    }
                }
            }
            if (safe) {
                ans++;
            }
        }
        return ans;
    }

}