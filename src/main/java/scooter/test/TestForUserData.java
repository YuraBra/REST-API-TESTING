package scooter.test;

import org.junit.Test;
import scooter.connection.SignUp;
import scooter.connection.UserData;
import scooter.data.User;

import java.io.IOException;

public class TestForUserData {
    private int actualStatus;
    private boolean isRandEmail = true;
    String userID;

    @Test
    public void testForGetUserData(){

        // проверить в БД нет ли такого user, если есть очистить
        // создать юзера
        // зарегистрировать юзер
        // получить его ID
        // админ запрос на его данніе

        //User user = new User();
        User user = new User("dp184taqc@gmail.com","qwerty","Engineer","QA");
        //user.setId("9a27f6c9-3744-44a6-98ef-ef8d176dc262");

        SignUp signUp = new SignUp();
        try{
            userID = signUp.getResponse(user,isRandEmail);
            // user.setID(userID) = signUp.getResponse(user,isRandEmail);
        }catch (IOException e){

        }

        UserData userData = new UserData(userID);// (user.getID)
        try {
            actualStatus = userData.run();
        } catch (IOException e) {

        }

    }

}
