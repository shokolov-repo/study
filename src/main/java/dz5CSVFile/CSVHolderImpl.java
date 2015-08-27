package dz5CSVFile;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dmitriy on 8/21/15.
 */
public class CSVHolderImpl implements CSVHolder {
    Logger logger = Logger.getLogger(CSVHolderImpl.class);

    private static final Comparator COMPARATOR_BY_PRICE = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Product product1 = (Product) o1;
            Product product2 = (Product) o2;
            if (product1.getPrice() > product2.getPrice()) {
                return 1;
            } else if (product1.getPrice() < product2.getPrice()) {
                return -1;
            }
            return 0;
        }
    };

    private static final Comparator COMPARATOR_BY_NAME = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return ((Product) o1).getName().compareTo(((Product) o2).getName());
        }
    };

    private static final Comparator COMPARATOR_BY_FRESHNESS = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Product product1 = (Product) o1;
            Product product2 = (Product) o2;
            if (product1.getFreshness().getTime() > (product2.getFreshness().getTime())) {
                return 1;
            } else if (product1.getFreshness().getTime() < (product2.getFreshness().getTime())) {
                return -1;
            } else return 0;
        }
    };

    private static final Comparator COMPARATOR_BY_DEFAULT = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return ((Product) o1).getPosition() - ((Product) o2).getPosition();
        }


    };

    @Override
    public boolean writeToCSVNewData(String fileName, List<Product> newData) {
        CSVWriter csvWriter = new CSVWriterImpl();
        csvWriter.writeProductListToCSV(fileName, newData, false);
        return new File(fileName).length() != 0;
    }

    @Override
    public boolean addNewDataAndSortBy(String fileName, List<Product> newData, CompareType typeToSortList) {

        switch (typeToSortList) {
            case BY_PRICE:
                Collections.sort(newData, COMPARATOR_BY_PRICE);
                break;
            case BY_NAME:
                Collections.sort(newData, COMPARATOR_BY_NAME);
                break;
            case BY_FRESHNESS:
                Collections.sort(newData, COMPARATOR_BY_FRESHNESS);
                break;
            case DEFAULT:
                Collections.sort(newData, COMPARATOR_BY_DEFAULT);
                break;
        }
        logger.info("Data was sorted: " + typeToSortList + ".");
        return writeToCSVNewData(fileName, newData);
    }

    public static enum CompareType {
        BY_PRICE, BY_NAME, BY_FRESHNESS, DEFAULT

    }
}