package com.nttdata.demo.user.services;

import com.nttdata.demo.user.dao.UserDao;
import com.nttdata.demo.user.dto.UserDto;
import com.nttdata.demo.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Override
    public UserDto findByCc(String cc) {
        User user = UserDao.findByCc(cc);
        if(user == null){
            return null;
        }
        return new UserDto(
                user.getName(),
                user.getMiddleName(),
                user.getLastName(),
                user.getSecondSurname(),
                user.getPhone(),
                user.getAddress(),
                user.getCity()
                );
    }

}
