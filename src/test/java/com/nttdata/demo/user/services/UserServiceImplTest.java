package com.nttdata.demo.user.services;

import com.nttdata.demo.user.UserMock;
import com.nttdata.demo.user.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserMock userDao;

    @Test
    void testFindByCc_UserFound() {
        UserDto user = new UserDto(
                "Jose",
                "Maria",
                "Mendez",
                "Morales",
                "3103101122",
                "Calle 123 22 33",
                "Bogota"
        );


        UserDto userDto = userServiceImpl.findByCc("23445322");

        assertNotNull(userDto);
        assertEquals(user.getPrimerNombre(), userDto.getPrimerNombre());

    }

    @Test
    void testFindByCc_UserNotFound() {
        UserDto userDto = userServiceImpl.findByCc("nonexistentCC");
        assertNull(userDto);
    }
}