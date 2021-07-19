package com.spe.mncManagement.dao;

import com.spe.mncManagement.bean.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface LoginDao extends JpaRepository<Credentials, Long> {
    Credentials findByUsernameEqualsAndPasswordEquals(String username, String password);

    Credentials findByUsernameEquals(String username);

    void deleteCredentialsByEmpId(Long empId);
}
