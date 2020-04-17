import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import connection.CME;
import data.CMEObject;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
       // APOD apod = new APOD();

        CME cme = new CME();
        String responseFirst = cme.run();
//        ObjectMapper mapper = new ObjectMapper();
//
//        List<CMEObject> objects = mapper.readValue(responseFirst, new
//                TypeReference<List<CMEObject>>() {      });
//
//        Parsing parsing1 =  new Parsing(new APODObject(), responseSecond);
//        for (CMEObject c: objects) {
//            System.out.println(c);
//        }


//        System.out.println(objects.getCopyright());
//        Parsing parsing1 =  new Parsing(new APODObject(), responseSecond);
//        APODObject object2 = (APODObject) parsing1.parseDataFromJson();
//        System.out.println(object2);

    }
}
