import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMainPage extends JPanel {
    private ClientFrame parent;
    private JButton aircrafts;
    private JButton cities;
    private JButton flights;
    private JButton tickets;
    private JButton exit;
    public AdminMainPage(ClientFrame parent){
        this.parent=parent;
        setSize(500,500);
        setLayout(null);

        aircrafts = new JButton("AIRCRAFTS");
        aircrafts.setSize(300,30);
        aircrafts.setLocation(100,150);
        aircrafts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAdminMainPage().setVisible(false);
                parent.getAircraftPage().setVisible(true);
            }
        });
        add(aircrafts);

        cities = new JButton("CITIES");
        cities.setSize(300,30);
        cities.setLocation(100,200);
        cities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAdminMainPage().setVisible(false);
                parent.getCityPage().setVisible(true);
            }
        });
        add(cities);

        flights = new JButton("FLIGHTS");
        flights.setSize(300,30);
        flights.setLocation(100,250);
        flights.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAdminMainPage().setVisible(false);
                parent.getFlyghtPage().setVisible(true);
            }
        });
        add(flights);

        tickets = new JButton("TICKETS");
        tickets.setSize(300,30);
        tickets.setLocation(100,300);
        tickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAdminMainPage().setVisible(false);
                parent.getTicketPage().setVisible(true);
            }
        });
        add(tickets);

        exit = new JButton("EXIT");
        exit.setSize(300,30);
        exit.setLocation(100,400);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);
    }
}
