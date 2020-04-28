package scooter.data;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserLoginDTO {
    private String email;
    private String password;
}
