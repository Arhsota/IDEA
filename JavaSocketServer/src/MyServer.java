import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MyServer {

    private ArrayList<ClientHandler> clients;

    public MyServer() {
        ServerSocket server = null;
        SQLHandler.connect();
        clients = new ArrayList<>();
        try {
            server = new ServerSocket(8189);
            while (true) {
                System.out.println("Waiting for clients...");
                Socket s = server.accept();
                System.out.println("Client connected");
                ClientHandler h = new ClientHandler(s, this);
                new Thread(h).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
                SQLHandler.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void broadcastMsg(String msg) {
        String str = new SimpleDateFormat("HH:mm:ss ").format(Calendar.getInstance().getTime());
        msg = str + " " + msg;
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

    public void removeFromClients(ClientHandler o) {
        clients.remove(o);
        if (!o.getName().isEmpty())
            broadcastMsg(o.getName() + " disconnected from chatroom");
    }

    public void addClient(ClientHandler o) {
        if (!clients.contains(o)) {
            clients.add(o);
            broadcastMsg(o.getName() + " connected to chatroom");
        }
    }

}
