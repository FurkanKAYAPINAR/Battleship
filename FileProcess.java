
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileProcess extends Game {

    public int FileNotExists = -1;
    public int FileReadNull = -2;
    public int FileSearchFindClear = 0;
    public int FileSearchFindOK = 1;

    public int getUserDataFromFile(String fileName, String username) {

        try {

            File dosya = new File(fileName);
            if (!dosya.exists()) {
                return this.FileNotExists;
            }

            BufferedReader read = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = read.readLine()) != null) {
                String[] ayrac = line.split(",");
                String name = ayrac[0];
                String type = ayrac[1];
                String counters = ayrac[2];
                counters = counters.replace("(", "").replace(")", "");
                int counter = Integer.parseInt(counters);

                if (name.equals(username)) {

                    user.setPlayed(counter);

                    if (type.equals("Easy")) {
                        user.setLevel(differ.Easy);
                        equipment.setEasy();
                        ship.setEasy();
                    } else if (type.equals("Normal")) {
                        user.setLevel(differ.Normal);
                        equipment.setNormal();
                        ship.setNormal();
                    } else {
                        user.setLevel(differ.Hard);
                        equipment.setHard();
                        ship.setHard();
                    }

                    return this.FileSearchFindOK;
                }
            }
            return this.FileSearchFindClear;

        } catch (Exception e) {
            System.out.println("File Read Error !");
            return this.FileNotExists;
        }
    }

    public boolean setUserDataFromFile(String fileName, String username, String type, int count) {

        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file, true);
            BufferedWriter Bufferwrtr = new BufferedWriter(writer);
            PrintWriter wrtr = new PrintWriter(Bufferwrtr);
            wrtr = new PrintWriter(Bufferwrtr);
            wrtr.println(username + "," + type + ",(" + Integer.toString(count) + ")");
            wrtr.close();
            Bufferwrtr.close();
            writer.close();

            return true;
        } catch (Exception e) {
            System.out.println("Write File Error ! => setUserDataFromFile Function");
            return false;
        }

    }

    public void updateScore(String fileName, String username, String level, int score) {
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String line;
            StringBuffer inputBuffer = new StringBuffer();

            while ((line = file.readLine()) != null) {
                inputBuffer.append(line + "\n");
            }

            file.close();

            String[] inputStr = inputBuffer.toString().split("\n");
            for (int i = 0; i < inputStr.length; i++) {
                String[] ayrac = inputStr[i].split(",");
                if (ayrac[0].equals(username)) //name
                {
                    inputStr[i] = username + "," + level + ",(" + Integer.toString(score) + ")";
                }
            }

            FileOutputStream fileOut = new FileOutputStream(fileName);
            for (int i = 0; i < inputStr.length; i++) {
                inputStr[i] += "\n";
                fileOut.write(inputStr[i].getBytes());
            }
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Read File Error ! => updateScore Function");
        }
    }

}
