package org.example.gestion_des_patients;

import org.example.gestion_des_patients.entities.Patient;
import org.example.gestion_des_patients.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class GestionDesPatientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDesPatientsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "Hassan", new Date(), false, 40));
            patientRepository.save(new Patient(null, "Mohamed", new Date(), true, 35));
            patientRepository.save(new Patient(null, "Ali", new Date(), true, 100));
            patientRepository.save(new Patient(null, "Fatima", new Date(), false, 60));

            patientRepository.findAll().forEach(System.out::println);
        };
    }

}
