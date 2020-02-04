package services;

import data.HealthCardID;
import data.PatientContr;
import data.ProductID;

import java.net.ConnectException;

public interface NationalHealthService {
   // Dispensing getePrescription(HealthCardID hcID) throws HealthCardException, NotValidePrescriptionException, ConnectException;
    PatientContr getPatientContr(HealthCardID hcID) throws ConnectException;
    //ProductSpecification getProductSpecific(ProductID pID) throws ProductIDException, ConnectException;
    //List<Dispensing> updateePrescription(HealthCardID hcID, Dispensing disp) throws ConnectException;
}
