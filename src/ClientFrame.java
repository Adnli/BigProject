import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientFrame extends JFrame {
    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private ChoosePage choosePage;
    private AdminMainPage adminMainPage;
    private AircraftPage aircraftPage;
    private AddAircraftPage addAircraftPage;
    private ListAircraftsPage listAircraftsPage;
    private EditAircraftPage editAircraftPage;
    private EditAircraftPage2 editAircraftPage2;
    private DeleteAircraftsPage deleteAircraftsPage;
    private CityPage cityPage;
    private AddCityPage addCityPage;
    private ListCitiesPage listCitiesPage;
    private EditCityPage editCityPage;
    private EditCityPage2 editCityPage2;
    private DeleteCityPage deleteCityPage;
    private FlyghtPage flyghtPage;
    private AddFlyghtPage addFlyghtPage;
    private ListFlyghtPage listFlyghtPage;
    private EditFlyghtPage editFlyghtPage;
    private EditFlyghtPage2 editFlyghtPage2;
    private DeleteFlyghtPage deleteFlyghtPage;
    private MainPage mainPage;
    private TicketPage ticketPage;
    private AddTicket addTicketPage;
    private ListTicketsPage listTicketsPage;
    private EditTicket editTicketPage;
    private DeleteTicket deleteTicketPage;
    private EditTicketPage2 editTicketPage2;

    public ClientFrame(Socket socket, ObjectOutputStream outputStream, ObjectInputStream inputStream) {
        this.socket = socket;
        this.outputStream = outputStream;
        this.inputStream = inputStream;
        try {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("AIRCRAFT MANAGEMENT");
            setSize(500,500);
            setLayout(null);

            choosePage = new ChoosePage(this);
            choosePage.setVisible(true);
            add(choosePage);

            adminMainPage = new AdminMainPage(this);
            adminMainPage.setVisible(false);
            add(adminMainPage);

            aircraftPage = new AircraftPage(this);
            aircraftPage.setVisible(false);
            add(aircraftPage);

            addAircraftPage = new AddAircraftPage(this);
            addAircraftPage.setVisible(false);
            add(addAircraftPage);

            listAircraftsPage = new ListAircraftsPage(this);
            listAircraftsPage.setVisible(false);
            add(listAircraftsPage);

            editAircraftPage = new EditAircraftPage(this);
            editAircraftPage.setVisible(false);
            add(editAircraftPage);

            editAircraftPage2 = new EditAircraftPage2(this);
            editAircraftPage2.setVisible(false);
            add(editAircraftPage2);

            deleteAircraftsPage = new DeleteAircraftsPage(this);
            deleteAircraftsPage.setVisible(false);
            add(deleteAircraftsPage);

            cityPage = new CityPage(this);
            cityPage.setVisible(false);
            add(cityPage);

            addCityPage = new AddCityPage(this);
            addCityPage.setVisible(false);
            add(addCityPage);

            listCitiesPage = new ListCitiesPage(this);
            listCitiesPage.setVisible(false);
            add(listCitiesPage);

            editCityPage = new EditCityPage(this);
            editCityPage.setVisible(false);
            add(editCityPage);

            editCityPage2 = new EditCityPage2(this);
            editCityPage2.setVisible(false);
            add(editCityPage2);

            deleteCityPage = new DeleteCityPage(this);
            deleteCityPage.setVisible(false);
            add(deleteCityPage);

            flyghtPage = new FlyghtPage(this);
            flyghtPage.setVisible(false);
            add(flyghtPage);

            addFlyghtPage = new AddFlyghtPage(this);
            addFlyghtPage.setVisible(false);
            add(addFlyghtPage);

            listFlyghtPage = new ListFlyghtPage(this);
            listFlyghtPage.setVisible(false);
            add(listFlyghtPage);

            editFlyghtPage = new EditFlyghtPage(this);
            editFlyghtPage.setVisible(false);
            add(editFlyghtPage);

            editFlyghtPage2 = new EditFlyghtPage2(this);
            editFlyghtPage2.setVisible(false);
            add(editFlyghtPage2);

            deleteFlyghtPage = new DeleteFlyghtPage(this);
            deleteFlyghtPage.setVisible(false);
            add(deleteFlyghtPage);

            mainPage = new MainPage(this);
            mainPage.setVisible(false);
            add(mainPage);

            ticketPage = new TicketPage(this);
            ticketPage.setVisible(false);
            add(ticketPage);

            addTicketPage=new AddTicket(this);
            addTicketPage.setVisible(false);
            add(addTicketPage);

            listTicketsPage = new ListTicketsPage(this);
            listTicketsPage.setVisible(false);
            add(listTicketsPage);

            editTicketPage=new EditTicket(this);
            editTicketPage.setVisible(false);
            add(editTicketPage);

            editTicketPage2 = new EditTicketPage2(this);
            editTicketPage2.setVisible(false);
            add(editTicketPage2);

            deleteTicketPage=new DeleteTicket(this);
            deleteTicketPage.setVisible(false);
            add(deleteTicketPage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ChoosePage getChoosePage() {
        return choosePage;
    }
    public AdminMainPage getAdminMainPage(){
        return adminMainPage;
    }
    public AircraftPage getAircraftPage(){
        return aircraftPage;
    }
    public AddAircraftPage getAddAircraftPage(){
        return addAircraftPage;
    }
    public ListAircraftsPage getListAircraftsPage(){
        return listAircraftsPage;
    }
    public EditAircraftPage getEditAircraftPage(){
        return editAircraftPage;
    }
    public EditAircraftPage2 getEditAircraftPage2(){
        return editAircraftPage2;
    }
    public DeleteAircraftsPage getDeleteAircraftsPage(){
        return deleteAircraftsPage;
    }
    public CityPage getCityPage(){
        return cityPage;
    }
    public AddCityPage getAddCityPage(){
        return addCityPage;
    }
    public ListCitiesPage getListCitiesPage(){
        return listCitiesPage;
    }
    public EditCityPage getEditCityPage(){
        return editCityPage;
    }
    public EditCityPage2 getEditCityPage2(){
        return editCityPage2;
    }
    public DeleteCityPage getDeleteCityPage(){
        return deleteCityPage;
    }
    public FlyghtPage getFlyghtPage(){
        return flyghtPage;
    }
    public AddFlyghtPage getAddFlyghtPage(){
        return addFlyghtPage;
    }
    public ListFlyghtPage getListFlyghtPage(){
        return listFlyghtPage;
    }
    public EditFlyghtPage getEditFlyghtPage(){
        return editFlyghtPage;
    }
    public EditFlyghtPage2 getEditFlyghtPage2(){
        return editFlyghtPage2;
    }
    public DeleteFlyghtPage getDeleteFlyghtPage(){
        return deleteFlyghtPage;
    }
    public MainPage getMainPage(){
        return mainPage;
    }
    public TicketPage getTicketPage(){
        return ticketPage;
    }
    public AddTicket getAddTicketPage(){
        return addTicketPage;
    }
    public ListTicketsPage getListTicketsPage(){
        return listTicketsPage;
    }
    public EditTicket getEditTicketPage(){
        return editTicketPage;
    }
    public DeleteTicket getDeleteTicketPage(){
        return deleteTicketPage;
    }
    public EditTicketPage2 getEditTicketPage2(){
        return editTicketPage2;
    }
    public ObjectOutputStream getOutputStream(){
        return outputStream;
    }
    public ObjectInputStream getInputStream(){
        return inputStream;
    }
    public Socket getSocket(){
        return socket;
    }
}
