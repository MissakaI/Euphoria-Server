package lk.ac.cmb.ucsc.euphoria.service.impl;


import lk.ac.cmb.ucsc.euphoria.dto.CounselorRequestDTO;
import lk.ac.cmb.ucsc.euphoria.model.*;
import lk.ac.cmb.ucsc.euphoria.repository.*;
import lk.ac.cmb.ucsc.euphoria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import lk.ac.cmb.ucsc.euphoria.repository.PasswordRepository;
import lk.ac.cmb.ucsc.euphoria.repository.RequestRepository;
import lk.ac.cmb.ucsc.euphoria.repository.UserRepository;
import lk.ac.cmb.ucsc.euphoria.model.Password;
import lk.ac.cmb.ucsc.euphoria.model.Post;
import lk.ac.cmb.ucsc.euphoria.model.Request;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RequestRepository requestRepository;
    private final PasswordRepository passwordRepository;
    private final CounselorRepository counselorRepository;
    private final CounselorRequestRepository counselorRequestRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RequestRepository requestRepository,
                           PasswordRepository passwordRepository, CounselorRepository counselorRepository,
                           CounselorRequestRepository counselorRequestRepository) {
        this.userRepository = userRepository;
        this.requestRepository = requestRepository;
        this.passwordRepository = passwordRepository;
        this.counselorRepository = counselorRepository;
        this.counselorRequestRepository = counselorRequestRepository;
    }

    @Override
    public void addPost(Post post) {
    }

    @Override
    public void addRequest(Request request) {
        requestRepository.save(request);
    }

    @Override
    public List<User> signIn(Password password) {
        String email = password.getEmail();
        Optional<Password> existing = passwordRepository.findById(email);
        if (existing.isPresent()) {
            return null;
        }
        Password temp = existing.get();
        if (temp.getPassword().equals(password.getPassword())) {
            return userRepository.findByEmail(email);
        } else {
            return null;
        }
    }

    @Override
    public boolean quickSignUp(User user) {
        Optional<Password> existing = passwordRepository.findById(user.getEmail());
        if (existing.isPresent()) {
            Password temp = new Password(user.getEmail(), user.getPassword());
            Password pw = passwordRepository.save(temp);
            User us = userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    /*
        TODO : can use this later when the user decides to  fill in the formal data
     */
    @Override
    public boolean formalSignUp(User user) {
        Optional<Password> existing = passwordRepository.findById(user.getEmail());
        if (existing.isPresent()) {
            Password temp = new Password(user.getEmail(), user.getPassword());
            Password pw = passwordRepository.save(temp);
            User us = userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Counselor> getCounselors() {
        Iterable<Counselor> all = counselorRepository.findAll();
        List<Counselor> counselorList = new ArrayList<Counselor>();
        all.forEach(counselorList::add);
        return counselorList;
    }

    @Override
    public ResponseEntity<Boolean> requestCounselor(@Valid CounselorRequestDTO counselorRequest) {
        Counselor counselor = new Counselor();
        counselor.setCounselor_id(counselorRequest.getCounselor_id());

        User user = new User();
        user.setUid(counselorRequest.getUser_id());

        CounselorRequestIdentity id = new CounselorRequestIdentity();
        id.setCounselor_id(counselor);
        id.setUser_id(user);

        CounselorRequest temp = counselorRequestRepository.save(new CounselorRequest(id, counselorRequest.getRequest_description()));
        return ResponseEntity.ok(true);
    }

}
