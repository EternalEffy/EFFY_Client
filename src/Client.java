import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    private static Socket client;
    private static DataInputStream inStream;
    private static DataOutputStream outStream;
    private static String str = "Alex";

    public static void main(String[] args) {

            try {
                client = new Socket("localhost", 3320);
                inStream= new DataInputStream(client.getInputStream());
                outStream=new DataOutputStream((client.getOutputStream()));

                outStream.writeUTF(str);
                outStream.flush();
                System.out.println(inStream.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        }
            finally {
                    try {
                     client.close();
                 } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

}
