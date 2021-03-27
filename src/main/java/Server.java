import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

// выбор Blocking-взаимодействия обусловлен необходимостью получения точного результата
public class Server {

    public static void main(String[] args) throws IOException {
        Evaluation evaluation = new Evaluation();
        ServerSocket server = new ServerSocket(10299);
        while (true) {
            try (Socket client = server.accept();
                 PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                 String value;
                 while ((value = reader.readLine()) != null) {
                     if (value.equals("нет")) {
                         break;
                     }
                     int result = Integer.parseInt(value);
                     List<Long> lastResult = evaluation.result(result);
                     pw.println(lastResult);
                }
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
    }
}