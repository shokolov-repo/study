package dz5CSVFile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by dmitriy on 8/26/15.
 */
public class CSVWriterImplTest {
    private CSVWriterImpl csvWriter;
    private CSVReaderImpl csvReader;
    private List<Product> productList;
    private File file;

    @Before
    public void setUp() throws Exception {
        csvWriter = new CSVWriterImpl();
        csvReader = new CSVReaderImpl();
        productList = csvReader.readFromFile("./src/test/resources/product.csv");
        file = new File("./src/test/resources/test.csv");
    }

    @After
    public void tearDown() {
        file.delete();
    }

    @Test
    public void testWriteProductListToCSVByAppendTrue() throws Exception {
        //given
        csvWriter.writeProductListToCSV("./src/test/resources/test.csv", productList, false);

        //when
        csvWriter.writeProductListToCSV("./src/test/resources/test.csv", productList, true);

        //then
        assertEquals(10, csvReader.readFromFile("./src/test/resources/test.csv").size());
    }

    @Test
    public void testWriteProductListToCSVByAppendFalse() throws Exception {
        //when
        csvWriter.writeProductListToCSV("./src/test/resources/test.csv", productList, false);

        //then
        assertEquals(5, csvReader.readFromFile("./src/test/resources/test.csv").size());
    }

    @Test
    public void testWriteToCSVRandomData() throws Exception {
        //when
        csvWriter.writeToCSVRandomData("./src/test/resources/test.csv", 12);

        //then
        assertEquals(12, csvReader.readFromFile("./src/test/resources/test.csv").size());
    }
}
