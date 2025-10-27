/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import countries.Country;
import countries.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author win
 */
public class ManageEastAsiaCountries extends ArrayList<Country> {

    public void addCountryInfor(Country country) throws Exception {
        ((EastAsiaCountries) country).inputInfor(this);
        this.add(country);
    }

    public Country getRecentlyEnteredInformation() throws Exception {
        if (this.isEmpty()) {
            throw new Exception();
        }
        return this.get(this.size() - 1);
    }

    public void displayListCountries(ManageEastAsiaCountries listDisplay) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name",
                "Total Area", "Terrain");
        for (int i = 0; i < listDisplay.size(); i++) {
            ((Country) listDisplay.get(i)).display();
        }
    }

    public void displayCountry(Country country) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        ((Country) country).display();
    }

    public ManageEastAsiaCountries searchCountriesByName(String name)
            throws Exception {
        ManageEastAsiaCountries listSearch = new ManageEastAsiaCountries();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCountryName().toLowerCase().
                    contains(name.toLowerCase())) {
                listSearch.add(this.get(i));
            }
        }
        if (listSearch.isEmpty()) {
            throw new Exception();
        }
        return listSearch;
    }

    public ManageEastAsiaCountries sortByNameCountry() throws Exception {
        if (this.isEmpty()) {
            throw new Exception();
        }
        ManageEastAsiaCountries listSorted = this;
        Comparator<Country> e = (Country t,
                Country t1)
                -> t.getCountryName().compareTo(t1.getCountryName());
        Collections.sort(listSorted, e);
        return listSorted;
    }
}
