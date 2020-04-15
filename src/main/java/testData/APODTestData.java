package testData;

import data.APODObject;

public abstract class APODTestData {
    public static final String data1 = "";
    public static final  String data2 = "2020-04-12";
    public static final  String data3 = "2020-03-15";
    public static final  String data4 = "2019-12-13";

    public static final APODObject apod1 = new APODObject();
    public static final APODObject apod2 = new APODObject(data2);
    public static final APODObject apod3 = new APODObject(data3);
    public static final APODObject apod4 = new APODObject(data4);


}
