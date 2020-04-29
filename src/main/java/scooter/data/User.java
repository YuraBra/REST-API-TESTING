package scooter.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor
public class User {

    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;


    public User(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
