public class Manager {

   private String name;
   private String family;
   private Long id;


    public String getName() {
        return name;
    }

    public Manager setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Manager setFamily(String family) {
        this.family = family;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Manager setId(Long id) {
        this.id = id;
        return this;
    }
}
