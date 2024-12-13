package com.nttdata.demo.user.services;

import com.nttdata.demo.user.dto.UserDto;

public interface IUserService {
   UserDto findByCc(String cc);
}
