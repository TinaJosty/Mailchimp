package stepDefinitions;

import java.util.Random;



public class Generate {


    //************ Random input ***********
    public String randomEmail(int lenght) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        long timeStamp = time();
        Random rnd = new Random();
        StringBuilder email = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++)
            email.append(chars.charAt(rnd.nextInt(chars.length())));
        email.append(time());
        return email.toString()+"@emailen.com";

    }


    public String randomUserName(int lenght){
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        Random rnd = new Random();
        StringBuilder userName = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++)
            userName.append(chars.charAt(rnd.nextInt(chars.length())));

        return userName.toString();
    }



    public String randomUpperCase(int lenght) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random rnd = new Random();
        StringBuilder upperCase = new StringBuilder(lenght);

        for (int i = 0; i < lenght; i++)
            upperCase.append(chars.charAt(rnd.nextInt(chars.length())));
        return upperCase.toString();

    }

    public String randomLowerCase(int lenght) {
        String chars = "abcdefghijklmnopqrstuvwxyz";

        Random rnd = new Random();
        StringBuilder lowerCase = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++)
            lowerCase.append(chars.charAt(rnd.nextInt(chars.length())));
        return lowerCase.toString();

    }

    public String randomNumbers(int lenght) {
        String chars = "0123456789";
        Random rnd = new Random();
        StringBuilder numbers_Signs = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++)
            numbers_Signs.append(chars.charAt(rnd.nextInt(chars.length())));
        return numbers_Signs.toString();

    }

    public String randomSigns(int lenght) {
        String chars = "#&/*+-!";
        Random rnd = new Random();
        StringBuilder signs = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++)
            signs.append(chars.charAt(rnd.nextInt(chars.length())));
        return signs.toString();

    }
// TimeStamp used for email
    public long time(){

        long timeStamp = System.currentTimeMillis() / 1000;
        return timeStamp;

    }

}

