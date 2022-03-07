package models;

import org.apache.commons.codec.binary.Base64;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/**
 * This class represent an agent by his name and his items.
 */
public class Agent{
    private String lastName;
    private String firstName;
    private String role;
    private final String agentPicturePath;
    private String login;
    private String hash;
    private List<String> itemList;

    /**
     * Constructor of the class to implement a new Agent object.
     *
     * @param lastName  Last name of the agent.
     * @param firstName First name of the agent.
     * @param role      Role of the agent.
     * @param password  Password of the agent.
     * @param itemList  List of the item hold by the agent.
     */
    public Agent(String lastName, String firstName, String role, String password, List<String> itemList) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.role = role;
        this.login = firstName.toLowerCase().charAt(0) + lastName.toLowerCase();
        this.agentPicturePath = "/Users/Olivier/Documents/GitHub/Diamond_Aloha/MSPR-Go-Securi/" + this.login.replace(" ","") + ".jpg";
        this.hash = this.passwordToSha1(password);
        this.itemList = itemList;
    }

    /**
     * This method will hash a password and return it into a String with the SHA-1 algorithm.
     * @param password Plain text of the password.
     * @return A String which is the hashed password with SHA-1.
     */
    private String passwordToSha1(String password){
        MessageDigest messageDigest = null;
        try {
            //Getting the instance of the SHA-1 algorithm.
            messageDigest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //Converting into bytes the password encoded in UTF-8.
        byte[] bytes = password.getBytes(StandardCharsets.UTF_8);
        assert messageDigest != null;
        //Updating the digest of the bytes.
        messageDigest.update(bytes);
        //Performing the hash computation in doing final operations.
        byte[] digest = messageDigest.digest();
        //Initializing the hash format for the htpasswd.
        String hash = "{SHA}";
        //Encoding the hash bytes into String
        hash += Base64.encodeBase64String(digest);
        //Returning the hash at the good format
        return hash;
    }

    /**
     * Getter of the last name of the agent.
     *
     * @return The last name of the agent on a String.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the agent.
     *
     * @param lastName Take in parameter a String which represent the last name of the agent.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter of the first name of the agent.
     *
     * @return The first name of the agent on a String.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the agent.
     *
     * @param firstName Take in parameter a String which represent the first name of the agent.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter of the role of the agent.
     *
     * @return The role of the agent on a String.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the agent.
     *
     * @param role Take in parameter a String which represent the role of the agent.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Getter of the login of the agent.
     *
     * @return The login of the agent on a String.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login of the agent.
     *
     * @param login Take in parameter a String which represent the login of the agent.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Getter of the password of the agent.
     *
     * @return The password of the agent on a String.
     */
    public String getHash() {
        return hash;
    }

    /**
     * Sets the password of the agent.
     *
     * @param hash Take in parameter a String which represent the password of the agent.
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * Getter of the item list of the agent.
     *
     * @return The item list of the agent on a list of String which represent his items.
     */
    public List<String> getItemList() {
        return itemList;
    }

    /**
     * Sets the item list of the agent.
     *
     * @param itemList Take in parameter a List of String which represent the item list of the agent.
     */
    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }

    /**
     * This method add an item to the agent.
     *
     * @param item Take in parameter a String which represent the item to add in the item list of the agent.
     */
    public void addItemToAgent(String item){
        this.itemList.add(item);
    }


    /**
     * This method which show all the items of an agent in stdout.
     *
     */
    public void printItemOfTheAgent(){
        for (String s : this.itemList){
            System.out.print(s +" ");
        }
    }

    /**
     * This method return an agent to an understandable language.
     *
     * @return Return the agent to an understandable language on a String.
     */
    public String toString(){
        return "Agent : "+ this.lastName + " "+ this.firstName+ "with login : "+ this.login+ " is "+this.role;
    }

    /**
     * This method generate a html file of the agent with all of his equipment.
     *
     * @param equipmentList Take in parameter the original equipment list contained in list.txt
     *
     */
    public void generateAgentFile(Map<String, String> equipmentList){
        String templateFile="";
        try {
                templateFile = Files.readString(Paths.get("src/main/java/models/template_agent_file.html"));
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            File agentFile = new File("./"+this.login + ".html");
            Path path = Path.of(this.login+".html");

            agentFile.createNewFile();
            templateFile = templateFile.replace("$agentName", this.firstName + " "+ this.lastName)
                    .replace("$agentLogin", this.login);
            try {
                //Write all the items of the agent.
                StringBuilder items = new StringBuilder();
                if (!this.itemList.isEmpty()) {
                    for (String listItem : this.itemList) {
                        items.append("<li>").append(equipmentList.get(listItem)).append("<input type=\"checkbox\" class=\"chk\"></li>");
                    }
                    templateFile = templateFile.replace("$agentItems", items.toString()).replace("$agentPicture", this.agentPicturePath);
                    Files.writeString(path,templateFile);
                    System.out.println(this.login+".html has been created successfully !");
                } else {
                    Files.writeString(path,"<p>Aucun équipement n'a été attribué à l'agent !</p>");
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            //End wrinting all the items of the agent.

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
