package demo.bytestream.data;


import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RainfallDataCreator {
    public static void main(String[] args) {
        String fileName = "rainfall_data.bin";

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            // Create an array or collection to store the rainfall data for 6 days
            double[] rainfallData = {1.2, 3.5, 0.8, 2.1, 1.5, 4.0};

            // Loop through the 6 days of data
            for (int dayIndex = 0; dayIndex < rainfallData.length; dayIndex++) {
                // Write the day index as an integer
                dataOutputStream.writeInt(dayIndex + 1); // Assuming day index starts from 1

                // Write the rainfall amount as a double
                dataOutputStream.writeDouble(rainfallData[dayIndex]);
            }

            System.out.println("Rainfall data has been successfully written to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the rainfall data: " + e.getMessage());
        }
    }
    
}