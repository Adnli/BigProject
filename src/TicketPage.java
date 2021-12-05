import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketPage extends JPanel {
    private ClientFrame parent;
    private JButton addTicket;
    private JButton listTickets;
    private JButton editTicket;
    private JButton deleteTicket;
    private JButton back;
    private int opType;
    public TicketPage(ClientFrame parent){
        this.parent=parent;
        setSize(500,500);
        setLayout(null);

        addTicket=new JButton("ADD TICKET");
        addTicket.setSize(300,30);
        addTicket.setLocation(100,100);
        addTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOpType(1);
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
                parent.getTicketPage().setVisible(false);
                parent.getAddTicketPage().setVisible(true);
            }
        });
        add(addTicket);

        listTickets = new JButton("LIST TICKETS");
        listTickets.setSize(300,30);
        listTickets.setLocation(100,150);
        listTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData();
                pd.setOperationType("list_tickets");
                try{
                    parent.getOutputStream().writeObject(pd);
                    if((pd=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getListTicketsPage().generateTable(pd.getTickets());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                setOpType(1);
                parent.getTicketPage().setVisible(false);
                parent.getListTicketsPage().setVisible(true);
            }
        });
        add(listTickets);

        editTicket=new JButton("EDIT TICKET");
        editTicket.setSize(300,30);
        editTicket.setLocation(100,200);
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
                setOpType(1);
                parent.getTicketPage().setVisible(false);
                parent.getEditTicketPage().setVisible(true);
            }
        });
        add(editTicket);

        deleteTicket= new JButton("DELETE TICKET");
        deleteTicket.setSize(300,30);
        deleteTicket.setLocation(100,250);
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
                setOpType(1);
                parent.getTicketPage().setVisible(false);
                parent.getDeleteTicketPage().setVisible(true);
            }
        });
        add(deleteTicket);

        back = new JButton("BACK");
        back.setSize(300,30);
        back.setLocation(100,350);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getTicketPage().setVisible(false);
                parent.getAdminMainPage().setVisible(true);
            }
        });
        add(back);

    }
    public int getOpType(){
        return opType;
    }
    public void setOpType(int opType){
        this.opType=opType;
    }
}
