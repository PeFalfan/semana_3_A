package cl.semana3_a.pedro_falfan.models;

import java.util.List;

public class UserModel {
    private String clientRut;
    private int age;
    private String rol;
    private List<HomeDelivery> homeDelivery;
    private String password;

    public UserModel(String clientRut, int age, String rol, List<HomeDelivery> homeDelivery, String password) {
        this.clientRut = clientRut;
        this.age = age;
        this.rol = rol;
        this.homeDelivery = homeDelivery;
        this.password = password;
    }
    public String getClientRut() {
        return clientRut;
    }

    public void setClientRut(String clientRut) {
        this.clientRut = clientRut;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<HomeDelivery> getHomeDelivery() {
        return homeDelivery;
    }

    public void setHomeDelivery(List<HomeDelivery> homeDelivery) {
        this.homeDelivery = homeDelivery;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
