package demo.bytestream.data;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Rainfalldata {
    public static void main(String[] args) {
        String fileName = "rainfall_data.bin";

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fileName))) {
            double totalRainfall = 0.0;
            int count = 0;

            // Loop through the data until the end of the file is reached
            while (dataInputStream.available() > 0) {
                // Read the day index as an integer
                int dayIndex = dataInputStream.readInt();

                // Read the rainfall amount as a double
                double rainfallAmount = dataInputStream.readDouble();

                System.out.println("Day " + dayIndex + ": " + rainfallAmount + " mm");

                totalRainfall += rainfallAmount;
                count++;
            }

            if (count > 0) {
                double averageRainfall = totalRainfall / count;
                System.out.println("Average Rainfall: " + averageRainfall + " mm");
            } else {
                System.out.println("No data available.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the rainfall data: " + e.getMessage());
        }
    }
}