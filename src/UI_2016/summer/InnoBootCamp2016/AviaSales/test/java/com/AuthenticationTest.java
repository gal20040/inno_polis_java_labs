package com;

import com.db.Database;
import com.entities.User;
import com.exceptions.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticationTest {

    @Test(expected = InvalidLoginException.class)
    public void registerUserWithInvalidLogin() throws AbstractAuthException {
        User testUser = new User("111", "12345678");
        Authentication.register(testUser);
    }

    @Test(expected = InvalidPasswordException.class)
    public void registerUserWithInvalidPassword() throws AbstractAuthException {
        User testUser = new User("Abcdefg", "12345");
        Authentication.register(testUser);
    }

    @Test(expected = LoginAlreadyOccupiedException.class)
    public void registerAlreadyExistUser() throws AbstractAuthException {
        User testUser = new User("Abcdefg", "Zz10102015");
        Database db = mock(Database.class);
        Authentication.setDb(db);
        when(db.getUser(testUser)).thenReturn(testUser);

        Authentication.register(testUser);
    }

    @Test
    public void registerUserWithValidData() throws AbstractAuthException {
        User testUser = new User("Abcdefg", "Zz10102015");
        Database db = mock(Database.class);
        Authentication.setDb(db);

        when(db.getUser(testUser)).thenReturn(null);
        when(db.registerUser(testUser)).thenReturn(true);

        Authentication.register(testUser);
        assertEquals(testUser, Menu.getCurrentUser());
    }

    @Test
    public void loginWithCorrectUser() throws Exception {
        User testUser = new User("Abcdefg", "Zz16062016");
        Database db = mock(Database.class);
        Authentication.setDb(db);
        when(db.getUser(testUser)).thenReturn(testUser);

        Authentication.login(testUser);

        assertEquals(testUser, Menu.getCurrentUser());
    }

    @Test
    public void loginWithIncorrectLogin() throws Exception {
        User testUser = new User("1", "Zz16062016");
        Database db = mock(Database.class);
        Authentication.setDb(db);

        when(db.getUser(testUser)).thenReturn(null);
        Authentication.login(testUser);

        assertEquals(null, Menu.getCurrentUser());
    }

    @Test
    public void loginWithIncorrectPassword() throws Exception {
        User testUser = new User("Abcdefg", "1");
        Database db = mock(Database.class);
        Authentication.setDb(db);

        when(db.getUser(testUser)).thenReturn(null);
        Authentication.login(testUser);

        assertEquals(null, Menu.getCurrentUser());
    }

    @Test
    public void logout() throws Exception {
        User testUser = new User("Abcdefg", "Zz16062016");
        Database db = mock(Database.class);
        Authentication.setDb(db);
        when(db.getUser(testUser)).thenReturn(testUser);

        Authentication.login(testUser);

        Authentication.logout(testUser);
        assertEquals(null, Menu.getCurrentUser());
    }

}