package com.lpu.hospital.main;


import com.lpu.hospital.entity.Department;
import com.lpu.hospital.entity.Doctor;
import com.lpu.hospital.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TestOneToMany {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Department cardio = new Department();
        cardio.setName("Cardiology");
        cardio.setLocation("Block A");
        cardio.setHeadDoctorName("Dr. Sharma");

        Department neuro = new Department();
        neuro.setName("Neurology");
        neuro.setLocation("Block B");
        neuro.setHeadDoctorName("Dr. Rao");

        Doctor d1 = new Doctor();
        d1.setName("Dr. Smith");
        d1.setSpecialization("Heart Surgeon");
        d1.setLicenseNo("LIC123");

        Doctor d2 = new Doctor();
        d2.setName("Dr. John");
        d2.setSpecialization("Cardiologist");
        d2.setLicenseNo("LIC124");

        Doctor d3 = new Doctor();
        d3.setName("Dr. Alice");
        d3.setSpecialization("Neuro Specialist");
        d3.setLicenseNo("LIC125");

        Doctor d4 = new Doctor();
        d4.setName("Dr. Bob");
        d4.setSpecialization("Brain Surgeon");
        d4.setLicenseNo("LIC126");

        cardio.addDoctor(d1);
        cardio.addDoctor(d2);

        neuro.addDoctor(d3);
        neuro.addDoctor(d4);

        em.persist(cardio);
        em.persist(neuro);

        tx.commit();
        em.close();

        System.out.println("✅ Departments & Doctors saved");
    }
}