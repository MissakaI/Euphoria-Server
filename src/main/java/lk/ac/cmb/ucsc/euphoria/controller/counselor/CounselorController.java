package lk.ac.cmb.ucsc.euphoria.controller.counselor;

import lk.ac.cmb.ucsc.euphoria.model.AppointmentRequest;
import lk.ac.cmb.ucsc.euphoria.model.PatientRecords;
import lk.ac.cmb.ucsc.euphoria.model.counselor.Counselor;
import lk.ac.cmb.ucsc.euphoria.service.CounselorService;
import lk.ac.cmb.ucsc.euphoria.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/counselor")
@RestController
public class CounselorController {

    @Autowired
    private CounselorService counselorService;

    @Autowired
    private EmailService emailService;

//    @CrossOrigin
//    @PostMapping(path = "/sign-in", consumes = "application/json", produces = "application/json")
//    public LoginCredentials counselorSignIn(@RequestBody LoginCredentials loginCredentials) {
//        return counselorService.signIn(loginCredentials);
//    }
//
    @CrossOrigin
    @PostMapping(path = "/sign-up", consumes = "application/json", produces = "application/json")
    public boolean counselorSignUp(@RequestBody Counselor counselor) {
        return counselorService.signUp(counselor);
    }
//
//    @CrossOrigin
//    @PostMapping(path = "/reset-password", consumes = "application/json", produces = "application/json")
//    public LoginCredentials resetPassword(@RequestBody LoginCredentials loginCredentials) {
//        return counselorService.resetPassword(loginCredentials);
//    }

    @CrossOrigin
    @GetMapping(path = "/appointments/{status}", produces = "application/json")
    public List<AppointmentRequest> getAppointments(@PathVariable String status) {
        return counselorService.getAppointments(status);
    }

    @CrossOrigin
    @PostMapping(path = "/appointments/{status}", produces = "application/json")
    public List<AppointmentRequest> updateAppointments(@PathVariable String status) {
        return counselorService.getAppointments("F");
    }

    @CrossOrigin
    @GetMapping(path = "/patient-records/{user}", produces = "application/json")
    public List<PatientRecords> getPatientRecords(@PathVariable long user) {
        return counselorService.getPatientRecords(user);
    }

    @CrossOrigin
    @PostMapping(path = "/patient-records", produces = "application/json")
    public boolean newPatientRecord(@RequestParam PatientRecords record) {
        return counselorService.newPatientRecord(record);
    }

//    @CrossOrigin
//    @GetMapping
//    public PatientRecords getSinglePatientRecords(Long patient){
//        return counselorService.getSinglePatientRecords(patient);
//    }



    @CrossOrigin
    @GetMapping(path = "/testMail")
    public void sendTestMail(){
        emailService.sendSimpleMessage("m.iddamalgoda@gmail.com","TestMail","This is a test mail from euphoria");
    }

}
