package scooter.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

//@Getter
//@AllArgsConstructor
public class UserDataDto {

    private String id;
    private String activationToken;
    private String email;
    private String password;
    private String firstName;
    private String lastName;


    public UserDataDto(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
