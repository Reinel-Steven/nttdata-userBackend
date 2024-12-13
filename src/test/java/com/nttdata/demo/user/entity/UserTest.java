package com.nttdata.demo.user.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUser() {
        User user = new User();

        // Test default values
        assertEquals(0, user.getId());
        assertNull(user.getDoc());
        assertNull(user.getName());
        assertNull(user.getMiddleName());
        assertNull(user.getLastName());
        assertNull(user.getSecondSurname());
        assertNull(user.getPhone());
        assertNull(user.getAddress());
        assertNull(user.getCity());

        // Test setter and getter methods
        user.setId(1);
        user.setDoc("1013623647");
        user.setName("Reinel");
        user.setMiddleName("Steven");
        user.setLastName("Bolaños");
        user.setSecondSurname("Martinez");
        user.setPhone("3184090989");
        user.setAddress("Calle 123 22 33");
        user.setCity("Bogota");

        assertEquals(1, user.getId());
        assertEquals("1013623647", user.getDoc());
        assertEquals("Reinel", user.getName());
        assertEquals("Steven", user.getMiddleName());
        assertEquals("Bolaños", user.getLastName());
        assertEquals("Martinez", user.getSecondSurname());
        assertEquals("3184090989", user.getPhone());
        assertEquals("Calle 123 22 33", user.getAddress());
        assertEquals("Bogota", user.getCity());
    }
}