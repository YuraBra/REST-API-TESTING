import connection.APOD;
import connection.CME;
import data.APODObject;
import data.CMEObject;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
       // APOD apod = new APOD();

        CME cme = new CME();
        String responseFirst = cme.run();
       // String responseSecond = apod.run("2020-04-10");
        Parsing parsing = new Parsing(new List<CMEObject>, responseFirst);
        List<CMEObject> objects = (List<CMEObject>) parsing.parseDataFromJson();
        for (CMEObject c: objects) {
            System.out.println(c);
        }
//        System.out.println(objects.getCopyright());
//        Parsing parsing1 =  new Parsing(new APODObject(), responseSecond);
//        APODObject object2 = (APODObject) parsing1.parseDataFromJson();
//        System.out.println(object2);

    }
}
