package test;

import connection.APOD;
import data.APODObject;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import parsing.Parsing;
import testData.APODTestData;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(JUnitParamsRunner.class)
public class TestForAPOD {
    private static final String EMPTY_STRING = "";

    public static Collection<Object[]> inputDataPositive(){
        return Arrays.asList(new Object[][]{
                {APODTestData.data1, APODTestData.apod1},
                {APODTestData.data2, APODTestData.apod2},
                {APODTestData.data3, APODTestData.apod3},
                {APODTestData.data4, APODTestData.apod4}
        });
    }

    @Test
    @Parameters(method = "inputDataPositive")
    public void testApplicationForEveryday(String data, APODObject apodObject) throws IOException {
        APOD apod = new APOD();
        try{
            if(data.equals(EMPTY_STRING)){
                String response = apod.run();
            }
            String response = apod.run(data);
            APODObject object =(APODObject) new Parsing(new APODObject(), response).parseDataFromJson();
            Assert.assertEquals(object, apodObject);
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
    }
}
