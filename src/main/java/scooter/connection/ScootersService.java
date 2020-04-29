package scooter.connection;

import lombok.Getter;
import okhttp3.Request;
import scooter.data.Scooter;
import scooter.data.ScooterDto;
import scooter.util.RequestUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static scooter.data.Data.ADMIN_TOKEN;

@Getter
public class ScootersService extends BaseScooter {
    private RequestUtil requestUtil;
    private int responseCode;
    private String url;

    public final static String DECOMMISSIONED = "DECOMMISSIONED";

    public ScootersService() {
        requestUtil = new RequestUtil();
        this.url = this.baseUrl + "vehicle-service/scooters/";
    }

    public ScooterDto[] getAllScooters() throws IOException {
        Request request = requestUtil.getRequest(url, ADMIN_TOKEN);
        return requestUtil.getResponseAs(ScooterDto[].class, request);
    }

    public ScooterDto getScooterById(String scooterId) throws IOException {
        Request request = requestUtil.getRequest(url + scooterId, ADMIN_TOKEN);
        return requestUtil.getResponseAs(ScooterDto.class, request);
    }

    public String deleteScooterById(String scooterId) throws IOException {
        Request request = requestUtil.deleteRequest(url + scooterId, ADMIN_TOKEN);
        return requestUtil.getResponse(request);
    }

    public String getRandomScooterID() throws IOException {
        ScooterDto[] scooterDtos = getAllScooters();
        List<ScooterDto> scooterDtoList = Arrays.asList(scooterDtos);
        return scooterDtoList.get(new Random().nextInt(scooterDtoList.size())).getId();
    }

    public String getRandomActiveScooterId() throws IOException {
        List<ScooterDto> allScooters = Arrays.stream(getAllScooters())
                .filter(s -> !s.getStatus().equals(DECOMMISSIONED))
                .collect(Collectors.toList());
        return allScooters.get(new Random().nextInt(allScooters.size())).getId();
    }

    public String getScooterStatusById(String scooterId, String token) throws IOException {
        Request request = requestUtil.getRequest(url + "/status/" + scooterId, token);
        return requestUtil.getResponse(request);
    }

    public String addScooter(Scooter scooter) throws IOException {
        Request request = requestUtil.postRequest(url, scooter, ADMIN_TOKEN);
        return requestUtil.getResponse(request);
    }
}






