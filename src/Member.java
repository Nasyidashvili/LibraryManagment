public class Member {
    private String id;
    private String name;
    private String email;

    public Member(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String toCsv() {
        return id + "," + name + "," + email;
    }

    public static Member fromCsv(String line) {
        String[] parts = line.split(",");
        return new Member(parts[0], parts[1], parts[2]);
    }

    @Override
    public String toString() {
        return "[" + id + "]" + name + " | " + email;
    }
}
