package data.techportObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

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


    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TechportObject that = (TechportObject) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
    

}
