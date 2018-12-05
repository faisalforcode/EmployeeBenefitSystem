package com.ebs.domaininterfaces;

import java.io.IOException;

import com.ebs.domain.User;

public interface LoginInterface {

	User login(String username, String pwd) throws IOException;

}