package countries;

public class Country {
    protected String countryCode;
    protected String countryName;
    protected double totalArea;
    
    public Country() {
    }

    public Country(String countryCode, String countryName, double totalArea) {
        setCountryCode(countryCode);
        setCountryName(countryName);
        setTotalArea(totalArea);
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        if (countryCode == null || countryCode.isEmpty() || !countryCode.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException("Invalid country code. It cannot be empty and must contain only letters and numbers.");
        }
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        if (countryName == null || countryName.isEmpty() || !countryName.matches("([A-Za-z]+\\s?)+")) {
            throw new IllegalArgumentException("Invalid country name. It cannot be empty and must contain only letters and spaces.");
        }
        this.countryName = countryName;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        if (totalArea <= 0) {
            throw new IllegalArgumentException("Invalid total area. It must be a positive number.");
        }
        this.totalArea = totalArea;
    }

    public void display() {
        System.out.printf("%-10s%-25s%-20.1f\n", getCountryCode(),
                getCountryName(), totalArea);
    }
    
    
}