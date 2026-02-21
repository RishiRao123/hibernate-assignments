package com.lpu.hospital.main;

import com.lpu.hospital.entity.MedicalRecord;
import com.lpu.hospital.entity.Patient;
import com.lpu.hospital.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;

public class TestOneToOne {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            // 🔹 Create Medical Record
            MedicalRecord record = new MedicalRecord();
            record.setRecordDate(LocalDate.now());
            record.setDiagnosis("Flu");
            record.setNotes("Rest for 3 days");

            // 🔹 Create Patient
            Patient patient = new Patient();
            patient.setName("Varun");
            patient.setDob(LocalDate.of(2004, 1, 1));
            patient.setBloodGroup("O+");
            patient.setPhone("9999999999");

            // 🔹 Set relationship
            patient.setMedicalRecord(record);

            // 🔹 Persist only patient (CascadeType.ALL will save record)
            em.persist(patient);

            tx.commit();
            System.out.println("✅ Patient saved successfully");

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
}