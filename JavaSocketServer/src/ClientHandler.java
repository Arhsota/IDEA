import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket s;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;
    private MyServer owner;

    public String getName() {
        return name;
    }

    public ClientHandler(Socket s, MyServer owner) {
        this.s = s;
        name = "";
        this.owner = owner;
        try {
            in = new DataInputStream(s.getInputStream());
            out = new DataOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String str = in.readUTF();

                if (str != null && name.isEmpty()) {
                    String[] x = str.split(" ");
                    if(x.length == 3){
                        if(x[0].equals("/auth")){
                            String login = x[1];
                            String pass = x[2];
                            String nick = SQLHandler.getNickByLoginAndPassword(login,pass);
                            System.out.println("nick "+nick);
                            if(nick!=null){
                                name = nick;
                                owner.addClient(this);
                                continue;
                            }
                        }
                    }
                }

                if (str != null && !name.isEmpty()) {
                    if (str.equalsIgnoreCase("end")) break;
                    owner.broadcastMsg(name + ": " + str);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("IO ERROR");
        } finally {
            owner.removeFromClients(this);
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
