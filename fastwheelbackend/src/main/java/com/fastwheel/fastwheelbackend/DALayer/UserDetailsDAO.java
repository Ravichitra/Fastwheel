package com.fastwheel.fastwheelbackend.DALayer;

import com.fastwheel.fastwheelbackend.model.UserDetails;

public interface UserDetailsDAO {
boolean CreateUserDetails(UserDetails userdetails);
boolean UpdateUserDetails(UserDetails userdetails);
boolean DeleteUserDetails(UserDetails userdetails);
UserDetails SelectUser(String emailID);
}
