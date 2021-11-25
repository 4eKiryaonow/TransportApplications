package dao;

import connectDB.ConnectDB;
import domain.Route;
import domain.Transport;
import domain.TransportType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RouteImpl extends ConnectDB implements RouteDAO {

    Connection connection = getConnection();


    @Override
    public List<Route> getALL() throws SQLException {

        List<Route> routeList = new ArrayList<>();
        String sql = "SELECT route_id, route_number, route_transporttype, route_distance, route_stationnum, transport_id FROM route";

        Statement statement = null;
        try {

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Route route = new Route();
                route.setId(resultSet.getLong("route_id"));
                route.setRouteNumber(resultSet.getString("route_number"));
                route.setTypeTransport(TransportType.valueOf(resultSet.getString("route_transporttype").toUpperCase(Locale.ROOT)));
                route.setDistance(resultSet.getInt(resultSet.getInt("route_distance")));
                route.setNumOfStations(resultSet.getInt("route_stationnum"));
                route.setTransport(Long.valueOf(resultSet.getString("transport_id")));

                routeList.add(route);

            }


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (statement != null) {
                statement.close();

            }

        }
        return routeList;
    }


    @Override
    public Route getByRouteId(Long id) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT route_id, route_number, route_transporttype, route_distance, route_stationnum, transport_id FROM route WHERE route_id=?";

        Route route = new Route();

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            route.setId(resultSet.getLong("route_id"));
            route.setRouteNumber(resultSet.getString("route_number"));
            route.setTypeTransport(TransportType.valueOf(resultSet.getString("route_transporttype")));
            route.setDistance(resultSet.getInt("route_distance"));
            route.setNumOfStations(resultSet.getInt("route_stationnum"));
            route.setTransport(resultSet.getLong("transport_id"));


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (preparedStatement != null) {

                preparedStatement.close();

            }

        }


        return route;
    }

    @Override
    public List<Route> getRouteListWithOutTransport() throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT route_id, route_number, route_transpporttype, route_distance, route_stationnum, transport_id FROM route WHERE transport_id=? ORDER BY route_distance DESC, route_stationnum";

        List<Route> routeList = new ArrayList<>();

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, null);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Route route = new Route();
                route.setId(resultSet.getLong("route_id"));
                route.setRouteNumber(resultSet.getString("route_number"));
                route.setTypeTransport(TransportType.valueOf(resultSet.getString("route_transporttype").toUpperCase(Locale.ROOT)));
                route.setNumOfStations(resultSet.getInt("route_stationnum"));
                route.setDistance(resultSet.getInt("route_distance"));
                route.setTransport(resultSet.getLong("transport_id"));

                routeList.add(route);

            }


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();

            }


        }
        return routeList;
    }


    @Override
    public List<Route> getRouteListByTypeOfTransport(TransportType type) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "SELECT route_id, route_number, route_transpporttype, route_distance, route_stationnum," +
                "transport_id FROM route" +
                "WHERE route_transporttype=?" +
                " ORDER BY route_distance";

        List<Route> routeList = new ArrayList<>();

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(type));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Route route = new Route();
                route.setId(resultSet.getLong("route_id"));
                route.setRouteNumber(resultSet.getString("route_number"));
                route.setTypeTransport(TransportType.valueOf(resultSet.getString("route_transporttype")));
                route.setNumOfStations(resultSet.getInt("route_stationnum"));
                route.setTransport(resultSet.getLong("transport_id"));

                routeList.add(route);

            }


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();

            }


        }
        return routeList;
    }


}
