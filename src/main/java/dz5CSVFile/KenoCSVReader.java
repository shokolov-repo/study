package dz5CSVFile;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by user on 18.10.16.
 */
public class KenoCSVReader {
    private Logger logger = Logger.getLogger(this.getClass());

    public List<ResultLottery> readFromFile(String fileName) {
        List<ResultLottery> results = new ArrayList<>();
        File file = new File(fileName);

        try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {

            while (true) {
                String str = inputStream.readLine();

                if (str == null) {
                    break;
                }
                try {
                    results.add(parseResultLottery(str));
                } catch (ParseException|NumberFormatException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return results;
    }

    private ResultLottery parseResultLottery(String str) throws ParseException {
        String[] strings = str.split(";");
        Integer[] integers = new Integer[20];
        ResultLottery result = new ResultLottery();

        result.setNumOfGame(Integer.parseInt(strings[0]));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        result.setDate(format.parse(strings[1]).toString());

        for (int i = 0; i < 20; i++) {
            integers[i] = Integer.parseInt(strings[i + 3]);
        }
        result.setNumbers(new ArrayList<>(Arrays.asList(integers)));

        return result;
    }
}
