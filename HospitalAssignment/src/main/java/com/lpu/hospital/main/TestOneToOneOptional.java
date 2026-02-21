package com.lpu.hospital.main;

import com.lpu.hospital.entity.Appointment;
import com.lpu.hospital.entity.Prescription;
import com.lpu.hospital.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestOneToOneOptional {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Appointment WITH prescription
        Prescription p = new Prescription();
        p.setMedicines("Paracetamol");
        p.setDosage("2 times a day");
        p.setIssuedDate(LocalDate.now());
        p.setActive(true);

        Appointment a1 = new Appointment();
        a1.setAppointDate(LocalDateTime.now());
        a1.setStatus("COMPLETED");
        a1.setReason("Fever");
        a1.setPrescription(p);

        // Appointment WITHOUT prescription
        Appointment a2 = new Appointment();
        a2.setAppointDate(LocalDateTime.now().plusDays(1));
        a2.setStatus("SCHEDULED");
        a2.setReason("Routine Check");
        a2.setPrescription(null);

        em.persist(a1);
        em.persist(a2);

        tx.commit();
        em.close();

        System.out.println("✅ Appointments saved (with & without prescription)");
    }
}