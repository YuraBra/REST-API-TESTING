import Parsing.Parsing;
import com.fasterxml.jackson.core.JsonParser;
import connection.AsteroidsNeoWs;
import data.asteroidsObject.AsteroidObject;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        APOD apod = new APOD();
        String responseFirst = apod.run();
        String responseSecond = apod.run("2020-04-10");

        Parsing parsing = new Parsing(new APODObject(), responseFirst);
        APODObject object1 = (APODObject) parsing.parseDataFromJson();


        Parsing parsing1 =  new Parsing(new APODObject(), responseSecond);
        APODObject object2 = (APODObject) parsing1.parseDataFromJson();
        System.out.println(object2);
*/
        AsteroidsNeoWs asteroidsNeoWs = new AsteroidsNeoWs();
        String response = asteroidsNeoWs.run("2015-09-07","2015-09-08");

        Parsing parsing2 = new Parsing(new AsteroidObject(),response);
        AsteroidObject asteroidObject = (AsteroidObject) parsing2.parseDataFromJson();
        System.out.println(asteroidObject);

    }
}
