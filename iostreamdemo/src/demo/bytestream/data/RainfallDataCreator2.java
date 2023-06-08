

package demo.bytestream.data;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RainfallDataCreator2 {
    public static void main(String[] args) {
        String filePath = "rainfall_data.bin"; // Path to the output file

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(filePath))) {
            // Writing the rainfall data for two stations in each district
            String[][] stationData = {
                    // District 1: Alor Gajah
                    {"1", "Station A", "1", "10", "20", "30", "40", "50", "60"},
                    {"2", "Station B", "1", "15", "25", "35", "45", "55", "65"},
                    // District 2: Jasin
                    {"3", "Station C", "2", "12", "22", "32", "42", "52", "62"},
                    {"4", "Station D", "2", "18", "28", "38", "48", "58", "68"}
            };

            int numStations = stationData.length;

            outputStream.writeInt(numStations); // Writing the number of stations

            for (String[] data : stationData) {
                outputStream.writeUTF(data[0]); // Station ID
                outputStream.writeUTF(data[1]); // Station Name
                outputStream.writeUTF(data[2]); // District ID

                for (int i = 3; i < data.length; i++) {
                    outputStream.writeInt(Integer.parseInt(data[i])); // Rainfall readings
                }
            }

            System.out.println("Rainfall data created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}