import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListCitiesPage extends JPanel {
    private ClientFrame parent;
    private JScrollPane scrollPane;
    private JTable table;
    private String header[]={"id","Name","Country","Short name"};
    private JButton back;
    private int id;

    public ListCitiesPage(ClientFrame parent){
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
                parent.getListCitiesPage().setVisible(false);
                parent.getCityPage().setVisible(true);
            }
        });
        add(back);
    }
    public void generateTable(ArrayList<City> cities){
        Object data[][] = new Object[cities.size()][5];

        for (int i = 0; i < cities.size(); i++){
            data[i][0]=cities.get(i).getId();
            data[i][1]=cities.get(i).getName();
            data[i][2]=cities.get(i).getCountry();
            data[i][3]=cities.get(i).getShort_name();

        }
        DefaultTableModel tableModel = new DefaultTableModel(data,header);
        table.setModel(tableModel);
    }
}
