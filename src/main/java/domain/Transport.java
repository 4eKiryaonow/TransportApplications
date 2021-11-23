package domain;

import java.util.Objects;

//Модель Транспорта
public class Transport extends BaseModel {

    private TransportType Type; // Тип ТС (Автобус/трамвай/троллейбус)
    private String TransportVIN; // Идентификационный номер VIN
    private String TransportNumber; // регистрационный номер
    private int InRepair; // Статус 1 - в ремонте, 0 - исправен

    public Transport() {
    }

    public Transport(long id, TransportType Type, String TransportVIN, String TransportNumber, int InRepair) {

        super(id);
        this.Type = Type;
        this.TransportVIN = TransportVIN;
        this.TransportNumber = TransportNumber;
        this.InRepair = InRepair;

    }

    public TransportType getTransportType() {
        return Type;
    }

    public void setTransportType(TransportType transportType) {
        this.Type = transportType;
    }

    public String getTransportVIN() {
        return TransportVIN;
    }

    public void setTransportVIN(String transportVIN) {
        TransportVIN = transportVIN;
    }

    public String getTransportNumber() {
        return TransportNumber;
    }

    public void setTransportNumber(String transportNumber) {
        this.TransportNumber = transportNumber;
    }

    public int getInRepair() {
        return InRepair;
    }

    public void setInRepair(int inRepair) {
        this.InRepair = inRepair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Transport transport = (Transport) o;
        return InRepair == transport.InRepair && Type == transport.Type && TransportVIN.equals(transport.TransportVIN) && TransportNumber.equals(transport.TransportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Type, TransportVIN, TransportNumber, InRepair);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", Type=" + Type +
                ", TransportVIN='" + TransportVIN + '\'' +
                ", TransportNumber='" + TransportNumber + '\'' +
                ", InRepair=" + InRepair +
                '}';
    }
}


