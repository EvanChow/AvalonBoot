package com.avalon.service.sys;

import java.util.List;

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
        try {
            List<User> users=myBatisDao.getAllByEntity("UserMapper.findUserInfo", entity);
            if(users.size()>0){
                return users.get(0);
            }else{
                return new User();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new User();
    }
    
    
}
