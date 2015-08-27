package dz5CSVFile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by dmitriy on 8/26/15.
 */
public class CSVHolderImplTest {
    private CSVHolder csvHolder;
    private CSVReader csvReader;
    private List<Product> products;
    private File file;

    @Before
    public void setUp() throws Exception {
        csvHolder = new CSVHolderImpl();
        csvReader = new CSVReaderImpl();
        products = csvReader.readFromFile("./src/test/resources/product.csv");
        file = new File("./src/test/resources/test.csv");
    }

    @After
    public void tearDown() {
        file.delete();
    }

    @Test
    public void testWriteToCSVNewData() throws Exception {
        //when
        assertTrue(csvHolder.writeToCSVNewData("./src/test/resources/test.csv", products));
    }

    @Test
    public void testAddNewDataAndSortByPrice() throws Exception {
        //given
        Product expectedProductFirst = new Product(5, 3.14, "bizona", "12.10.2017");
        Product expectedProductLast = new Product(3, 6.14, "kitona", "13.10.2015");

        //when
        csvHolder.addNewDataAndSortBy("./src/test/resources/test.csv", products, CSVHolderImpl.CompareType.BY_PRICE);

        //then
        assertEquals(expectedProductFirst, csvReader.readFromFile("./src/test/resources/test.csv").get(0));
        assertEquals(expectedProductLast, csvReader.readFromFile("./src/test/resources/test.csv").get(4));
    }

    @Test
    public void testAddNewDataAndSortByName() throws Exception {
        //given
        Product expectedProductFirst = new Product(5, 3.14, "bizona", "12.10.2017");
        Product expectedProductLast = new Product(2, 5.14, "vitona", "12.11.2015");

        //when
        csvHolder.addNewDataAndSortBy("./src/test/resources/test.csv", products, CSVHolderImpl.CompareType.BY_NAME);

        //then
        assertEquals(expectedProductFirst, csvReader.readFromFile("./src/test/resources/test.csv").get(0));
        assertEquals(expectedProductLast, csvReader.readFromFile("./src/test/resources/test.csv").get(4));
    }

    @Test
    public void testAddNewDataAndSortByFreshness() throws Exception {
        //given
        Product expectedProductFirst = new Product(1, 4.14, "ritona", "12.10.2015");
        Product expectedProductLast = new Product(5, 3.14, "bizona", "12.10.2017");

        //when
        csvHolder.addNewDataAndSortBy("./src/test/resources/test.csv", products, CSVHolderImpl.CompareType.BY_FRESHNESS);

        //then
        assertEquals(expectedProductFirst, csvReader.readFromFile("./src/test/resources/test.csv").get(0));
        assertEquals(expectedProductLast, csvReader.readFromFile("./src/test/resources/test.csv").get(4));
    }

    @Test
    public void testAddNewDataAndSortByDefault() throws Exception {
        //given
        Product expectedProductFirst = new Product(1, 4.14, "ritona", "12.10.2015");
        Product expectedProductLast = new Product(5, 3.14, "bizona", "12.10.2017");

        //when
        csvHolder.addNewDataAndSortBy("./src/test/resources/test.csv", products, CSVHolderImpl.CompareType.DEFAULT);

        //then
        assertEquals(expectedProductFirst, csvReader.readFromFile("./src/test/resources/test.csv").get(0));
        assertEquals(expectedProductLast, csvReader.readFromFile("./src/test/resources/test.csv").get(4));
    }
}
