public class Manager {
    private String name;
    private String family;
    private long id;
    private int personCode;


    public String getName(String name) {
        this.name = name;
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getFamily(String family) {
    this.family = family;
    return family;
    }

    public void setFamily(){
        this.family=family;
    }

    public long getId(long id)
    {
        this.id=id;
        return id;
    }

    public void setId(){
        this.id=id;
    }

    public int getPersonCode(int personCode)
    {
        this.personCode=personCode;
        return personCode;
    }

    

}
