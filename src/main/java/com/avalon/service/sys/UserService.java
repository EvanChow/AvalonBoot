package com.avalon.service.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avalon.dao.MyBatisDao;
import com.avalon.entity.sys.User;

@Service
public class UserService {
    
    @Autowired
    private MyBatisDao<User> myBatisDao;
     
    
    public User getUserInfo(String uid){
        User entity=new User();
        entity.setUid(uid);
        System.out.println(uid);
        try {
            return myBatisDao.getAllByEntity("UserMapper.findUserInfo", entity).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new User();
    }
    
    
}
