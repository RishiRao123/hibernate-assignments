package com.lpu.hospital.main;


import com.lpu.hospital.entity.Appointment;
import com.lpu.hospital.entity.Doctor;
import com.lpu.hospital.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDateTime;

public class TestUniOneToMany {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Doctor doctor = new Doctor();
        doctor.setName("Dr. Watson");
        doctor.setSpecialization("General Physician");
        doctor.setLicenseNo("LIC200");

        Appointment a1 = new Appointment();
        a1.setAppointDate(LocalDateTime.now());
        a1.setStatus("SCHEDULED");
        a1.setReason("Fever");

        Appointment a2 = new Appointment();
        a2.setAppointDate(LocalDateTime.now().plusDays(1));
        a2.setStatus("SCHEDULED");
        a2.setReason("Checkup");

        Appointment a3 = new Appointment();
        a3.setAppointDate(LocalDateTime.now().plusDays(2));
        a3.setStatus("SCHEDULED");
        a3.setReason("Follow-up");

        doctor.getAppointments().add(a1);
        doctor.getAppointments().add(a2);
        doctor.getAppointments().add(a3);

        em.persist(doctor);

        tx.commit();
        em.close();

        System.out.println("✅ Doctor with appointments saved");
    }
}
