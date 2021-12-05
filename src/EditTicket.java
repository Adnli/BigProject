import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditTicket extends JPanel {
    private ClientFrame parent;
    private JScrollPane scrollPane;
    private JTable table;
    private String header[]={"id","flight id","name","surname","passport No.","type"};
    private JTextField textFieldId;
    private JLabel label;
    private JButton confirm;
    private JButton back;
    private int id;

    public EditTicket(ClientFrame parent){
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
                parent.getEditTicketPage2().setId(id);
                textFieldId.setText("");
                parent.getEditTicketPage().setVisible(false);
                parent.getEditTicketPage2().setVisible(true);
            }
        });
        add(confirm);

        back = new JButton("BACK");
        back.setSize(150,30);
        back.setLocation(100,400);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getEditTicketPage().setVisible(false);
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
    public void generateTable(ArrayList<Ticket> tickets){
        Object data[][] = new Object[tickets.size()][6];

        for (int i = 0; i < tickets.size(); i++){
            data[i][0]=tickets.get(i).getId();
            data[i][1]=tickets.get(i).getFlight_id();
            data[i][2]=tickets.get(i).getName();
            data[i][3]=tickets.get(i).getSurname();
            data[i][4]=tickets.get(i).getPassport_number();
            data[i][5]=tickets.get(i).getTicket_type();
        }
        DefaultTableModel tableModel = new DefaultTableModel(data,header);
        table.setModel(tableModel);
    }
}
