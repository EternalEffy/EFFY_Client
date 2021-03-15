import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket client;
    private static BufferedWriter out;


    public static void main(String[] args) {
        try{
            try {
                client = new Socket("localhost", 3310);
                out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

                out.write("Привет" + "\n");
                out.flush();
            }
            finally {
                client.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
