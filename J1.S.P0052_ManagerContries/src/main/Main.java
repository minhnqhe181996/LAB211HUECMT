/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import countries.Country;
import countries.EastAsiaCountries;
import java.util.ArrayList;
import management.ManageEastAsiaCountries;
import validate.Validator;

/**
 *
 * @author win
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        int choice;
        do {
            System.out.println("                               MENU\n"
                    + "========================================================"
                    + "==================\n"
                    + "1. Input the information of 11 countries "
                    + "in East Asia\n"
                    + "2. Display the information of country you"
                    + "'ve just input\n"
                    + "3. Search the information of country by "
                    + "user-entered name\n"
                    + "4. Display the information of countries sorted name in "
                    + "ascending order  \n"
                    + "5. Exit \n"
                    + "======================================================="
                    + "===================");
            choice = Validator.getInt("Enter your choice: ", "Enter (1-5)",
                    "Invalid!", 1, 5);
            switch (choice) {
                case 1:
                    Country country = new EastAsiaCountries();
                    try {
                        manager.addCountryInfor(country);
                    } catch (Exception ex) {
                        System.out.println("Country code is exited!!!");
                    }
                    break;
                case 2:
                    try {
                        Country countryJustInput
                                = manager.getRecentlyEnteredInformation();
                        manager.displayCountry(countryJustInput);
                    } catch (Exception ex) {
                        System.out.println("List is empty!Please enter...");
                    }
                    break;
                case 3:
                    String name = Validator.getString("Enter the name you want"
                            + " to search:","Invalid!", "^(?!\\s*$).+");
                    try {
                        ManageEastAsiaCountries result = manager.
                                searchCountriesByName(name);
                        manager.displayListCountries(result);
                    } catch (Exception e) {
                        System.out.println("Not found name!!!");
                    }
                    break;
                case 4:
                    try {
                        manager.displayListCountries(
                                manager.sortByNameCountry());
                    } catch (Exception ex) {
                        System.out.println("List is empty!"
                                + "Please enter before sort");
                    }
                    break;
                case 5:
                    return;
            }
        } while (true);
    }
}
