import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();
        ArrayList<String> PMs = new ArrayList<>();
        String color = null;


        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter device code: ");
            String deviceCode = input.nextLine();

            URL url = new URL("https://looko2.com/tracker.php?lan=&search=" + deviceCode);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();


            if (responseCode > 299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }
            while((line = reader.readLine()) != null ){
                responseContent.append(line);
            }
            reader.close();
            String content = responseContent.toString();
            String[] array = content.split("[><]");
            for (String temp : array) {
                if(temp.contains("ug/m3")) {
                    PMs.add(temp);
                }
            }
            for (String temp : array) {
                if (temp.contains("width=20%")) {
                    String[] colorLine = temp.split("[:;]");
                    for (String tempColor : colorLine){
                        if (tempColor.contains("#")){
                            color = tempColor;
                        }
                    }
                }
            }
            System.out.println("PM1 is: " + PMs.get(0));
            System.out.println("PM2.5 is: " + PMs.get(1));
            System.out.println("PM10 is: " + PMs.get(2));
            System.out.println("Color is: " + color);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
