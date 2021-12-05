import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteFlyghtPage extends JPanel {
    private ClientFrame parent;
    private JScrollPane scrollPane;
    private JTable table;
    private String header[]={"id","Aircraft id","Departure city id","Arrival city id", "Departure time", "Eco place price", "Business place price"};
    private JTextField textFieldId;
    private JLabel label;
    private JButton confirm;
    private JButton back;
    private int id;

    public DeleteFlyghtPage(ClientFrame parent){
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

        label=new JLabel("Enter id for delete:");
        label.setSize(300,30);
        label.setLocation(200,300);
        add(label);

        textFieldId = new JTextField();
        textFieldId.setSize(300,30);
        textFieldId.setLocation(100,350);
        add(textFieldId);

        confirm = new JButton("DELETE");
        confirm.setSize(150,30);
        confirm.setLocation(250,400);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id = Integer.parseInt(textFieldId.getText());
                PackageData pd = new PackageData();
                pd.setOperationType("delete_flight");
                pd.setFlyght(new Flyght(id,0,0,0,"",0,0));
                try {
                    parent.getOutputStream().writeObject(pd);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                textFieldId.setText("");
                PackageData pd1 = new PackageData();
                pd1.setOperationType("list_flights");
                try{
                    parent.getOutputStream().writeObject(pd1);
                    if((pd1=(PackageData) parent.getInputStream().readObject())!=null){
                        generateTable(pd1.getFlyghts());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        add(confirm);

        back = new JButton("BACK");
        back.setSize(150,30);
        back.setLocation(100,400);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getDeleteFlyghtPage().setVisible(false);
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
