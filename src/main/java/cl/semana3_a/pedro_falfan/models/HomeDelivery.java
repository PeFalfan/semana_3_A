package cl.semana3_a.pedro_falfan.models;

public class HomeDelivery {
    private String address;
    private String commune;
    private String region;

    public HomeDelivery(String address, String commune, String region) {
        this.address = address;
        this.commune = commune;
        this.region = region;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


}
