import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditAircraftPage extends JPanel {
    private ClientFrame parent;
    private JScrollPane scrollPane;
    private JTable table;
    private String header[]={"id","Name","Model","Business Class Capacity","Economy class capacity"};
    private JTextField textFieldId;
    private JLabel label;
    private JButton confirm;
    private JButton back;
    private int id;

    public EditAircraftPage(ClientFrame parent){
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

        label=new JLabel("Enter id for edit:");
        label.setSize(300,30);
        label.setLocation(200,300);
        add(label);

        textFieldId = new JTextField();
        textFieldId.setSize(300,30);
        textFieldId.setLocation(100,350);
        add(textFieldId);

        confirm = new JButton("EDIT");
        confirm.setSize(150,30);
        confirm.setLocation(250,400);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id = Integer.parseInt(textFieldId.getText());
                parent.getEditAircraftPage2().setId(id);
                textFieldId.setText("");
                parent.getEditAircraftPage().setVisible(false);
                parent.getEditAircraftPage2().setVisible(true);
            }
        });
        add(confirm);

        back = new JButton("BACK");
        back.setSize(150,30);
        back.setLocation(100,400);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getEditAircraftPage().setVisible(false);
                parent.getAircraftPage().setVisible(true);
            }
        });
        add(back);
    }
    public void generateTable(ArrayList<Aircraft> aircrafts){
        Object data[][] = new Object[aircrafts.size()][5];

        for (int i = 0; i < aircrafts.size(); i++){
            data[i][0]=aircrafts.get(i).getId();
            data[i][1]=aircrafts.get(i).getName();
            data[i][2]=aircrafts.get(i).getModel();
            data[i][3]=aircrafts.get(i).getBusiness_class_capacity();
            data[i][4]=aircrafts.get(i).getEconom_class_capacity();
        }
        DefaultTableModel tableModel = new DefaultTableModel(data,header);
        table.setModel(tableModel);
    }
}
