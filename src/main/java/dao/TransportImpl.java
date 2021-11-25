package dao;

import connectDB.ConnectDB;
import domain.Transport;
import domain.TransportType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TransportImpl extends ConnectDB implements TransportDAO {

    Connection connection = getConnection();

    @Override
    public List<Transport> getALL() throws SQLException {

        List<Transport> transportList = new ArrayList<>();
        String sql = "SELECT transport_id, transport_type, transport_vin, transport_number, in_repair FROM transport";

        Statement statement = null;
        try {

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Transport transport = new Transport();
                transport.setId(resultSet.getLong("transport_id"));
                transport.setTransportVIN(resultSet.getString("transport_vin"));
                transport.setTransportType(TransportType.valueOf(resultSet.getString("transport_type").toUpperCase(Locale.ROOT)));
                transport.setTransportNumber(resultSet.getString("transport_number"));
                transport.setInRepair(resultSet.getInt("in_repair"));

                transportList.add(transport);

            }


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (statement != null) {
                statement.close();

            }


        }
        return transportList;
    }

    @Override
    public Transport getByTransportId(Long id) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT transport_id, transport_type, transport_vin, transport_number, in_repair FROM transport WHERE transport_id=?";

        Transport transport = new Transport();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                transport.setId(resultSet.getLong("transport_id"));
                transport.setTransportType(TransportType.valueOf(resultSet.getString("transport_type").toUpperCase()));
                transport.setTransportVIN(resultSet.getString("transport_vin"));
                transport.setTransportNumber(resultSet.getString("transport_number"));
                transport.setInRepair(resultSet.getInt("in_repair"));
            }

            //preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (preparedStatement != null) {

                preparedStatement.close();

            }

        }


        return transport;
    }

    @Override
    public List<Transport> getInUnpair(Integer flag) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT transport_id, transport_type, transport_vin, transport_number, in_repair FROM transport WHERE in_repair=?";

        List<Transport> transportList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, flag);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Transport transport = new Transport();
                transport.setId(resultSet.getLong("transport_id"));
                transport.setTransportType(TransportType.valueOf(resultSet.getString("transport_type").toUpperCase()));
                transport.setTransportVIN(resultSet.getString("transport_vin"));
                transport.setTransportNumber(resultSet.getString("transport_number"));
                transport.setInRepair(resultSet.getInt("in_repair"));

                transportList.add(transport);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (preparedStatement != null) {

                preparedStatement.close();

            }


        }
        return transportList;

    }

    @Override
    public List<Transport> getByTypeTransport(TransportType type) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT transport_id, transport_type, transport_vin, transport_number, in_repair FROM transport WHERE transport_type=?";

        List<Transport> transportList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(type).toLowerCase(Locale.ROOT));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Transport transport = new Transport();
                transport.setId(resultSet.getLong("transport_id"));
                transport.setTransportType(TransportType.valueOf(resultSet.getString("transport_type").toUpperCase()));
                transport.setTransportVIN(resultSet.getString("transport_vin"));
                transport.setTransportNumber(resultSet.getString("transport_number"));
                transport.setInRepair(resultSet.getInt("in_repair"));

                transportList.add(transport);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (preparedStatement != null) {

                preparedStatement.close();

            }


        }
        return transportList;


    }

    @Override
    public Transport getByTransportVin(String transportVIN) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT transport_id, transport_type, transport_vin, transport_number, in_repair FROM transport WHERE transport_vin=?";

        Transport transport = new Transport();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transportVIN);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                transport.setId(resultSet.getLong("transport_id"));
                transport.setTransportType(TransportType.valueOf(resultSet.getString("transport_type").toUpperCase(Locale.ROOT)));
                transport.setTransportVIN(resultSet.getString("transport_vin"));
                transport.setTransportNumber(resultSet.getString("transport_number"));
                transport.setInRepair(resultSet.getInt("in_repair"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (preparedStatement != null) {

                preparedStatement.close();

            }

        }


        return transport;
    }

    @Override
    public Transport getByNumber(String number) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT transport_id, transport_type, transport_vin, transport_number, in_repair FROM transport WHERE transport_number=?";

        Transport transport = new Transport();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, number);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                transport.setId(resultSet.getLong("transport_id"));
                transport.setTransportType(TransportType.valueOf(resultSet.getString("transport_type").toUpperCase(Locale.ROOT)));
                transport.setTransportVIN(resultSet.getString("transport_vin"));
                transport.setTransportNumber(resultSet.getString("transport_number"));
                transport.setInRepair(resultSet.getInt("in_repair"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (preparedStatement != null) {

                preparedStatement.close();

            }

        }


        return transport;
    }
}



