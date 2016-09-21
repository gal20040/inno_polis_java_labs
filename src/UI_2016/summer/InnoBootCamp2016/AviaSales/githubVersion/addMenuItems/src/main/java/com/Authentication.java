//package com;
//
//import com.db.Database;
//import com.entities.User;
//import com.exceptions.InvalidLoginException;
//import com.exceptions.InvalidPasswordException;
//import com.exceptions.LoginAlreadyOccupiedException;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class Authentication {
//
//    private static Database db;
//
//    public static boolean register(User user)
//        throws InvalidLoginException,
//            InvalidPasswordException,
//            LoginAlreadyOccupiedException
//    {
//        if (!isLoginValid(user.getLogin())) throw new InvalidLoginException();
//        if (!isPasswordValid(user.getPassword())) throw new InvalidPasswordException();
//        if (isUserExist(user)) throw new LoginAlreadyOccupiedException();
//
//        db.registerUser(user);
//        Menu.setCurrentUser(user);
//
//        return true;
//    }
//
//    public static boolean login(User user)
//            throws InvalidLoginException,
//            InvalidPasswordException
//    {
//        user = db.getUser(user);
//        Menu.setCurrentUser(user);
//        return true;
//    }
//
//    public static boolean logout(User user) {
//        Menu.setCurrentUser(null);
//        return true;
//    }
//
//    public static void setDb(Database db) {
//        Authentication.db = db;
//    }
//
//    private static boolean isUserExist(User user) throws InvalidPasswordException, InvalidLoginException {
//        return !(db.getUser(user) == null);
//    }
//
//    private static boolean isLoginValid(String login){
//        Pattern p = Pattern.compile("[a-zA-Z]{5}.{0,10}");
//        Matcher m = p.matcher(login);
//        return m.matches();
//    }
//
//    private static boolean isPasswordValid(String password){
//        Pattern p = Pattern.compile("^[a-zA-Z]\\w{8,14}$");
//        Matcher m = p.matcher(password);
//        return m.matches();
//    }
//
//}
