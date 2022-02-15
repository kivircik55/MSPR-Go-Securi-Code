package models;
import java.util.ArrayList;
import java.util.Collections;
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
        List<String> list = new ArrayList<>();
        Collections.addAll(list, fileString);
            return list;
    }

    /**
     * print the staff list for testing
     * @throws IOException
     */

    public void printStaffList() throws IOException {
        List<String> list = parseStaffFromFile();
            for (String print:list) {
                System.out.println(print);
            }
    }
}