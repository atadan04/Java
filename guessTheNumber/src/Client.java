import java.io.*;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1", 8000);
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String request = reader.readLine();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        System.out.println(request);

        int responseInt = 0;
        try {
            while (true) {

                responseInt = scanner.nextInt();
                if (responseInt <= 100 && responseInt >= 0) {

                    String responseStr = String.valueOf(responseInt);
                    writer.write(responseStr);
                    writer.newLine();
                    writer.flush();
                    request = reader.readLine();
                    System.out.println(request);
                    if (Objects.equals(request, "You guessed the number")) {
                        writer.close();
                        reader.close();
                        clientSocket.close();
                        break;
                    }
                } else {
                    System.out.println("Enter a number from 0 to 100!");
                }
            }
        } catch (NumberFormatException ex) {
            System.out.println("Is not number...");
            System.out.println("Please restart program");


        } catch (InputMismatchException ex) {
            System.out.println("Is not number...");
            System.out.println("Please restart program");


        }


    }


}
