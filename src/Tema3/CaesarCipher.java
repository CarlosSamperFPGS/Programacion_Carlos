package Tema3;
// Cifrado de julio cesar con 3 funciones: encrypt (cifrar), decrypt (descifrar) y main.
// Julio Cesar inventó un cifrado para que los mensajes puedan ser leidos por cualquiera
// ---------------------------------------------------------------------------------------------------------------------
// REGLAS
// ---------------------------------------------------------------------------------------------------------------------
// 1. Todos los caracteres del mensaje deben tener sus letras en mayúsculas
// 2. Se reemplaza cada letra por la siguiente del abecedario, excepto la Z que se reemplaza por la A
// 3. Se reemplaza cada dígito por el siguiente dígito, excepto el 9, que se reemplaza por 0.
// 4. El resto de caracteres no se reemplazan
// 5. No usar StringBuilder;

public class  CaesarCipher {

    public static String encrypt(String message) {
        String encryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isUpperCase(ch)) {
                if (ch == 'Z') {
                    encryptedMessage += 'A';
                } else {
                    encryptedMessage += (char) (ch + 1);
                }
            } else if (Character.isDigit(ch)) {
                if (ch == '9') {
                    encryptedMessage += '0';
                } else {
                    encryptedMessage += (char) (ch + 1);
                }
            } else {
                encryptedMessage += ch;
            }
        }
        return encryptedMessage;
    }

    public static String decrypt(String encryptedMessage) {
        String decryptedMessage = "";
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char ch = encryptedMessage.charAt(i);
            if (Character.isUpperCase(ch)) {
                if (ch == 'A') {
                    decryptedMessage += 'Z';
                } else {
                    decryptedMessage += (char) (ch - 1);
                }
            } else if (Character.isDigit(ch)) {
                if (ch == '0') {
                    decryptedMessage += '9';
                } else {
                    decryptedMessage += (char) (ch - 1);
                }
            } else {
                decryptedMessage += ch;
            }
        }
        return decryptedMessage;
    }

    public static void main(String[] args) {
        String originalMessage = "HELLO WORLD 123";
        String encrypted = encrypt(originalMessage);
        String decrypted = decrypt(encrypted);

        System.out.println("Original: " + originalMessage);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
