import scooter.data.Data;
import scooter.util.SubStringSearcher;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        /*User userDataDto;
        String activateToken;
        String bearerCode;

        String email = "testforapi.g@mail.com";
        String password = "qwerty";
        String firstName = "Alex7";
        String lastName = "Bor7";
        userDataDto = new User(email,password,firstName,lastName);
        SignUp signUp = new SignUp();
        activateToken = signUp.getResponse(userDataDto);
        System.out.println("Step 1");
        System.out.println(activateToken);
        ActivateAccount acc = new ActivateAccount();
        int actualCode = acc.run(activateToken.replace("\"", ""));
        System.out.println("Step 2");
        System.out.println(actualCode);
        SignIn signIn = new SignIn();
        bearerCode = Objects.requireNonNull(signIn.getResponse(email, password)
                .header("Authorization")).replace("Bearer ", "");
        System.out.println("Step 3");
        System.out.println(bearerCode);

        String[] split_string = bearerCode.split("\\.");
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
        System.out.println("Step 4");
        System.out.println(subStr);

        int actualStatus;
        String respSerID;
        String userId = subStr;
        UserData userData = new UserData(userId);
        //actualStatus = userData.run();
        respSerID= userData.run();
        System.out.println("Step 5");
        System.out.println(respSerID);  */
        String body = "{\"email\":\"testforapi.i@mail.com\",\"firstName\":\"Alex9\",\"lastName\":\"Bor9\"}";
        SubStringSearcher.getSubString(body, Data.firstSubStrForUserMail,Data.secondSubStrForUserMail);
        //System.out.println(mail);

    }
}