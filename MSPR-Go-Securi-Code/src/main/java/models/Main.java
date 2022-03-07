package models;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class Main{
    public static void main(String[] args) {
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