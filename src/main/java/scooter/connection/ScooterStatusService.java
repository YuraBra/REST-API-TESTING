package scooter.connection;

import lombok.Getter;
import nasa.parsing.Parsing;
import okhttp3.Request;
import okhttp3.Response;
import scooter.data.ScooterDto;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static scooter.data.Data.ADMIN_TOKEN;

@Getter
public class ScooterStatusService extends BaseScooter {
    private int responseCode;
    private String url;

    public ScooterStatusService() {
        this.url = this.baseUrl + "vehicle-service/scooters/";
    }

    public String getAllScooters() throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + ADMIN_TOKEN)
                .build();

        try (Response response = client.newCall(request).execute()) {
            responseCode = response.code();
            return response.body().string();
        }
    }

    public String getScooterById(String scooterId) throws IOException {
        Request request = new Request.Builder()
                .url(url + scooterId)
                .addHeader("Authorization", "Bearer " + ADMIN_TOKEN)
                .build();

        try (Response response = client.newCall(request).execute()) {
            responseCode = response.code();
            return response.body().string();
        }
    }

    public String getRandomScooterID() throws IOException {
        Parsing parsing = new Parsing(ScooterDto[].class, getAllScooters());
        ScooterDto[] scooterDtos = (ScooterDto[]) parsing.parseDataFromJson();
        List<ScooterDto> scooterDtoList = Arrays.asList(scooterDtos);
        return scooterDtoList.get(new Random().nextInt(scooterDtoList.size())).getId();
    }
}






