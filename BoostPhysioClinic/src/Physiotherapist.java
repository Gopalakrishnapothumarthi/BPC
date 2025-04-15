import java.util.List;

public class Physiotherapist {
    private int id;
    private String name;
    private String address;
    private String contactInfo;
    private List<String> areasOfExpertise;

    public Physiotherapist(int id, String name, String address, String contactInfo, List<String> expertise) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.areasOfExpertise = expertise;
    }

    public String getName() {
        return name;
    }
}
