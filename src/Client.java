import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost", 5059);
            ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());
            ClientFrame frame=new ClientFrame(socket,outputStream,inputStream);
            frame.setVisible(true);
        }
        catch (Exception e){
         e.printStackTrace();
        }
    }
}
