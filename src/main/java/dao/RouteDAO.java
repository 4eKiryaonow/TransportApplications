package dao;



import domain.Route;
import domain.TransportType;

import java.sql.SQLException;
import java.util.List;

public interface RouteDAO {



    //получить все маршруты
    List<Route> getALL() throws SQLException;

    //получить маршрут по id
    Route getByRouteId(Long id) throws SQLException;

    //получить маршрутный лист с не назначенными маршрутами
    List<Route> getRouteListWithOutTransport() throws SQLException;

    //получить маршрутный лист для определенного типа транспорта
    List<Route> getRouteListByTypeOfTransport(TransportType type) throws SQLException;




}
