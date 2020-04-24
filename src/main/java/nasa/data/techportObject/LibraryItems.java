package nasa.data.techportObject;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class LibraryItems {

    private Integer id;
    private String title;
    private String type;
    private String description;
    private String externalUrl;
    private String publishedBy;
    private String publishedDate;      // Integer ???
    private List<Files> files;





}
