import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {
    private static Socket client;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static String str = "Меня зовут так то";

    public static void main(String[] args) {

            try {
                client = new Socket("localhost", 3310);
                out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                out.write( str.getBytes("UTF-8") + "\n");
                out.flush();
                System.out.println(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
            finally {
                    try {
                     client.close();
                     in.close();
                     out.close();
                 } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

}
