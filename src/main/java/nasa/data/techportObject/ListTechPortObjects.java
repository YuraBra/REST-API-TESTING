package nasa.data.techportObject;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ListTechPortObjects {

    private TechportObject project;

    public ListTechPortObjects(){

    }
    public TechportObject getProject(){
        return project;
    }

}
