import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTicketPage2 extends JPanel {
    private ClientFrame parent;
    private JTextField textFieldFlightId;
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldPassport_number;
    private JTextField textFieldTicket_type;
    private JLabel label;
    private JButton confirm;
    private JButton back;
    private int id;
    public EditTicketPage2(ClientFrame parent){
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

        textFieldFlightId = new JTextField();
        textFieldFlightId.setSize(200,30);
        textFieldFlightId.setLocation(200,100);
        add(textFieldFlightId);

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

        textFieldTicket_type = new JTextField();
        textFieldTicket_type.setSize(200,30);
        textFieldTicket_type.setLocation(200,300);
        add(textFieldTicket_type);

        confirm = new JButton("CONFIRM");
        confirm.setSize(150,30);
        confirm.setLocation(300,350);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flightId = Integer.parseInt(textFieldFlightId.getText());
                String name = textFieldName.getText();
                String surname = textFieldSurname.getText();
                String passportNumber = textFieldPassport_number.getText();
                String ticketType = textFieldTicket_type.getText();
                Ticket ticket = new Ticket(id,flightId,name,surname,passportNumber,ticketType);
                PackageData pd = new PackageData();
                pd.setOperationType("edit_ticket");
                pd.setTicket(ticket);
                try {
                    parent.getOutputStream().writeObject(pd);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                textFieldFlightId.setText("");
                textFieldName.setText("");
                textFieldSurname.setText("");
                textFieldPassport_number.setText("");
                textFieldTicket_type.setText("");
                PackageData pd1 = new PackageData();
                pd1.setOperationType("list_tickets");
                try{
                    parent.getOutputStream().writeObject(pd1);
                    if((pd1=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getEditTicketPage().generateTable(pd1.getTickets());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                parent.getEditTicketPage2().setVisible(false);
                parent.getEditTicketPage().setVisible(true);
            }
        });
        add(confirm);

        back = new JButton("BACK");
        back.setSize(150,30);
        back.setLocation(100,350);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getEditTicketPage2().setVisible(false);
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
    public void setId(int id){
        this.id=id;
    }
}
