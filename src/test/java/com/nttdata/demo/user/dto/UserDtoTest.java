package com.nttdata.demo.user.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDtoTest {

    @Test
    void testUserDto_DefaultConstructor() {
        UserDto userDto = new UserDto();

        assertNull(userDto.getPrimerNombre());
        assertNull(userDto.getSegundoNombre());
        assertNull(userDto.getPrimerApellido());
        assertNull(userDto.getSegundoApellido());
        assertNull(userDto.getTelefono());
        assertNull(userDto.getDireccion());
        assertNull(userDto.getCiudad());
    }

    @Test
    void testUserDto_ConstructorWithValues() {

        String name = "Jose";
        String middleName = "Maria";
        String lastName = "Mendez";
        String secondSurname = "Morales";
        String phone = "3103101122";
        String address = "Calle 123 22 33";
        String city = "Bogota";

        UserDto userDto = new UserDto(
                "Jose",
                "Maria",
                "Mendez",
                "Morales",
                "3103101122",
                "Calle 123 22 33",
                "Bogota"
        );

        assertEquals(name, userDto.getPrimerNombre());
        assertEquals(middleName, userDto.getSegundoNombre());
        assertEquals(lastName, userDto.getPrimerApellido());
        assertEquals(secondSurname, userDto.getSegundoApellido());
        assertEquals(phone, userDto.getTelefono());
        assertEquals(address, userDto.getDireccion());
        assertEquals(city, userDto.getCiudad());
    }

    @Test
    void testUserDto_GettersAndSetters() {
        UserDto userDto = new UserDto();

        String newName = "Reinel";
        String newMiddleName = "Steven";
        String newLastName = "Bolaños";
        String newSecondSurname = "";  // Test empty string
        String newPhone = "3053101212";
        String newAddress = "Calle 123 no 55 55";
        String newCity = "Bogotá";

        userDto.setPrimerNombre(newName);
        userDto.setSegundoNombre(newMiddleName);
        userDto.setPrimerApellido(newLastName);
        userDto.setSegundoApellido(newSecondSurname);
        userDto.setTelefono(newPhone);
        userDto.setDireccion(newAddress);
        userDto.setCiudad(newCity);

        assertEquals(newName, userDto.getPrimerNombre());
        assertEquals(newMiddleName, userDto.getSegundoNombre());
        assertEquals(newLastName, userDto.getPrimerApellido());
        assertEquals(newSecondSurname, userDto.getSegundoApellido());  // Check for empty string
        assertEquals(newPhone, userDto.getTelefono());
        assertEquals(newAddress, userDto.getDireccion());
        assertEquals(newCity, userDto.getCiudad());
    }
}