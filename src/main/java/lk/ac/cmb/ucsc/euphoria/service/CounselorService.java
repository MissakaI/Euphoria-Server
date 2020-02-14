package lk.ac.cmb.ucsc.euphoria.service;

import lk.ac.cmb.ucsc.euphoria.model.Appointment;
import lk.ac.cmb.ucsc.euphoria.model.Counselor;
import lk.ac.cmb.ucsc.euphoria.model.PatientRecords;
import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;

import java.util.List;

public interface CounselorService {
    LoginCredentials signIn(LoginCredentials loginCredentials);

    LoginCredentials isExistCounselor(LoginCredentials loginCredentials);

    Counselor signUp(Counselor counselor);

    LoginCredentials forgetPassword(LoginCredentials loginCredentials);

    LoginCredentials resetPassword(LoginCredentials loginCredentials);

    List<Appointment> getAppointments();

    List<PatientRecords> getAllPatientRecords();
}
