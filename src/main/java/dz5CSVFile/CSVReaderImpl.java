package dz5CSVFile;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitriy on 8/20/15.
 */
public class CSVReaderImpl implements CSVReader {
    Logger logger = Logger.getLogger(CSVReaderImpl.class);

    public List<Product> readFromFile(String fileName) {
        List<Product> products = new ArrayList<Product>();
        File file = new File(fileName);
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader(file));

            while (true) {
                String str = inputStream.readLine();

                if (str == null) {
                    break;
                }
                products.add(parseProduct(str));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            logger.error("Invalid date format.", e);
            throw new ProductFormatException("Invalid date format.");
        } catch (NumberFormatException e) {
            logger.error("Invalid price format.", e);
            throw new ProductFormatException("Invalid price format.");
        } finally {

            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
            }
        }
        return products;
    }

    private Product parseProduct(String str) throws ParseException {
        String[] strings = str.split(",");

        if (strings.length != 4) {
            logger.error("Number of columns does not match.");
            throw new ProductParseException("Number of columns does not match.");
        }
        return new Product(Integer.valueOf(strings[0]), Double.valueOf(strings[1]), strings[2], strings[3]);
    }
}
