package nasa.data.techportObject;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString

public class TechportObject {

    private Integer id;
    private String lastUpdated;       // TODO change to date
    private String title;
    private String status;
    private String startDate;       // TODO change to date
    private String endDate;       // TODO change to date
    private String description;
    private String benefits;
    private String technologyMaturityStart;        // Integer ???
    private String technologyMaturityCurrent;        // Integer ???
    private String technologyMaturityEnd;        // Integer ???
    private String responsibleProgram;
    private String responsibleMissionDirectorateOrOffice;
    private LeadOrganization leadOrganization;
    private List<String> workLocations;
    private List<String> programDirectors;
    private List<String> programManagers;
    private List<String> projectManagers;
    private List<String> principalInvestigators;
    private List<LibraryItems> libraryItems;
    private List<String> closeoutDocuments;
    private List<SupportingOrganizations> supportingOrganizations;
    private List<PrimaryTas> primaryTas;
    private List<AdditionalTas> additionalTas;

    public String getTitle(){
        return  title;
    }

}
