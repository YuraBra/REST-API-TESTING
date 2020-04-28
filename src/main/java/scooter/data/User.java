package scooter.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
