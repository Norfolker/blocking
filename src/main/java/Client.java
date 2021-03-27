import java.io.*;
import java.net.Socket;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException {

        StringManager sm = new StringManager();
        Socket client = new Socket("127.0.0.1", 10299);

        try {
            try (BufferedReader reader = new BufferedReader (
                    new InputStreamReader(client.getInputStream()));
                 PrintWriter pw = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);
                 Scanner scanner = new Scanner(System.in)) {
                 String value;
                 while (true) {
                     System.out.println("Введите число или 'нет' для прекращения работы");
                     value = scanner.nextLine();
                     pw.println(value);
                     if (value.equals("нет")) {
                         break;
                     }
                     String result = reader.readLine();
                     long lastResult = sm.returnLastValue(result);
                     System.out.println("Результат: " + lastResult);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
