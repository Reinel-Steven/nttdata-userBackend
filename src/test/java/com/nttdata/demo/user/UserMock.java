package com.nttdata.demo.user;

import com.nttdata.demo.user.dto.UserDto;

public class UserMock {
    public UserDto findByCc(String cc) {
        if (cc.equalsIgnoreCase("23445322")) {
            return new UserDto(
                    "Jose",
                    "Maria",
                    "Mendez",
                    "Morales",
                    "3103101122",
                    "Calle 123 22 33",
                    "Bogota"
            );
        }

        return null;
    }
}
