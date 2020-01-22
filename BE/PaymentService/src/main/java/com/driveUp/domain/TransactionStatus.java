package softserve.academy.domain;

public enum TransactionStatus {
    inProgress("inProgress"),
    successful("successful"),
    unsuccessful("unsuccessful");

    private String status;

    TransactionStatus(String status) {
        this.status = status;
    }

    String getStatus() {
        return status;
    }
}
