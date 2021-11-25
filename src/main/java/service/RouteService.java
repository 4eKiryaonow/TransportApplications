package service;

import dao.RouteDAO;
import dao.RouteImpl;
import domain.Route;

import java.util.ArrayList;
import java.util.List;


public class RouteService {

    private RouteDAO route;

    public RouteService() {

        route = new RouteImpl();

    }

    public void getALLRoutes() {

        List<Route> routes = new ArrayList<>();

        try {

            routes = route.getALL();

        } catch (Exception e) {

            e.printStackTrace();

            System.out.println("Данные не получены");
        }

        if (routes.isEmpty()) {

            System.out.println("Маршруты не найдены");

        } else {

            for (int i = 0; i < routes.size(); i++) {

                System.out.println(routes.get(i).toString());
            }
        }

    }

}
