import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private ArrayList<Aircraft> aircrafts;
    private Aircraft aircraft;
    private ArrayList<City> cities;
    private City city;
    private ArrayList<Flyght> flyghts;
    private Flyght flyght;
    private ArrayList<Ticket> tickets;
    private Ticket ticket;
    public PackageData(){
        this.operationType="NONE";
    }
    public PackageData(String operationType, ArrayList<Aircraft> aircrafts, Aircraft aircraft, ArrayList<City> cities, City city, ArrayList<Flyght> flyghts, Flyght flyght, ArrayList<Ticket> tickets, Ticket ticket){
        this.operationType=operationType;
        this.aircrafts=aircrafts;
        this.aircraft=aircraft;
        this.cities=cities;
        this.city=city;
        this.flyghts=flyghts;
        this.flyght=flyght;
        this.tickets=tickets;
        this.ticket=ticket;
    }
    public String getOperationType(){
        return operationType;
    }
    public void setOperationType(String operationType){
        this.operationType=operationType;
    }
    public Aircraft getAircraft(){
        return aircraft;
    }
    public ArrayList<Aircraft> getAircrafts(){
        return aircrafts;
    }
    public void setAircraft(Aircraft aircraft){
        this.aircraft=aircraft;
    }
    public void setAircrafts(ArrayList<Aircraft> aircrafts){
        this.aircrafts=aircrafts;
    }
    public void addAircraft(Aircraft aircraft){
        this.aircrafts.add(aircraft);
    }
    public void deleteAircraft(int index){
        this.aircrafts.remove(index);
    }
    public City getCity(){
        return city;
    }
    public ArrayList<City> getCities(){
        return cities;
    }
    public void setCity(City city){
        this.city=city;
    }
    public void setCities(ArrayList<City> cities){
        this.cities=cities;
    }
    public void addCity(City city){
        this.cities.add(city);
    }
    public void deleteCity(int index){
        this.cities.remove(index);
    }
    public Flyght getFlyght(){
        return flyght;
    }
    public ArrayList<Flyght> getFlyghts(){
        return flyghts;
    }
    public void setFlyght(Flyght flyght){
        this.flyght=flyght;
    }
    public void setFlyghts(ArrayList<Flyght> flyghts){
        this.flyghts=flyghts;
    }
    public void addFlyght(Flyght flyght){
        this.flyghts.add(flyght);
    }
    public void deleteFlyght(int index){
        this.flyghts.remove(index);
    }
    public ArrayList<Ticket> getTickets(){
        return tickets;
    }
    public Ticket getTicket(){
        return ticket;
    }
    public void setTicket(Ticket ticket){
        this.ticket=ticket;
    }
    public void setTickets(ArrayList<Ticket> tickets){
        this.tickets=tickets;
    }
    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }
    public void deleteTicket(int index){
        this.tickets.remove(index);
    }
}
