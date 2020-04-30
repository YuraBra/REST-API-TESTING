package nasa.testData;

import java.util.HashMap;

public class TechPortData {


    public static final String id1 = "17766";
    public static final String id2 = "17767";
    public static final String id3 = "17756";
    public static final String id4 = "17759";

    private String title1 = "Integration of Tactical Departure Scheduling and Traffic Flow Management, Phase I";
    private String title2 = "Improved hyperspectral imaging technologies, Phase I";
    private String title3 = "ISS Launched Cubesat Demonstration of Variable-Drag Magnetoshell Aerocapture, Phase I";
    private String title4 = "Robust Voice Communication Understanding for Single-Pilot Operations, Phase I";

    HashMap<String, String> mapTitles;

    public TechPortData() {
        mapTitles = new HashMap<>();
        mapTitles.put(id1,title1);
        mapTitles.put(id2,title2);
        mapTitles.put(id3,title3);
        mapTitles.put(id4,title4);

    }

    public String getTitle(String id){
        return mapTitles.get(id);
    }
}
