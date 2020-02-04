package services;

public class NotValidePrescriptionException extends Exception {
    public NotValidePrescriptionException(String message) {
        super(message);
    }
}
