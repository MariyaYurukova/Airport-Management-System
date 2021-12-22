package airportmanagement.system.domain.models.views;

public class PlaneViewModel {

    private String id;
    private String codeName;


    public PlaneViewModel() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}
