package gino.desiigner.genbuild_billing_system.service;

import gino.desiigner.genbuild_billing_system.io.UserRequest;
import gino.desiigner.genbuild_billing_system.io.UserResponse;

import java.util.List;

public interface UserService {

   UserResponse createUser(UserRequest request);

   String getUserRole(String email);

   List<UserResponse> readUsers();

   void deleteUser(String id);
}
