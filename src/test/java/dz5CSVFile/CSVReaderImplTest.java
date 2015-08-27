package dz5CSVFile;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by dmitriy on 8/23/15.
 */
public class CSVReaderImplTest {
    private CSVReaderImpl csvReader;

    @Before
    public void setUp() throws Exception {
        csvReader = new CSVReaderImpl();
    }

    @Test
    public void testReadFromFile() throws Exception {
        //given
        Product expectedProductFirst = new Product(1, 4.14, "ritona", "12.10.2015");
        Product expectedProductLast = new Product(5, 3.14, "bizona", "12.10.2017");

        //when
        List<Product> resultList = csvReader.readFromFile("./src/test/resources/product.csv");

        //then
        assertEquals(5, resultList.size());
        assertEquals(expectedProductFirst, resultList.get(0));
        assertEquals(expectedProductLast, resultList.get(4));
    }

    @Test(expected = ProductFormatException.class)
    public void testReadFromFile_InvalidDate() {
        //when
        csvReader.readFromFile("./src/test/resources/invalidDateProduct.csv");
    }

    @Test(expected = ProductFormatException.class)
    public void testReadFromFile_InvalidPrise() {
        //when
        csvReader.readFromFile("./src/test/resources/invalidPriceProduct.csv");
    }

    @Test(expected = ProductParseException.class)
    public void testReadFromFile_InvalidColumnNumber() {
        //when
        csvReader.readFromFile("./src/test/resources/invalidColumnNumberProduct.csv");
    }

}
