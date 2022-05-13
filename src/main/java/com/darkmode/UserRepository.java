package com.darkmode;

import org.springframework.data.repository.CrudRepository;
import com.darkmode.models.*;

public interface UserRepository extends CrudRepository<User,Long> {

}

