package lk.ac.cmb.ucsc.euphoria.controller;

import lk.ac.cmb.ucsc.euphoria.model.Appointment;
import lk.ac.cmb.ucsc.euphoria.model.Counselor;
import lk.ac.cmb.ucsc.euphoria.model.PatientRecords;
import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import lk.ac.cmb.ucsc.euphoria.service.CounselorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/counselor")
@RestController
@CrossOrigin
public class CounselorController {

    private static final Logger logger = LoggerFactory.getLogger(CounselorController.class);
    private final CounselorService counselorService;

    @Autowired
    public CounselorController(CounselorService counselorService) {
        this.counselorService = counselorService;
    }

    @PostMapping(path = "/sign-in", consumes = "application/json", produces = "application/json")
    public LoginCredentials counselorSignIn(@RequestBody LoginCredentials loginCredentials) {
        logger.info("HIT - /counselor/sign-in  POST | Username : {} ", loginCredentials.getUsername());
        return counselorService.signIn(loginCredentials);
    }

    @PostMapping(path = "/sign-up", consumes = "application/json", produces = "application/json")
    public Counselor counselorSignUp(@RequestBody Counselor counselor) {
        logger.info("HIT - /counselor/sign-up  POST | Counselor : {} ", counselor);
        return counselorService.signUp(counselor);
    }

    @PostMapping(path = "/reset-password", consumes = "application/json", produces = "application/json")
    public LoginCredentials resetPassword(@RequestBody LoginCredentials loginCredentials) {
        logger.info("HIT - /counselor/reset-password  POST | Username : {} ", loginCredentials.getUsername());
        return counselorService.resetPassword(loginCredentials);
    }

    @GetMapping(path = "/get-appointments", produces = "application/json")
    public List<Appointment> getAppointments() {
        logger.info("HIT - /counselor/get-appointments  GET");
        return counselorService.getAppointments();
    }

    @GetMapping(path = "/get-all-patient-records", produces = "application/json")
    public List<PatientRecords> getAllPatientRecords() {
        logger.info("HIT - /counselor/get-all-patient-records GET");
        return counselorService.getAllPatientRecords();
    }

//    @CrossOrigin
//    @GetMapping
//    public PatientRecords getSinglePatientRecords(Long patient){
//        return counselorService.getSinglePatientRecords(patient);
//    }

}
