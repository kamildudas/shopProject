package model;

import java.util.regex.Pattern;

/* do zrobienia:

-orderNumber| String | losowo generowany ciąg 8 znaków

-orderSum | double | wartość większa od 0.

-orderStatus | Enum | oplacone, anulowane, wysłane,
w przygotowaniu

-products | Map<model.Product, Integer> | wartość > 0
*/
public class Order {
    private static int lastOrderId = 0;
    private final int orderId;
    private String orderNumber;
    private double orderSum;
    private String clientName;
    private String clientSurname;
    private String clientAddress;
    private Enum orderStatus;

    public Order(String orderNumber, double orderSum, String clientName, String clientSurname, String clientAddress, Enum orderStatus) {
        lastOrderId++;
        this.orderId = lastOrderId;
        this.orderNumber = orderNumber;
        this.orderSum = orderSum;
        validateClientName(clientName);
        validateClientSurname(clientSurname);
        this.clientAddress = clientAddress;
        this.orderStatus = orderStatus;
    }

    private void validateClientName(String clientName) {
        if (clientName == null || clientName.isBlank() || clientName.length() == 0 || clientName.length() >= 50) {
            throw new IllegalArgumentException("Name must not be null, blank, empty, or exceed 50 characters.");
        }
        if (!Pattern.matches("^[a-zA-Z ]+$", clientName)) {
            throw new IllegalArgumentException("Name can only contain alphabetic characters and spaces.");
        }
    }
    private void validateClientSurname(String clientSurname) {
        if (clientSurname == null || clientSurname.isBlank() || clientSurname.length() == 0 || clientSurname.length() >= 50) {
            throw new IllegalArgumentException("Surname must not be null, blank, empty, or exceed 50 characters.");
        }
        if (!Pattern.matches("^[a-zA-Z ]+$", clientSurname)) {
            throw new IllegalArgumentException("Surname can only contain alphabetic characters and spaces.");
        }
    }
    private void validateClientAddress(String clientAddress) {
        if (clientAddress == null || clientAddress.isBlank() || clientAddress.length() == 0 || clientAddress.length() >= 50) {
            throw new IllegalArgumentException("Address must not be null, blank, empty, or exceed 50 characters.");
        }
        if (!Pattern.matches("^[a-zA-Z ]+$", clientAddress)) {
            throw new IllegalArgumentException("Address can only contain alphabetic characters and spaces.");
        }
    }
}