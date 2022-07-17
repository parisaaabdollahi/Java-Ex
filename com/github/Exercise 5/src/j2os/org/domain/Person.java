package j2os.org.domain;

public class Person {
    private Long id;
    private String name;
    private String family;
    private Long sin;

    public Long getId() {
        return id;
    }

    public Person setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }

    public Long getSin() {
        return sin;
    }

    public Person setSin(Long sin) {
        this.sin = sin;
        return this;
    }
}

