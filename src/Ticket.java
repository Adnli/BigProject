import java.io.Serializable;

public class Ticket implements Serializable {
    private int id;
    private int flight_id;
    private String name;
    private String surname;
    private String passport_number;
    private String ticket_type;
    public Ticket(){
        this.id=-1;
        this.flight_id=-1;
        this.name="NONE";
        this.surname="NONE";
        this.passport_number="NONE";
        this.ticket_type="NONE";
    }
    public Ticket(int id, int flight_id, String name, String surname, String passport_number, String ticket_type){
        this.id=id;
        this.flight_id=flight_id;
        this.name=name;
        this.surname=surname;
        this.passport_number=passport_number;
        this.ticket_type=ticket_type;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getFlight_id(){
        return flight_id;
    }
    public void setFlight_id(int flight_id){
        this.flight_id=flight_id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public String getPassport_number(){
        return passport_number;
    }
    public void setPassport_number(String passport_number){
        this.passport_number=passport_number;
    }
    public String getTicket_type(){
        return ticket_type;
    }
    public void setTicket_type(String ticket_type){
        this.ticket_type=ticket_type;
    }
}
