package dz5CSVFile;

import java.util.List;

/**
 * Created by dmitriy on 8/20/15.
 */
public interface CSVReader {
    List<Product> readFromFile(String fileName);
}
