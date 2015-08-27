package dz5CSVFile;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmitriy on 8/20/15.
 */
public class CSVWriterImpl implements CSVWriter {
    Logger logger = Logger.getLogger(CSVWriterImpl.class);

    @Override
    public void writeProductListToCSV(String fileName, List<Product> products, boolean appendToFile) {
        File file = new File(fileName);
        FileOutputStream writer = null;

        try {
            if (file.createNewFile()) {
                logger.info("New file: " + fileName + " was created.");
            }
            writer = new FileOutputStream(file, appendToFile);

            for (Product product : products) {
                writer.write((Integer.valueOf(product.getPosition()).toString() + ","
                        + Double.valueOf(product.getPrice()).toString() + "," + product.getName()
                        + "," + new SimpleDateFormat("dd.MM.yyyy").format(product.getFreshness()) + "\n").getBytes());
            }
        } catch (FileNotFoundException e) {
            logger.error("Exception occurred wile writing to file.", e);
        } catch (IOException e) {
            logger.error("Exception occurred wile writing to file.", e);
        } finally {

            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    logger.error("Output stream was not closed.", e);
                }
            }
        }
        logger.info("New data was written to file: " + fileName + ".");
    }


    @Override
    public void writeToCSVRandomData(String fileName, int lineValue) {
        DecimalFormat df = new DecimalFormat("#.##");
        List<Product> productsRandom = new ArrayList<Product>();

        try {
            for (int i = 0; i < lineValue; i++) {
                productsRandom.add(new Product(((int) (Math.random() * 100)),
                        Double.valueOf(df.format(Math.random() * 100)), "product" + String.valueOf(i),
                        new SimpleDateFormat("dd.MM.yyyy").format((Math.random() + 1643) * 876543210l)));
            }
        } catch (ParseException e) {
            logger.error("Exception occurred random data.");
        }
        logger.info("Random data was created.");
        writeProductListToCSV(fileName, productsRandom, false);

    }
}