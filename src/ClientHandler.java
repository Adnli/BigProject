import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread{
    Socket socket;
    int id;
    public ClientHandler(){
        this.socket=null;
        this.id=-1;
    }
    public ClientHandler(Socket socket, int id){
        this.socket=socket;
        this.id=id;
    }
    public void run(){
        try {
            DBManager db = new DBManager();
            db.connect();
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            PackageData response;
            while ((response=(PackageData) inputStream.readObject())!=null){
                if(response.getOperationType().equals("list_aircrafts")){
                    response.setAircrafts(db.getAllAircrafts());
                    outputStream.writeObject(response);
                }
                else if(response.getOperationType().equals("add_aircraft")){
                    db.addAircraft(response.getAircraft());
                }
                else if(response.getOperationType().equals("edit_aircraft")){
                    db.updateAircraft(response.getAircraft());
                }
                else if(response.getOperationType().equals("delete_aircraft")){
                    db.deleteAircraft(response.getAircraft().getId());
                }
                else if(response.getOperationType().equals("list_cities")){
                    response.setCities(db.getAllCities());
                    outputStream.writeObject(response);
                }
                else if(response.getOperationType().equals("add_city")){
                    db.addCity(response.getCity());
                }
                else if(response.getOperationType().equals("edit_city")){
                    db.updateCity(response.getCity());
                }
                else if(response.getOperationType().equals("delete_city")){
                    db.deleteCity(response.getCity().getId());
                }
                else if(response.getOperationType().equals("list_flights")){
                    response.setFlyghts(db.getFlyhgts());
                    outputStream.writeObject(response);
                }
                else if(response.getOperationType().equals("add_flight")){
                    db.addFlight(response.getFlyght());
                }
                else if(response.getOperationType().equals("edit_flight")){
                    db.updateFlight(response.getFlyght());
                }
                else if(response.getOperationType().equals("delete_flight")){
                    db.deleteFlyght(response.getFlyght().getId());
                }
                else if(response.getOperationType().equals("list_tickets")){
                    response.setTickets(db.getTickets());
                    outputStream.writeObject(response);
                }
                else if(response.getOperationType().equals("add_ticket")){
                    db.addTicket(response.getTicket());
                }
                else if(response.getOperationType().equals("delete_ticket")){
                    db.deleteTicket(response.getTicket().getId());
                }
                else if(response.getOperationType().equals("edit_ticket")){
                    db.updateTicket(response.getTicket());
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
