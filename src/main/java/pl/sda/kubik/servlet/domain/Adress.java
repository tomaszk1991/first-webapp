package pl.sda.kubik.servlet.domain;

public class Adress {
    private String adress;
    private String homeNumber;
    private String buildingNumber;
    private String city;

    public Adress(final String adress, final String homeNumber, final String buildingNumber, final String city) {
        this.adress = adress;
        this.homeNumber = homeNumber;
        this.buildingNumber = buildingNumber;
        this.city = city;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(final String adress) {
        this.adress = adress;
    }

    public String getHomeNumber() {
        return this.homeNumber;
    }

    public void setHomeNumber(final String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getBuildingNumber() {
        return this.buildingNumber;
    }

    public void setBuildingNumber(final String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(final String city) {
        this.city = city;
    }
}
