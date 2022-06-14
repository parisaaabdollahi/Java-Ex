public class Manager {
    private String name;
    private String family;
    private Long id;

    public String getName() {
        System.out.println("name get shod");
        return name;
    }

    public void setName(String name) {
        System.out.println("name set shod");
        this.name = name;
    }

    public String getFamily() {
        System.out.println("family get shod");
        return family;
    }

    public void setFamily(String family) {
        System.out.println("family set shod");
        this.family = family;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}