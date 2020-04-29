package scooter.test;

import org.junit.Before;
import org.junit.Test;
import scooter.connection.ActivateAccount;
import scooter.connection.SignIn;
import scooter.connection.SignUp;
import scooter.connection.UserData;
import scooter.data.UserDataDto;

import java.io.IOException;
import java.util.Objects;

public class TestForUserData {
    UserDataDto userDataDto;
    String activateToken;
    @Before
    public void createUser(){
        userDataDto = new UserDataDto("dp184taqc@gmail.com","qwerty","Engineer","QA");
    }
    @Test
    public void setUpUser(){
        SignUp signUp = new SignUp();

        try{
            activateToken = signUp.getResponse(userDataDto);
            System.out.println("Step 1");
            System.out.println(activateToken);
        }catch (IOException e){ }                   // + Assert & Exception
    }
    @Test
    public void activateUser(){
        ActivateAccount acc = new ActivateAccount();
        try{
            int actualCode = acc.run(activateToken.replace("\"", ""));
            System.out.println("Step 2");
            System.out.println(actualCode);
        }catch (IOException e) { }                   // + Assert & Exception
    }
    @Test
    public void singInUser(){
        // SingIn
        SignIn signIn = new SignIn();
        try {
            String bearerCode = Objects.requireNonNull(signIn.getResponse("dp184taqc@gmail.com", "qwerty")
                    .header("Authorization")).replace("Bearer ", "");
            System.out.println("Step 3");
            System.out.println(bearerCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getUserIdFromDecodedToken(){

        System.out.println("Step 4");
        //System.out.println(UserID);
        return null;
    }

    @Test
    public void getUserData(){
        int actualStatus;
        String userId = getUserIdFromDecodedToken();
        UserData userData = new UserData(userId);
        try {
            actualStatus = userData.run();
            System.out.println("Step 5");
            System.out.println(actualStatus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*private int actualStatus;
    private boolean isRandEmail = true;
    UserDataDto userDataDto;
    @Before
    public void setUp(){
        userDataDto = new UserDataDto("dp184taqc@gmail.com","qwerty","Engineer","QA");
        SignUp signUp = new SignUp();
        try{
            userDataDto.setId(signUp.getResponse(userDataDto,isRandEmail));
            System.out.println("Step 1");
            //System.out.println(userDataDto.getEmail());
            System.out.println(userDataDto.getId());
        }catch (IOException e){ }
        ActivateAccount acc = new ActivateAccount();
        try{
            int actualCode = acc.run(userDataDto.getId().replace("\"", ""));
            System.out.println("Step 2");
            System.out.println(actualCode);
        }catch (IOException e) { }
    }

    @Test
    public void testForGetUserData(){

        // проверить в БД нет ли такого userDataDto, если есть очистить
        // создать юзера
        // зарегистрировать юзер
        // получить его ID
        // админ запрос на его данніе

        UserData userData = new UserData(userDataDto.getId());// (userDataDto.getID)
        try {
            System.out.println(actualStatus = userData.run());
        } catch (IOException e) {
        }

    }*/

}
