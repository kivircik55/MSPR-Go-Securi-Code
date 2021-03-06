package com.example.mspr_go_securi_code_android;

import java.io.Serializable;
import java.util.List;

/**
 * This class represent an agent by his name and his items.
 */

public class Agent implements Serializable {
    private String lastName;
    private String firstName;
    private String role;
    private String login;
    private String password;
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
        this.login = firstName.charAt(0) + lastName;
        this.password = password;
        this.itemList = itemList;
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
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the agent.
     *
     * @param password Take in parameter a String which represent the password of the agent.
     */
    public void setPassword(String password) {
        this.password = password;
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
        return this.login;
    }
}
