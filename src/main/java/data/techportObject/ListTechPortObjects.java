package data.techportObject;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class ListTechPortObjects {

    private TechportObject project;

    public ListTechPortObjects(){

    }
    public ListTechPortObjects(String titleOfTechpoertProj){
        project.setTitle(titleOfTechpoertProj);
    }

}
