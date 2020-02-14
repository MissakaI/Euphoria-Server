package lk.ac.cmb.ucsc.euphoria.repository;

import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<LoginCredentials, Long> {
    LoginCredentials getLoginCredentialsByUsername(String username);
}
