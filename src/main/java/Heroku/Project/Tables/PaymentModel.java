package Heroku.Project.Tables; // Adjust the package name as per your project structure

public enum PaymentModel {
    ONETIME,
    SUBSCRIPTION;

    @Override
    public String toString() {
        switch (this) {
            case ONETIME:
                return "onetime";
            case SUBSCRIPTION:
                return "subscription";
            default:
                throw new IllegalArgumentException("Unknown value: " + this);
        }
    }

    public static PaymentModel fromString(String value) {
        switch (value) {
            case "onetime":
                return ONETIME;
            case "subscription":
                return SUBSCRIPTION;
            default:
                throw new IllegalArgumentException("Unknown value: " + value);
        }
    }
}
