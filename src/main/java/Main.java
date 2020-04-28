import nasa.parsing.Parsing;
import nasa.connection.Techport;
import nasa.data.techportObject.ListTechPortObjects;
import scooter.connection.UserData;
import scooter.data.User;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
       // APOD apod = new APOD();

 //       CME cme = new CME();
//        String responseFirst = cme.run();
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

//        AsteroidsNeoWs asteroidsNeoWs = new AsteroidsNeoWs();
//        String response = asteroidsNeoWs.run("2015-09-07","2015-09-08");
//
//        Parsing parsing2 = new Parsing(new AsteroidObject(),response);
//        AsteroidObject asteroidObject = (AsteroidObject) parsing2.parseDataFromJson();
//        System.out.println(asteroidObject);
//        MarsRoverPhotos marsRoverPhotos = new MarsRoverPhotos();
//        String response = marsRoverPhotos.run("1000");
//        Parsing nasa.parsing = new Parsing(new PhotoMars(), response);
//        PhotoMars photoMars1 = (PhotoMars) nasa.parsing.parseDataFromJsonFailProperties();
//        System.out.println(photoMars1);

       // APOD apod = new APOD();
       // String responseSecond = apod.run();
      //  Parsing parsing1 =  new Parsing(new APODObject(), responseSecond);
       // APODObject object2 = (APODObject) parsing1.parseDataFromJson();
      //  System.out.println(object2);

        /*Techport techport = new Techport();
        String response = techport.run();

        Parsing parsing = new Parsing(new ListTechPortObjects(), response);
        ListTechPortObjects techportObjects = (ListTechPortObjects) parsing.parseDataFromJson();
        System.out.println(techportObjects);*/
        User user = new User();
        user.setId("9a27f6c9-3744-44a6-98ef-ef8d176dc262");
        UserData userDate = new UserData(user);
        System.out.println(userDate.run());

    }
}