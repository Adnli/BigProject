import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager{
    private Connection connection;
    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/My_base?useUnicode=true&serverTimezone=UTC","root", ""
            );
            System.out.println("CONNECTED");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Aircraft> getAllAircrafts(){
        ArrayList<Aircraft> aircrafts = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM aircrafts");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                int business_class_capacity = rs.getInt("business_class_capacity");
                int econom_class_capacity = rs.getInt("econom_class_capacity");
                aircrafts.add(new Aircraft(id,name,model,business_class_capacity,econom_class_capacity));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return aircrafts;
    }

    public void addAircraft(Aircraft aircraft){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO aircrafts(id, name, model, business_class_capacity, econom_class_capacity) values(NULL,?,?,?,?)");
            st.setString(1,aircraft.getName());
            st.setString(2,aircraft.getModel());
            st.setInt(3,aircraft.getBusiness_class_capacity());
            st.setInt(4,aircraft.getEconom_class_capacity());
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateAircraft(Aircraft aircraft){
        try{
            PreparedStatement st = connection.prepareStatement("UPDATE aircrafts set name = ?, model = ?, business_class_capacity = ?, econom_class_capacity = ? where id = ?");
            st.setString(1, aircraft.getName());
            st.setString(2, aircraft.getModel());
            st.setInt(3, aircraft.getBusiness_class_capacity());
            st.setInt(4, aircraft.getEconom_class_capacity());
            st.setInt(5, aircraft.getId());
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteAircraft(int id){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM aircrafts where id = ?");
            st.setLong(1, id);
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<City> getAllCities(){
        ArrayList<City> cities = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cities");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                String short_name = rs.getString("short_name");

                cities.add(new City(id,name,country,short_name));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return cities;
    }
    public void addCity(City city){
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO cities(id, name, country, short_name) values(NULL,?,?,?)");
            st.setString(1,city.getName());
            st.setString(2,city.getCountry());
            st.setString(3,city.getShort_name());
            st.executeUpdate();
            st.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateCity(City city){
        try{
            PreparedStatement st = connection.prepareStatement("UPDATE cities set name = ?, country = ?, short_name = ? where id = ?");
            st.setString(1,city.getName());
            st.setString(2,city.getCountry());
            st.setString(3,city.getShort_name());
            st.setInt(4, city.getId());
            st.executeUpdate();
            st.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteCity(int id){
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM cities where id = ?");
            st.setInt(1,id);
            st.executeUpdate();
            st.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Flyght> getFlyhgts(){
        ArrayList<Flyght> flights = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM flights");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int aircraft_id = rs.getInt("aircraft_id");
                int departure_city_id = rs.getInt("departure_city_id");
                int arrival_city_id = rs.getInt("arrival_city_id");
                String departure_time = rs.getString("departure_time");
                int econom_place_price = rs.getInt("econom_place_price");
                int business_place_price = rs.getInt("business_place_price");
                flights.add(new Flyght(id,aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flights;
    }
    public void addFlight(Flyght flyght){
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO flights(id, aircraft_id, departure_city_id, arrival_city_id, departure_time, econom_place_price, business_place_price) values(NULL,?,?,?,?,?,?)");
            st.setInt(1, flyght.getAircraft_id());
            st.setInt(2, flyght.getDeparture_city_id());
            st.setInt(3, flyght.getArrival_city_id());
            st.setString(4, flyght.getDeparture_time());
            st.setInt(5, flyght.getEconom_place_price());
            st.setInt(6, flyght.getBusiness_place_price());
            st.executeUpdate();
            st.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateFlight(Flyght flyght){
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE flights set aircraft_id = ?, departure_city_id = ?, arrival_city_id = ?, departure_time = ?, econom_place_price = ?, business_place_price = ? where id = ?");
            st.setInt(1, flyght.getAircraft_id());
            st.setInt(2, flyght.getDeparture_city_id());
            st.setInt(3, flyght.getArrival_city_id());
            st.setString(4, flyght.getDeparture_time());
            st.setInt(5, flyght.getEconom_place_price());
            st.setInt(6, flyght.getBusiness_place_price());
            st.setInt(7,flyght.getId());
            st.executeUpdate();
            st.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteFlyght(int id){
        try {
        PreparedStatement st = connection.prepareStatement("DELETE FROM flights where id = ?");
        st.setInt(1,id);
        st.executeUpdate();
        st.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Ticket> getTickets(){
        ArrayList<Ticket> tickets = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM tickets");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int flight_id = rs.getInt("flight_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String passport_number = rs.getString("passport_number");
                String ticket_type = rs.getString("ticket_type");
                tickets.add(new Ticket(id, flight_id, name, surname, passport_number, ticket_type));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return tickets;
    }
    public void addTicket(Ticket ticket){
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO tickets(id, flight_id, name, surname, passport_number, ticket_type) values(NULL,?,?,?,?,?)");
            st.setInt(1,ticket.getFlight_id());
            st.setString(2,ticket.getName());
            st.setString(3,ticket.getSurname());
            st.setString(4,ticket.getPassport_number());
            st.setString(5,ticket.getTicket_type());
            st.executeUpdate();
            st.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateTicket(Ticket ticket){
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE tickets set flight_id = ?, name = ?, surname = ?, passport_number = ?, ticket_type = ? where id = ?");
            st.setInt(1, ticket.getFlight_id());
            st.setString(2, ticket.getName());
            st.setString(3, ticket.getSurname());
            st.setString(4,ticket.getPassport_number());
            st.setString(5,ticket.getTicket_type());
            st.setInt(6,ticket.getId());
            st.executeUpdate();
            st.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deleteTicket(int id){
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM tickets where id = ?");
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
