package dao;

import domain.Transport;
import domain.TransportType;

import java.sql.SQLException;
import java.util.List;

public interface TransportDAO {



     //получить все записи из таблицы transort
    List<Transport> getALL() throws SQLException;

    //получить конкретный транспорт по id
    Transport getByTransportId(Long id)  throws SQLException ;

    //получить список транспортов в ремонте/ не в ремонте
    List<Transport> getInUnpair(Integer flag) throws SQLException;

    //получить список транспорта по типу
    List<Transport> getByTypeTransport(TransportType type) throws SQLException;

    //Получить конкретный транспорт по номеру VIN
    Transport getByTransportVin(String transportVIN) throws SQLException;

    //Получить конкретный транспорт по номеру
    Transport getByNumber(String number) throws SQLException;



}
