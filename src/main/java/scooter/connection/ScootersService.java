package scooter.connection;

import lombok.Getter;
import nasa.parsing.Parsing;
import okhttp3.Request;
import okhttp3.Response;
import scooter.data.ScooterDto;
import scooter.util.RequestUtil;
import scooter.util.ScooterType;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static scooter.data.Data.*;

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
        Request request = requestUtil.deleteRequest(url + scooterId, ADMIN_TOKEN, "{}");
        return requestUtil.getResponse(request).replace("\"", "");
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
        return requestUtil.getResponse(request).replace("\"", "");
    }

    public ScooterDto getScooterById(String scooterId, String token) throws IOException {
        Request request = requestUtil.getRequest(url + "/" + scooterId, token);
        return requestUtil.getResponseAs(ScooterDto.class, request);
    }

    public String getNewScooterById() throws IOException {
        ScooterDto scooterPayload = new ScooterDto();
        scooterPayload.setModelName(TEST_MODEL_NAME);
        scooterPayload.setSerialNumber(TEST_SERIAL_NUMBER);
        Request request = requestUtil.postRequest(url, scooterPayload, ADMIN_TOKEN);
        return requestUtil.getResponse(request).replace("\"", "");
    }

    public String getNewStatusScooterById(String scooterId, ScooterType scooterType) throws IOException {
        Request request = requestUtil.putRequest(url + "/status/" + scooterId + "/" + scooterType,
                EMPTY_JSON_OBJ,
                ADMIN_TOKEN);
        return requestUtil.getResponse(request);
    }
}






