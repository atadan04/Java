import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    public static void main(String[] args) {
        try {
            int countClient = 0;
            ServerSocket serverSocket = new ServerSocket(8000);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client # " + (++countClient) + " connected");
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                Random random = new Random();
                int num = random.nextInt(101);
                writer.write("Welcome, server figured out a number, try to guess it.");
                writer.newLine();
                writer.flush();
                int responseInt;

                while (true) {

                    String response = reader.readLine();


                    responseInt = Integer.parseInt(response);


                    if (responseInt > num) {
                        writer.write("Number is less...");

                        writer.newLine();
                        writer.flush();
                    }
                    if (responseInt < num) {
                        writer.write("Number is greater...");

                        writer.newLine();
                        writer.flush();
                    }
                    if (responseInt == num) {
                        writer.write("You guessed the number");
                        writer.newLine();
                        writer.flush();
                        break;
                    }

                }
                reader.close();
                writer.close();

                clientSocket.close();

            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException ex) {
            System.out.println("IS not number...");
        }
    }
}
