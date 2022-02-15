package models;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StaffList {

    /**
     * Parse and deals with the staff list in a more readable format
     * @return
     * @throws IOException
     */

    public static List<String> parseStaffFromFile() throws IOException {
        Path fileName = Path.of("C:/Users/Olivier/Documents/GitHub/Diamond_Aloha/MSPR-Go-Securi/staff.txt" );
        String[] fileString = Files.readString(fileName).split("\\r?\\n");
        List<String> map = new ArrayList<>();

        for (String s : fileString) {
            map.add(fileString[0]);
        }
        return map;
    }
    public void printStaffList() throws IOException {
        List<String> list = parseStaffFromFile();
        for (String print:list) {
            System.out.println(print);
        }
    }
}
