package org.example.csc325_gp;

import java.util.ArrayList;

public class User {
    int userID;

    String name;

    String email;

    String password;

    String profilePicture;

    ArrayList<MediaItem> currentlyRentedItems;

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setCurrentlyRentedItems(ArrayList<MediaItem> currentlyRentedItems) {
        this.currentlyRentedItems = currentlyRentedItems;
    }

    public int getUserID(){
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public ArrayList<MediaItem> getCurrentlyRentedItems() {
        return currentlyRentedItems;
    }
}
