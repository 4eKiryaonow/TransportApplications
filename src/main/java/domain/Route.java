package domain;

import java.util.Objects;

//Модель маршрута
public class Route extends BaseModel{

    private String RouteNumber; // Номер маршрута
    private TransportType Type; // Тип транспорта
    private int Distance; // расстояние маршрута
    private int NumOfStations; //количество остановок
    private long Transport; // назначенный транспорт

    public Route() {}

    public Route(long id,
                 String routeNumber,
                 TransportType type,
                 int distance,
                 int numOfStations,
                 long transport) {

        super(id);
        this.RouteNumber = routeNumber;
        this.Type = type;
        this.Distance = distance;
        this.NumOfStations = numOfStations;
        this.Transport = transport;

    }

    public String getRouteNumber() {
        return RouteNumber;
    }

    public void setRouteNumber(String routeNumber) {

        this.RouteNumber = routeNumber;

    }

    public TransportType getTypeTransport() {
        return Type;
    }

    public void setTypeTransport(TransportType typeTransport) {

        this.Type = typeTransport;
    }

    public int getDistance() {
        return Distance;
    }

    public void setDistance(int distance) {

        this.Distance = distance;
    }

    public int getNumOfStations() {
        return NumOfStations;
    }

    public void setNumOfStations(int numOfStations) {

        this.NumOfStations = numOfStations;
    }

    public long getTransport() {
        return Transport;
    }

    public void setTransport(long transport) {

        this.Transport = transport;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Route route = (Route) o;
        return Distance == route.Distance && NumOfStations == route.NumOfStations && Transport == route.Transport && RouteNumber.equals(route.RouteNumber) && Type.equals(route.Type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),
                RouteNumber,
                Type,
                Distance,
                NumOfStations,
                Transport);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", RouteNumber='" + RouteNumber + '\'' +
                ", TypeTransport='" + Type + '\'' +
                ", Distance=" + Distance +
                ", NumOfStations=" + NumOfStations +
                ", Transport=" + Transport +
                '}';
    }
}
