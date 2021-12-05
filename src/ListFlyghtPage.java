import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListFlyghtPage extends JPanel {
    private ClientFrame parent;
    private JScrollPane scrollPane;
    private JTable table;
    private String header[]={"id","Aircraft id","Departure city id","Arrival city id", "Departure time", "Eco place price", "Business place price"};
    private JButton back;
    private int id;

    public ListFlyghtPage(ClientFrame parent){
        this.parent=parent;
        setSize(500,500);
        setLayout(null);

        table = new JTable();
        table.setFont(new Font("", Font.PLAIN,12));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(400,200);
        scrollPane.setLocation(50,50);
        add(scrollPane);

        back = new JButton("BACK");
        back.setSize(300,30);
        back.setLocation(100,350);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getListFlyghtPage().setVisible(false);
                parent.getFlyghtPage().setVisible(true);
            }
        });
        add(back);
    }
    public void generateTable(ArrayList<Flyght> flyghts){
        Object data[][] = new Object[flyghts.size()][7];

        for (int i = 0; i < flyghts.size(); i++){
            data[i][0]=flyghts.get(i).getId();
            data[i][1]=flyghts.get(i).getAircraft_id();
            data[i][2]=flyghts.get(i).getDeparture_city_id();
            data[i][3]=flyghts.get(i).getArrival_city_id();
            data[i][4]=flyghts.get(i).getDeparture_time();
            data[i][5]=flyghts.get(i).getEconom_place_price();
            data[i][6]=flyghts.get(i).getBusiness_place_price();
        }
        DefaultTableModel tableModel = new DefaultTableModel(data,header);
        table.setModel(tableModel);
    }
}
