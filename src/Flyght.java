import java.io.Serializable;

public class Flyght implements Serializable {
    private int id;
    private int aircraft_id;
    private int departure_city_id;
    private int arrival_city_id;
    private String departure_time;
    private int econom_place_price;
    private int business_place_price;
    public Flyght(){
        this.id=-1;
        this.aircraft_id=-1;
        this.departure_city_id=-1;
        this.arrival_city_id=-1;
        this.departure_time="NONE";
        this.econom_place_price=-1;
        this.business_place_price=-1;
    }
    public Flyght(int id, int aircraft_id, int departure_city_id, int arrival_city_id, String departure_time, int econom_place_price, int business_place_price){
        this.id=id;
        this.aircraft_id=aircraft_id;
        this.departure_city_id=departure_city_id;
        this.arrival_city_id=arrival_city_id;
        this.departure_time=departure_time;
        this.econom_place_price=econom_place_price;
        this.business_place_price=business_place_price;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getAircraft_id(){
        return aircraft_id;
    }
    public void setAircraft_id(int aircraft_id){
        this.aircraft_id=aircraft_id;
    }
    public int getDeparture_city_id(){
        return departure_city_id;
    }
    public void setDeparture_city_id(int departure_city_id){
        this.departure_city_id=departure_city_id;
    }
    public int getArrival_city_id(){
        return arrival_city_id;
    }
    public void setArrival_city_id(int arrival_city_id){
        this.arrival_city_id=arrival_city_id;
    }
    public String getDeparture_time(){
        return departure_time;
    }
    public void setDeparture_time(String departure_time){
        this.departure_time=departure_time;
    }
    public int getEconom_place_price(){
        return econom_place_price;
    }
    public void setEconom_place_price(int econom_place_price){
        this.econom_place_price=econom_place_price;
    }
    public int getBusiness_place_price(){
        return business_place_price;
    }
    public void setBusiness_place_price(int business_place_price){
        this.business_place_price=business_place_price;
    }
}
