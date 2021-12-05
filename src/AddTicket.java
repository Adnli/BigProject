import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddTicket extends JPanel {
    private ClientFrame parent;
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldPassport_number;
    private JComboBox flightsIdBox;
    private JComboBox ticketTypeBox;
    private String[] flightsId;
    private String[] ticketType = new String[2];
    private JLabel label;
    private JButton confirm;
    private JButton back;
    public AddTicket(ClientFrame parent){
        this.parent=parent;

        setSize(500,500);
        setLayout(null);
        label = new JLabel("Flight id:");
        label.setSize(100,30);
        label.setLocation(50,100);
        add(label);

        label = new JLabel("Name:");
        label.setSize(100,30);
        label.setLocation(50,150);
        add(label);

        label = new JLabel("Surname:");
        label.setSize(100,30);
        label.setLocation(50,200);
        add(label);

        label = new JLabel("Passport number:");
        label.setSize(150,30);
        label.setLocation(50,250);
        add(label);

        label = new JLabel("Type: ");
        label.setSize(100,30);
        label.setLocation(50,300);
        add(label);

        textFieldName = new JTextField();
        textFieldName.setSize(200,30);
        textFieldName.setLocation(200,150);
        add(textFieldName);

        textFieldSurname = new JTextField();
        textFieldSurname.setSize(200,30);
        textFieldSurname.setLocation(200,200);
        add(textFieldSurname);

        textFieldPassport_number = new JTextField();
        textFieldPassport_number.setSize(200,30);
        textFieldPassport_number.setLocation(200,250);
        add(textFieldPassport_number);

        confirm = new JButton("CONFIRM");
        confirm.setSize(150,30);
        confirm.setLocation(250,350);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String flightIdString =(String) flightsIdBox.getSelectedItem();
                int flightId = Integer.parseInt(String.valueOf(flightIdString.charAt(0)));
                String name = textFieldName.getText();
                String surname = textFieldSurname.getText();
                String passportNumber = textFieldPassport_number.getText();
                String ticketTypeString =(String) ticketTypeBox.getSelectedItem();
                String ticketType = String.valueOf(ticketTypeString.charAt(0));
                Ticket ticket = new Ticket(0,flightId,name,surname,passportNumber,ticketType);
                PackageData pd = new PackageData();
                pd.setOperationType("add_ticket");
                pd.setTicket(ticket);
                try {
                    parent.getOutputStream().writeObject(pd);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                textFieldName.setText("");
                textFieldSurname.setText("");
                textFieldPassport_number.setText("");
            }
        });
        add(confirm);

        back = new JButton("BACK");
        back.setSize(150,30);
        back.setLocation(100,350);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAddTicketPage().setVisible(false);
                if(parent.getTicketPage().getOpType()==1){
                    parent.getTicketPage().setVisible(true);
                }
                else if(parent.getTicketPage().getOpType()!=1){
                    parent.getMainPage().setVisible(true);
                }
                parent.getTicketPage().setOpType(0);
            }
        });
        add(back);
    }
    public void setFlightsId(ArrayList<Flyght> arrayList){
        ArrayList<Flyght> flyghts = arrayList;
        int j;
        for(j=0; j<flyghts.size();j++){
        }
        flightsId = new String[j];
        for(int i=0; i<flyghts.size();i++){
            flightsId[i]=String.valueOf(flyghts.get(i).getId()+" Aircraft id: "+flyghts.get(i).getAircraft_id());
        }
        flightsIdBox = new JComboBox(flightsId);
        flightsIdBox.setSize(200,30);
        flightsIdBox.setLocation(200,100);
        add(flightsIdBox);
    }
    public void setTicketType(){
        ticketType[0]="E";
        ticketType[1]="S";
        ticketTypeBox = new JComboBox(ticketType);
        ticketTypeBox.setSize(200,30);
        ticketTypeBox.setLocation(200,300);
        add(ticketTypeBox);
    }
}
