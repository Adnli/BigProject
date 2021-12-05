import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteTicket extends JPanel {
    private ClientFrame parent;
    private JTable table;
    private String header[]={"id","flight id","name","surname","passport No.","type"};
    private JScrollPane scrollPane;
    private JButton back;
    private JButton delete;
    private JLabel label;
    private JTextField index;
    public DeleteTicket(ClientFrame parent){
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

        index = new JTextField();
        index.setSize(300,30);
        index.setLocation(100,350);
        add(index);

        delete = new JButton("DELETE");
        delete.setSize(150,30);
        delete.setLocation(250,400);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData();
                pd.setOperationType("delete_ticket");
                int id = Integer.parseInt(index.getText());
                pd.setTicket(new Ticket(id,0,"","","",""));
                pd.getTicket().setId(id);
                try {
                    parent.getOutputStream().writeObject(pd);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                index.setText("");
                PackageData pd1 = new PackageData();
                pd1.setOperationType("list_tickets");
                try{
                    parent.getOutputStream().writeObject(pd1);
                    if((pd1=(PackageData) parent.getInputStream().readObject())!=null){
                        parent.getDeleteTicketPage().generateTable(pd1.getTickets());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        add(delete);

        back = new JButton("BACK");
        back.setSize(150,30);
        back.setLocation(100,400);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getDeleteTicketPage().setVisible(false);
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
