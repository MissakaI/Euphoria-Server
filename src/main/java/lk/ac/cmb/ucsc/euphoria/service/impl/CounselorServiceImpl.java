package lk.ac.cmb.ucsc.euphoria.service.impl;

import com.google.common.collect.Lists;
import lk.ac.cmb.ucsc.euphoria.model.Appointment;
import lk.ac.cmb.ucsc.euphoria.model.Counselor;
import lk.ac.cmb.ucsc.euphoria.model.PatientRecords;
import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import lk.ac.cmb.ucsc.euphoria.repository.AppointmentRepository;
import lk.ac.cmb.ucsc.euphoria.repository.CounselorRepository;
import lk.ac.cmb.ucsc.euphoria.repository.PatientRecordsRepository;
import lk.ac.cmb.ucsc.euphoria.service.CounselorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CounselorServiceImpl implements CounselorService {

    private final CounselorRepository counselorRepository;
    private final AppointmentRepository appointmentRepository;
    private final PatientRecordsRepository patientRecordsRepository;

    @Autowired
    public CounselorServiceImpl(CounselorRepository counselorRepository, AppointmentRepository appointmentRepository, PatientRecordsRepository patientRecordsRepository) {
        this.counselorRepository = counselorRepository;
        this.appointmentRepository = appointmentRepository;
        this.patientRecordsRepository = patientRecordsRepository;
    }

    @Override
    public LoginCredentials signIn(LoginCredentials loginCredentials) {
        return isExistCounselor(loginCredentials);
    }

    @Override
    public LoginCredentials isExistCounselor(LoginCredentials loginCredentials) {
        return null; // TODO : Cannot get a LoginCredential obj from Counselor Repository. Please check again.
//        List<LoginCredentials> existCounselorName = counselorRepository.isExistCounselorName(loginCredentials.getUsername());
//        for (LoginCredentials l : existCounselorName) {
//            return (l.getUsername().equalsIgnoreCase(loginCredentials.getUsername()) && l.getPassword().equalsIgnoreCase(loginCredentials.getPassword())) ?
//                    l : null;
//        }
//        return null;
    }

    @Override
    public Counselor signUp(Counselor counselor) {
        return counselorRepository.save(counselor);
    }

    @Override
    public LoginCredentials forgetPassword(LoginCredentials loginCredentials) {
        return isExistCounselor(loginCredentials);
    }

    @Override
    public LoginCredentials resetPassword(LoginCredentials loginCredentials) {
        return isExistCounselor(loginCredentials);
    }

    @Override
    public List<Appointment> getAppointments() {
        ArrayList<Appointment> appointmentsList = Lists.newArrayList(appointmentRepository.findAll());
        return appointmentsList;
    }

    @Override
    public List<PatientRecords> getAllPatientRecords() {
        return Lists.newArrayList(patientRecordsRepository.findAll());
    }

}
