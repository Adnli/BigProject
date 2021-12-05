import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JPanel {
    private ClientFrame parent;
    private JButton addTicket;
    private JButton editTicket;
    private JButton deleteTicket;
    private JButton exit;
    public MainPage(ClientFrame parent){
        this.parent = parent;
        setSize(500,500);
        setLayout(null);

        addTicket=new JButton("ADD TICKET");
        addTicket.setSize(300,30);
        addTicket.setLocation(100,200);
        addTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd=new PackageData();
                pd.setOperationType("list_flights");
                try {
                    parent.getOutputStream().writeObject(pd);
                    if((pd=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getAddTicketPage().setFlightsId(pd.getFlyghts());
                        parent.getAddTicketPage().setTicketType();
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                parent.getMainPage().setVisible(false);
                parent.getAddTicketPage().setVisible(true);
            }
        });
        add(addTicket);

        editTicket=new JButton("EDIT TICKET");
        editTicket.setSize(300,30);
        editTicket.setLocation(100,250);
        editTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData();
                pd.setOperationType("list_tickets");
                try{
                    parent.getOutputStream().writeObject(pd);
                    if((pd=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getEditTicketPage().generateTable(pd.getTickets());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                parent.getMainPage().setVisible(false);
                parent.getEditTicketPage().setVisible(true);
            }
        });
        add(editTicket);

        deleteTicket= new JButton("DELETE TICKET");
        deleteTicket.setSize(300,30);
        deleteTicket.setLocation(100,300);
        deleteTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData();
                pd.setOperationType("list_tickets");
                try{
                    parent.getOutputStream().writeObject(pd);
                    if((pd=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getDeleteTicketPage().generateTable(pd.getTickets());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                parent.getMainPage().setVisible(false);
                parent.getDeleteTicketPage().setVisible(true);
            }
        });
        add(deleteTicket);

        exit = new JButton("EXIT");
        exit.setSize(300,30);
        exit.setLocation(100,350);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);
    }
}
