package model;

import java.util.regex.Pattern;

public record Client(String name, String surname, String address) {
    public Client {
        validateName(name);
        validateSurname(surname);
        validateAddress(address);
    }

    public static Client client1 = new Client("Jan", "Kowalski", "Warszawa");
    public static Client client2 = new Client("Piotr", "Nowak", "Kraków");
    public static Client client3 = new Client("Krzysztof", "Jerzyna", "Szczecin");

    private void validateName(String clientName) {
        if (clientName == null || clientName.isBlank() || clientName.length() == 0 || clientName.length() >= 50) {
            throw new IllegalArgumentException("Name must not be null, blank, empty, or exceed 50 characters.");
        }
        if (!Pattern.matches("^[a-zA-Z ]+$", clientName)) {
            throw new IllegalArgumentException("Name can only contain alphabetic characters and spaces.");
        }
    }

    private void validateSurname(String clientSurname) {
        if (clientSurname == null || clientSurname.isBlank() || clientSurname.length() == 0 || clientSurname.length() >= 50) {
            throw new IllegalArgumentException("Surname must not be null, blank, empty, or exceed 50 characters.");
        }
        if (!Pattern.matches("^[a-zA-Z ]+$", clientSurname)) {
            throw new IllegalArgumentException("Surname can only contain alphabetic characters and spaces.");
        }
    }

    private void validateAddress(String clientAddress) {
        if (clientAddress == null || clientAddress.isBlank() || clientAddress.length() == 0 || clientAddress.length() >= 50) {
            throw new IllegalArgumentException("Address must not be null, blank, empty, or exceed 50 characters.");
        }
        if (!Pattern.matches("^[a-zA-Z ]+$", clientAddress)) {
            throw new IllegalArgumentException("Address can only contain alphabetic characters and spaces.");
        }
    }
}
