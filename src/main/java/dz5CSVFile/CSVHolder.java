package dz5CSVFile;

import java.util.List;

/**
 * Created by dmitriy on 8/21/15.
 */
public interface CSVHolder {

    boolean writeToCSVNewData(String destinationFileName, List<Product> newData);

    boolean addNewDataAndSortBy (String destinationFileName, List<Product> newData, CSVHolderImpl.CompareType typeToSortList);


}
