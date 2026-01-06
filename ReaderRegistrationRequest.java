public class ReaderRegistrationRequest extends Form {

    private int readerId;
    private String name;

    public ReaderRegistrationRequest(int readerId, String name) {
        super();
        this.readerId = readerId;
        this.name = name;
    }

    public int getReaderId() {
        return readerId;
    }

    public String getName() {
        return name;
    }
}
