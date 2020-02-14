package lk.ac.cmb.ucsc.euphoria.service;

import lk.ac.cmb.ucsc.euphoria.dto.CounselorRequestDTO;
import lk.ac.cmb.ucsc.euphoria.model.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

public interface UserService {
    void addPost(Post post);

    void addRequest(Request request);

    List<User> signIn(Password password);

    boolean quickSignUp(User user);

    boolean formalSignUp(User user);

    List<Counselor> getCounselors();

    ResponseEntity<Boolean> requestCounselor(@Valid CounselorRequestDTO counselorRequest);
}
