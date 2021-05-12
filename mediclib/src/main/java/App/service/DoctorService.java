package App.service;

import App.dao.DAOFactory;
import App.dao.Doctor.IDoctorDao;
import App.exception.IdMustBePositiveException;
import App.model.Doctor;

import java.util.List;

public class DoctorService {

    private IDoctorDao dao = DAOFactory.createDoctorDao();

    public List<Doctor> findAll() {
        return this.dao.findAll();
    }


    public Doctor findById(int id) {
        if (id <= 0) {
            throw new IdMustBePositiveException();
        }

        return this.dao.findById(id).orElseThrow(null);
    }

    public void add(Doctor doctor) {
        //Eventuellement ajouter des vérifications / validations ici

        //On demande à la DAO de sauvegarder (ajout)
        this.dao.add(doctor);
    }

    public void update(Doctor doctor) {
        //Eventuellement vérifier si le produit n'est pas null, que l'identifiant existe bien, etc.

        //On demande à la DAO de sauvegarder
        this.dao.update(doctor);
    }

}
