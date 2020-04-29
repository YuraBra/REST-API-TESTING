package nasa.testData;

import java.util.HashMap;

public class TechPortData {


    public static final String id1 = "17766";
    public static final String id2 = "17767";
    public static final String id3 = "17756";
    public static final String id4 = "17759";

    public static final String title1 = "Integration of Tactical Departure Scheduling and Traffic Flow Management, Phase I";
    public static final String title2 = "Improved hyperspectral imaging technologies, Phase I";
    public static final String title3 = "ISS Launched Cubesat Demonstration of Variable-Drag Magnetoshell Aerocapture, Phase I";
    public static final String title4 = "Robust Voice Communication Understanding for Single-Pilot Operations, Phase I";

    HashMap<String, String> myHashMap;

    public TechPortData() {
        myHashMap = new HashMap<String, String>();
        myHashMap.put(id1,title1);
        myHashMap.put(id2,title2);
        myHashMap.put(id3,title3);
        myHashMap.put(id4,title4);

    }

    public String getTitle(String id){
        return myHashMap.get(id);
    }
}
