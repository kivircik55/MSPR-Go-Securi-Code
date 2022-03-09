
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;


public class Main{
    public static void main(String[] args) {
        Path path  = Path.of("/var/www/html/.htpasswd");
        try {
            //Files.writeString(path,this.login + ":" + this.hash);
            Files.writeString(path,"");
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String,String> equipmentMap = null;
        try {
            equipmentMap = EquipmentMap.parseEquipmentFromFile();
            equipmentMap.forEach((key, value) -> System.out.println(key + ":" + value));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<String> staffList = StaffList.parseStaffFromFile();
            StaffDetail.agentDetail(staffList,equipmentMap);
            StaffList.generateAgentsList(staffList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}