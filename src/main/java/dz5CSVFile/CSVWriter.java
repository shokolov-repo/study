package dz5CSVFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by dmitriy on 8/20/15.
 */
public interface CSVWriter {
    void writeProductListToCSV(String destinationFileName, List<Product> newData, boolean appendToFile);
    void writeToCSVRandomData(String destinationFileName, int lineValue);
}
