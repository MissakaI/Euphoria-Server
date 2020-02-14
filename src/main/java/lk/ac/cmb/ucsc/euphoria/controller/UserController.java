package lk.ac.cmb.ucsc.euphoria.controller;


import lk.ac.cmb.ucsc.euphoria.dto.CounselorRequestDTO;
import lk.ac.cmb.ucsc.euphoria.model.*;
import lk.ac.cmb.ucsc.euphoria.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/counselorrequest", consumes = "application/json", produces = "application/json")
    public void addRequest(@RequestBody @Valid @NonNull Request request) {
        logger.info("HIT - /counselor/counselorrequest  POST | Doctor ID : {} | Username : {} | Doctor Name : {}",
                request.getDoctor_id(), request.getUser_name(), request.getDoctor_name());
    }

    @GetMapping(path = "/getCounselors", produces = "application/json")
    public List<Counselor> getCounselors() {
        logger.info("HIT - /counselor/getCounselors  GET");
        return userService.getCounselors();
    }


    @PostMapping(path = "/newpost", consumes = "application/json", produces = "application/json")
    public void addPost(@RequestBody @Valid @NonNull Post post) {
        logger.info("HIT - /counselor/newpost  POST | Post Title : {} | Post Body : {} ",
                post.getPostTitle(), post.getPostBody());
        userService.addPost(post);
    }

    @PostMapping(path = "/signin", consumes = "application/json", produces = "application/json")
    public List<User> signIn(@RequestBody @Valid @NonNull Password password) {
        logger.info("HIT - /counselor/newpost  POST | Email : {}", password.getEmail());
        Boolean value = true;
        try{
//            if(userService.signIn(password)){
//                return ResponseEntity.ok(true);
//            }else{
//                return ResponseEntity.ok(false);
//            }
            return userService.signIn(password);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    @PostMapping(path = "/quicksignup", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Boolean> quickSignUp(@RequestBody @Valid @NonNull User user) {
        logger.info("HIT - /counselor/quicksignup  POST | First Name : {} | Last Name: {}", user.getFirst_name(), user.getLast_name());
        try{
            if(userService.quickSignUp(user)){

                return ResponseEntity.ok(true);
            }else{
                return ResponseEntity.ok(false);
            }
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(false);
        }
    }


    @PostMapping(path = "/formalsignup", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Boolean> formalSignUp(@RequestBody @Valid @NonNull User user) {
        logger.info("HIT - /counselor/formalsignup  POST | First Name : {} | Last Name: {}", user.getFirst_name(), user.getLast_name());
        try{
            if(userService.formalSignUp(user)){
                return ResponseEntity.ok(true);
            }else{
                return ResponseEntity.ok(false);
            }
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(false);
        }
    }

    @PostMapping(path = "/requestcounselor", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Boolean> requestCounselor(@RequestBody @Valid @NonNull CounselorRequestDTO counselorRequest) {
        logger.info("HIT - /counselor/requestcounselor  POST | User Id : {} ", counselorRequest.getUser_id());
        try{
            return userService.requestCounselor(counselorRequest);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(false);
        }
    }

}
