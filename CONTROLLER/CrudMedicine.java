/*PROJECT_NAME | ROLL_NUMBER | YOUR_NAME
This is the CRUD medicine class meaning Create, Read, Update and Delete. This class container the database
directory and methods to perform above functions. Moreover, there's a method called printAllMedicine() which
prints all the medicine in the database file.
This class uses Medicine
*/
package CONTROLLER;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import MODEL.Medicine;

public class CrudMedicine {
    private static final String fileName = "DATABASE/medicines.txt";

    public void addMedicine(final Medicine medicine) {
        try {
            final File file = new File(fileName);
            final FileWriter fr = new FileWriter(file, true);
            final BufferedWriter br = new BufferedWriter(fr);
            final PrintWriter pr = new PrintWriter(br);
            pr.println(medicine.getName());
            pr.close();
            br.close();
            fr.close();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeMedicine(final Medicine medicine) throws IOException {
        final String medName = medicine.getName();
        final File file = new File(fileName);
        final List<String> out = Files.lines(file.toPath()).filter(line -> !line.contains(medName))
                .collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void printAllMedicines() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public void updateMedicine(Medicine before, Medicine after) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        StringBuffer inputBuffer = new StringBuffer();
        String line = before.getName();

        while ((line = file.readLine()) != null) {
            line = after.getName();
            inputBuffer.append(line);
            inputBuffer.append('\n');
        }
        file.close();

        FileOutputStream fileOut = new FileOutputStream(fileName);
        fileOut.write(inputBuffer.toString().getBytes());
        fileOut.close();
    }

    public boolean searchMedicine(String medicineName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(medicineName)) {
                    return true;
                }
            }
            return false;
        }
    }

}