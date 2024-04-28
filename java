public class CreditCardValidator {
    public static boolean validateCreditCard(String cardNumber) {
        // Remove non-numeric characters
        String cleanCardNumber = cardNumber.replaceAll("[^0-9]", "");

        // Check if the number is of valid length
        if (cleanCardNumber.length() < 13 || cleanCardNumber.length() > 19) {
            return false;
        }

        // Reverse the number
        StringBuilder reversedNum = new StringBuilder(cleanCardNumber).reverse();

        // Double every second digit
        StringBuilder doubledNum = new StringBuilder();
        for (int i = 0; i < reversedNum.length(); i++) {
            int digit = Character.getNumericValue(reversedNum.charAt(i));
            if (i % 2 == 1) {
                int doubledDigit = digit * 2;
                if (doubledDigit > 9) {
                    doubledDigit -= 9;
                }
                doubledNum.append(doubledDigit);
            } else {
                doubledNum.append(digit);
            }
        }

        // Sum all the digits
        int sumDigits = 0;
        for (int i = 0; i < doubledNum.length(); i++) {
            sumDigits += Character.getNumericValue(doubledNum.charAt(i));
        }

        // Check if the sum is divisible by 10
        return sumDigits % 10 == 0;
    }

    public static void main(String[] args) {
        String cardNumber = "1234 5678 9012 3456"; // Replace this with your credit card number
        if (validateCreditCard(cardNumber)) {
            System.out.println("Credit card is valid.");
        } else {
            System.out.println("Credit card is invalid.");
        }
    }
}
