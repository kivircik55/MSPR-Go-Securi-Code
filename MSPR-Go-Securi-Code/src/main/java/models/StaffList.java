
import java.io.File;
import java.nio.file.Paths;
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
        Path fileName = Path.of("/home/thibault/Documents/MSPR-Go-Securi-Text/MSPR-Go-Securi/staff.txt" );
        String[] fileString = Files.readString(fileName).split("\\r?\\n");
        List<String> list = new ArrayList<>();
        Collections.addAll(list, fileString);
            return list;
    }

    /**
     * generat index.html
     * @param list
     */

    public static void generateAgentsList(List <String> list ) {
        String templateFile="";
        try {
            templateFile = Files.readString(Paths.get("/home/thibault/Documents/templates/template_index_file.html"));
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            File index = new File("/var/www/html/go-securi/site/index.html");
            Path path = Path.of("/var/www/html/go-securi/site/index.html");
            index.createNewFile();
            StringBuilder items = new StringBuilder();
            for (int i = 0; i<list.size() ;i++) {
                String listItem = list.get(i);
                items.append("<li><a href=\""+ listItem +".html\">"+ listItem +"</a></li>");
            }
            templateFile = templateFile.replace("$agentList", items);
            Files.writeString(path,templateFile);
            System.out.println("index.html has been created successfully !");
        } catch (IOException e) {
            e.printStackTrace();
        }
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