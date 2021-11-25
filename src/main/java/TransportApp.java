

import connectDB.ConnectDB;
import dao.TransportDAO;
import dao.TransportImpl;
import service.RouteService;
import service.TransportService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class TransportApp {



    public static void main(String[] args) throws SQLException {

        TransportService ts = new TransportService();
        RouteService rt = new RouteService();

        System.out.println("Получаем весь транспорт из парка");
        ts.getALL();
        System.out.println("Получаем информацию о транспорте с id = 7");
        ts.getById(7);
        System.out.println("Получаем весь транспорт в ремонте");
        ts.getInUnpair(3);
        System.out.println("Получаем все автобусы");
        ts.getTransportByType("Bus");
        System.out.println("Получаем транспорт по VIN номеру");
        ts.getByVIN("jjd");
        System.out.println("Получаем транспорт по номеру автомобиля");
        ts.getByNumber("АВ177О17");
        System.out.println("Получаем маршрутный лист");
        rt.getALLRoutes();








    }
}
