package com.nttdata.demo.user.controller;

import com.nttdata.demo.user.dto.UserDto;
import com.nttdata.demo.user.entity.TypeDoc;
import com.nttdata.demo.user.services.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private IUserService userService;

    @Test
    void testUserDetail_UserFound() {
        UserDto userDto = new UserDto();
        when(userService.findByCc("23445322")).thenReturn(userDto);

        ResponseEntity<UserDto> response = userController.userDetail("23445322", TypeDoc.CC.getType());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userDto, response.getBody());
    }

    @Test
    void testUserDetail_UserNotFound() {
        when(userService.findByCc("23445322")).thenReturn(null);

        assertThrows(ResponseStatusException.class, () -> {
            userController.userDetail("23445322", TypeDoc.CC.getType() );
        });
    }

    @Test
    void testUserDetail_ServerError() {
        when(userService.findByCc("23445322")).thenThrow(new NullPointerException());

        assertThrows(ResponseStatusException.class, () -> {
            userController.userDetail("23445322", TypeDoc.CC.getType());
        });
    }
}