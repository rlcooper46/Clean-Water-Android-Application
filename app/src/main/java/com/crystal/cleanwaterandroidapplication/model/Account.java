package com.crystal.cleanwaterandroidapplication.model;

/**
 * The Account object stores everything a basic account needs to know about itself.
 * This includes its username, password, accountID, and basic bio information. For now,
 * username and password are stored locally on the Account object, in a basic String format.
 * @author Team 62
 * @see Permission
 * @see AccountManager
 */
public class Account implements Permissible, Bannable {
    private String username;
    private String password;
    private String firstName, middleName, lastName;
    private String email;
    private int accountID;
    private Permission accountPermission;
    private Boolean banned;

    private Account() {
        firstName = "";
        middleName = "";
        lastName = "";
        email = "";
        accountID = 0;
    }


    /*@
      @   public normal_behavior
      @     requires username != null && password != null;
      @
      @*/
    /**
     * Creates an account, given a username, password, and permission status.
     * @param username username of account
     * @param password password of account
     * @param accountPermission permission that the account has.
     */
    public Account(String username, String password, Permission accountPermission) {
        this();
        this.username = username;
        this.password = password;
        this.accountPermission = accountPermission;
    }


    /*@
      @   public normal_behavior
      @     ensures \result !=null;
      @*/
    /**
     * Gets the account's username.
     * @return The account's username.
     */
    public String getUsername() {
        return this.username;
    }

    /*@
      @   public normal_behavior
      @     ensures \result !=null;
      @*/
    /**
     * Gets the account's password.
     * @return The account's password.
     */
    public String getPassword() {
        return this.password;
    }

    /*@
      @   public normal_behavior
      @     ensures \result !=null;
      @*/
    /**
     * Gets the account holders full name. Returns in for the format:
     * 'FirstName' 'MiddleName' 'LastName'. If the name field is empty, replaces
     * with "N/A", unless it is the middle name, in which it replaces it with nothing
     * @return The full name of the account holder
     */
    public String getFullName() {
        if (firstName == null || middleName == null || lastName == null) {
            return "NULL NAME";
        }

        String firstNameReturn = firstName;
        String middleNameReturn = middleName;
        String lastNameReturn = lastName;
        if (firstName.equals("")) {
            firstNameReturn = "N/A";
        }
        if (lastName.equals("")) {
            lastNameReturn = "N/A";
        }

        if (middleName.equals("")) {
            return firstNameReturn + " " + lastNameReturn;
        } else {
            return firstNameReturn + " " + middleNameReturn + " " + lastNameReturn;
        }
    }

    /*@
      @   public normal_behavior
      @     ensures \result !=null;
      @*/
    /**
     * Gets the account holders first name.
     * @return The first name of the account holder.
     */
    public String getFirstName() {
        return firstName;
    }

    /*@
      @   public normal_behavior
      @     ensures \result !=null;
      @*/
    /**
     * Gets the account holders middle name.
     * @return The middle name of the account holder.
     */
    public String getMiddleName() {
        return middleName;
    }

    /*@
      @   public normal_behavior
      @     ensures \result !=null;
      @*/
    /**
     * Gets the account holders last name.
     * @return The last name of the account holder.
     */
    public String getLastName() {
        return lastName;
    }

    /*@
      @   public normal_behavior
      @     ensures \result !=null;
      @*/
    /**
     * Gets the account's email.
     * @return The account's email.
     */
    public String getEmail() {
        return email;
    }

    /*@
      @   public normal_behavior
      @     ensures \result !=null;
      @*/
    /**
     * Gets the account's ID.
     * @return The account's ID.
     */
    public int getAccountID() {
        return accountID;
    }

    /**
     * Sets the accounts username.
     * @param username The username to change the account's username too.
     */
    public void setUsername(String username) {
        if(username == null) {
            username = "";
        }
        this.username = username;
    }

    /**
     * Sets the account's password.
     * @param password The password to change the account's password too.
     */
    public void setPassword(String password) {
        if(password == null) {
            password = "";
        }
        this.password = password;
    }

    /**
     * Sets the account's first name.
     * @param name Name to set first name too.
     */
    public void setFirstName(String name) {
        if (name == null) {
            this.firstName = "";
        } else {
            this.firstName = name;
        }
    }

    /**
     * Sets the account's middle name.
     * @param name Name to set middle name too.
     */
    public void setMiddleName(String name) {
        if (name == null) {
            this.middleName = "";
        } else {
            this.middleName = name;
        }
    }

    /**
     * Sets the account's last name.
     * @param name Name to set last name too.
     */
    public void setLastName(String name) {
        if (name == null) {
            this.lastName = "";
        } else {
            this.lastName = name;
        }
    }

    /**
     * Sets the account's email.
     * @param email Email to set the account's email too.
     */
    public void setEmail(String email) {
        if (email == null) {
            this.email = "";
        } else {
            this.email = email;
        }
    }

    /**
     * Sets the account's ID.
     * @param accountID ID to set the account too.
     */
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public boolean hasPermission(Permission permission) {
        return accountPermission.compareTo(permission) >= 0;
    }

    @Override
    public void updatePermission(Permission permission) {
        accountPermission = permission;
    }

    @Override
    public boolean ban() {
        banned = true;
        return true;
    }

    @Override
    public boolean unBan() {
        banned = false;
        return true;
    }

    @Override
    public boolean isBanned() {
        return banned;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (!(o instanceof Account)) {
            //Not an Account type object
            return false;
        }
        return username.equals(((Account) o).getUsername());
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public String toString() {
        String s = "Account -- ";
        s += "Username: " + getUsername() + " ";
        s += "Name: " + getFullName() + " ";
        s += "Account ID: " + getAccountID() + " ";
        s += "Permission: " + accountPermission + " ";
        return s;
    }
}