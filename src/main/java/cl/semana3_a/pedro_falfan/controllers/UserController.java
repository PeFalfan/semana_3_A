package cl.semana3_a.pedro_falfan.controllers;

import cl.semana3_a.pedro_falfan.models.HomeDelivery;
import cl.semana3_a.pedro_falfan.models.ResponseModel;
import cl.semana3_a.pedro_falfan.models.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    List<UserModel> users = new ArrayList<>();

    public UserController() {
        List<HomeDelivery> homeDelivery1 = new ArrayList<>(3);
        homeDelivery1.add(new HomeDelivery("Artes y Oficios #331", "POR AQUÍ", "METROPOLITANA"));

        UserModel user1 = new UserModel("99.999.999-9", 25, "MANAGER", homeDelivery1, "987654321");

        List<HomeDelivery> homeDelivery2 = new ArrayList<>(3);
        homeDelivery2.add(new HomeDelivery("Artes y Oficios #331", "POR AHI", "LOS RIOS"));
        homeDelivery2.add(new HomeDelivery("Artes y Oficios #332", "POR AHI", "LOS RIOS"));
        homeDelivery2.add(new HomeDelivery("Artes y Oficios #333", "POR AHI", "LOS RIOS"));
        homeDelivery2.add(new HomeDelivery("Artes y Oficios #334", "POR AHI", "LOS RIOS"));

        UserModel user2 = new UserModel("88.888.888-8", 27, "CLIENT", homeDelivery2, "987654321");

        List<HomeDelivery> homeDelivery3 = new ArrayList<>(3);
        homeDelivery3.add(new HomeDelivery("Artes y Oficios #331", "POR ALLÁ", "TARAPACÁ"));

        UserModel user3 = new UserModel("77.777.777-7", 29, "SELLER", homeDelivery3, "987654321");

        users.add(user1);
        users.add(user2);
        users.add(user3);

    }

    @GetMapping(value = "/getClients")
    public @ResponseBody ResponseModel getAllClients() {
        ResponseModel response = new ResponseModel();
        response.setMessageResponse("Datos Cargados correctamente");
        response.setData(users);
        response.setError("");

        System.out.println("Servicio getAllClients responde correctamente!");

        return response;
    }

    @GetMapping(value = "/getUserRol{rut}")
    public @ResponseBody ResponseModel getUserRol(@RequestParam(value = "rut") String clientRut) {
        ResponseModel response = new ResponseModel();

        String userRol = "";

        response.setData(null);
        response.setError("No se encontró rut de usuario");
        response.setMessageResponse("Rut ingresado no se encuentra en BD");

        for (UserModel element: users) {
            if (element.getClientRut().equalsIgnoreCase(clientRut)) {
                userRol = element.getRol();
                response.setMessageResponse("Datos Cargados correctamente");
                response.setData(userRol);
                response.setError(null);
            }
        }

        System.out.println("Servicio getUserRol responde correctamente!");

        return response;
    }

    @GetMapping(value = "/getUserHomeDeliveries{rut}")
    public @ResponseBody ResponseModel getUserHomeDeliveries(@RequestParam(value = "rut") String clientRut) {
        ResponseModel response = new ResponseModel();
        response.setData(null);
        response.setError("No se encontró rut de usuario");
        response.setMessageResponse("Rut ingresado no se encuentra en BD");

        for (UserModel element: users) {
            if (element.getClientRut().equalsIgnoreCase(clientRut)) {

                response.setMessageResponse("Datos Cargados correctamente");
                response.setData(element.getHomeDelivery());
                response.setError(null);
            }
        }

        System.out.println("Servicio getUserHomeDeliveries responde correctamente!");

        return response;
    }

}
