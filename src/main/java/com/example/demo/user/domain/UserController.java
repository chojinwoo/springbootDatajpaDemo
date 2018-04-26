package com.example.demo.user.domain;

import com.example.demo.auth.entity.AuthEntity;
import com.example.demo.common.CommonUtil;
import com.example.demo.user.entity.UsersEntity;
import com.example.demo.user.entity.UsersRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping( value="/user", method = RequestMethod.GET)
    public String getUsers(Model model) {
        Gson gson = new Gson();
        Optional<UsersEntity> ue = usersRepository.findById("bangae1");
        System.out.println(CommonUtil.getApiKey());
        return gson.toJson(ue);
    }

    @RequestMapping(value="/user", method = RequestMethod.PUT)
    public String insUsers(@ModelAttribute UsersEntity usersEntity, @ModelAttribute AuthEntity authEntity) {
        int cnt = usersRepository.findByIdAndApiKey(usersEntity, authEntity);
        System.out.println(cnt);
        return null;
    }
}
