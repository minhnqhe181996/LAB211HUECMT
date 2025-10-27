/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countries;

import java.util.ArrayList;
import validate.Validator;

/**
 *
 * @author win
 */
public class EastAsiaCountries extends Country {

    private String countryTerrain;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryCode, String countryName, double totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        if (countryTerrain == null || !countryTerrain.matches("([A-Za-z]+\\s?)+")) {
            throw new IllegalArgumentException("Invalid Country Terrain. It must contain only letters and spaces.");
        }
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.1f%-25s\n", super.getCountryCode(),
                super.getCountryName(), super.totalArea, getCountryTerrain());
    }

    public void inputInfor(ArrayList<Country> list) throws Exception {
        String code = Validator.getString("Enter code of country:",
                "Invalid", "[A-Za-z0-9]+");

        for (Country country : list) {
            if (country.getCountryCode().equalsIgnoreCase(code)) {
                throw new Exception("Country code already exists.");
            }
        }

        super.setCountryCode(code);
        super.setCountryName(Validator.getString("Enter name of country:",
                "Invalid", "([A-Za-z]+\\s?)+"));
        super.setTotalArea(Validator.getDouble("Enter total Area:",
                "Error range!", "Invalid", 0, Double.MAX_VALUE));
        this.setCountryTerrain(Validator.getString("Enter terrain of country:",
                "Invalid", "([A-Za-z]+\\s?)+"));
    }
}
