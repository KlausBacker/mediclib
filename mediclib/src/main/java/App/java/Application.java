package App.java;

import App.dao.AbstractDaoSql;
import App.model.Doctor;
import App.service.DoctorService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
	System.out.println("Hello world");
	daoDoctor();
    }
    public static void daoDoctor(){
        DoctorService doctorService = new DoctorService();
       List<Doctor> doctorList = doctorService.findAll();
      for (Doctor d : doctorList) {
         System.out.println(d.getFirstName()+ " "+ d.getLastName());
      }
    }
}
