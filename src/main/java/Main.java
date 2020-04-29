import nasa.connection.Techport;
import nasa.data.techportObject.ListTechPortObjects;
import nasa.parsing.Parsing;
import scooter.connection.SignUp;
import scooter.data.UserDataDto;
import org.apache.commons.codec.binary.Base64;

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

        /*Techport techport = new Techport("17760");
        String response = techport.run();

        Parsing parsing = new Parsing(new ListTechPortObjects(), response);
        ListTechPortObjects techportObjects = (ListTechPortObjects) parsing.parseDataFromJson();
        System.out.println(techportObjects);
        UserDataDto user = new UserDataDto();
        user.setId("9a27f6c9-3744-44a6-98ef-ef8d176dc262");
        UserData userDate = new UserData(user);
        System.out.println(userDate.run());

        UserDataDto userDataDto = new UserDataDto("testforapi.b@mail.com","qwerty","Alex2","Bor2");
        SignUp signUp = new SignUp();*/


        /*String firstSubStr = "{\"sub\":\"";
        int first = body.indexOf(firstSubStr);
        System.out.println("первое вхождение первой подстроки" + body.indexOf(firstSubStr));
        System.out.println(first + firstSubStr.length());

        String secondSubStr = "\",\"role";
        int second = body.indexOf(secondSubStr);
        System.out.println("первое вхождение второй подстроки" + body.indexOf(secondSubStr));
        System.out.println(second + secondSubStr.length());

        String subStr = body.substring(first + firstSubStr.length(),second);
        System.out.println(subStr);*/

        String jwtToken = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiI1NzM3MGY3NC1kYzk0LTRlNGEtOWZjNi1lOWY0NTMyZTkzMjMiLCJyb2xlIjoiW1wiVVNFUlwiXSIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTkzMzI0OH0.V7UJ396OUIz9V7U0iRViooHNumaOPUF7tm2PklTBOHj6ylnA2FzqU2_oyU9bxWSOOgMXUBpelLpcvyNqaMQxsq3KVIIGrWWoEmpCTTlMCiiR9HQKh6CSZ6u1-xFeHPQU9oYG8o_bpJLpxN16d-FIV0UNOoaMC6hNlFErcg4yibv0SjmKQIjghF38l9rexWYydMLW6IDcO2BLq86wZAFB2IUk8y18gosz2VVQ4tcmgh6w-NKwQRwCO2BL4hbR-nMJZljVJv9zjwntb2B4rPARxTUsv02HrDMlMHqcIVbL3xse4Q8oDFgE9UJoMmyDXwBBCFRCqOwtTNORB6AE1I-EIw";
        String[] split_string = jwtToken.split("\\.");
        String base64EncodedBody = split_string[1];
        Base64 base64Url = new Base64(true);
        System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
        String body = new String(base64Url.decode(base64EncodedBody));
        System.out.println(body);

        String firstSubStr = "{\"sub\":\"";
        int first = body.indexOf(firstSubStr);
        String secondSubStr = "\",\"role";
        int second = body.indexOf(secondSubStr);
        String subStr = body.substring(first + firstSubStr.length(),second);
        System.out.println(subStr);

    }
}