import java.time.LocalDate;

public abstract class Form {

    private LocalDate submittedDate;
    private FormStatus status;

    protected Form() {
        this.submittedDate = LocalDate.now();
        this.status = FormStatus.SUBMITTED;
    }

    public LocalDate getSubmittedDate() {
        return submittedDate;
    }

    public FormStatus getStatus() {
        return status;
    }

    public void approve() {
        status = FormStatus.APPROVED;
    }

    public void reject() {
        status = FormStatus.REJECTED;
    }
}
