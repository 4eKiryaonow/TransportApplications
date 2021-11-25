package service;


import dao.TransportDAO;
import dao.TransportImpl;
import domain.Transport;
import domain.TransportType;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;

public class TransportService {

    private TransportDAO tr;

    public TransportService() {

        tr = new TransportImpl();

    }


    //Вывести на экран весь парк городского транспорта
    public void getALL(){

        List<Transport> list = new ArrayList<>();

        try {

            list = tr.getALL();

        } catch (Exception e) {

            System.out.println("Данные не получены");
        }

        if (list.isEmpty()) {

            System.out.println("Транспорт не найден");

        } else {

            for (int i = 0; i < list.size(); i++) {

                System.out.println(list.get(i).toString());
            }
        }



        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i).toString());

        }


    }

    //вывести на экран транспорт по id
    public void getById(Integer id){

        try {

            Transport transport = tr.getByTransportId(Long.valueOf(id));

            if (transport.getTransportVIN() == null) {

                System.out.println("Транспорт не найден");

            } else {

                System.out.println(transport.toString());
            }


        } catch (SQLException e) {

            System.out.println("Данные не получены");
        }

    }




    public void getInUnpair(Integer flag){

        List<Transport> list = new ArrayList<>();

        try {
            list = tr.getInUnpair(flag);

        } catch (Exception e) {

            System.out.println("Данные не получены");
        }

        if (list.isEmpty()) {

            System.out.println("Транспорт не найден");

        } else {

            for (int i = 0; i < list.size(); i++) {

                System.out.println(list.get(i).toString());
            }
        }


    }

    public void getTransportByType(String type) {

        try {

            List<Transport> list = tr.getByTypeTransport(TransportType.valueOf(type.toUpperCase()));

            for (int i = 0; i < list.size(); i++) {

                System.out.println(list.get(i).toString());
            }
        } catch (Exception e) {
            System.out.println("Данные не получены");


        }

    }

    public void getByVIN(String vin) {

        try {

            Transport transport = tr.getByTransportVin(vin);

            if (transport.getTransportVIN() == null) {

                System.out.println("Транспорт не найден");
            } else {

                System.out.println(transport.toString());
            }


        } catch (SQLException e) {

            System.out.println("Данные не получены");
        }
    }

    public void getByNumber(String number) {

        try {
            Transport transport = tr.getByNumber(number);

            if (transport.getTransportNumber() == null) {
                System.out.println("Транспорт не найден");
            } else {

                System.out.println(transport.toString());
            }
        } catch (SQLException e) {

            System.out.println("Данные не получены");


        }
    }


}


