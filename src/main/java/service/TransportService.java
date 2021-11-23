package service;


import dao.TransportDAO;
import dao.TransportImpl;
import domain.Transport;

import java.sql.SQLException;
import java.util.List;

public class TransportService   {

    private TransportDAO tr = new TransportImpl();

    public List<Transport> get() throws SQLException {

        return tr.getALL();

    }



    }


