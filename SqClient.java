import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SqClient {
    public static void main(String[] args) throws IOException {
        int counter = 0;
        try(Socket socket = new Socket("DESKTOP-QB67GVK", 1020)){
            counter++;
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(counter);
            outputStream.flush();

            InputStream inputStream = socket.getInputStream();

            while (counter < 10) {
                int response = inputStream.read();
                System.out.println(response);
            }
        }
    }
}
