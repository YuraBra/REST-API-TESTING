import connection.APOD;
import data.APODObject;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        APOD apod = new APOD();
        String responseFirst = apod.run();
        String responseSecond = apod.run("2020-04-10");
        Parsing parsing = new Parsing(new APODObject(), responseFirst);
        APODObject object1 = (APODObject) parsing.parseDataFromJson();
        System.out.println(object1.getCopyright());
        Parsing parsing1 =  new Parsing(new APODObject(), responseSecond);
        APODObject object2 = (APODObject) parsing1.parseDataFromJson();
        System.out.println(object2);
    }
}
