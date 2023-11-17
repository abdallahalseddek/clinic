CREATE TABLE "Patients" (
  "Patient_ID" SERIAL PRIMARY KEY,
  "Name" VARCHAR(100),
  "Contact_Info" VARCHAR(100),
  "Address" VARCHAR(255)
);

CREATE TABLE "Doctors" (
  "Doctor_ID" SERIAL PRIMARY KEY,
  "Name" VARCHAR(100),
  "Specialization" VARCHAR(100),
  "Contact_Info" VARCHAR(100)
);

CREATE TABLE "ClinicAdmins" (
  "Admin_ID" SERIAL PRIMARY KEY,
  "Name" VARCHAR(100),
  "Contact_Info" VARCHAR(100),
  "Role" VARCHAR(50)
);

CREATE TABLE "Appointments" (
  "Appointment_ID" SERIAL PRIMARY KEY,
  "Date_Time" TIMESTAMP,
  "Duration" INTERVAL,
  "Reason" VARCHAR(255),
  "Status" VARCHAR(50),
  "Admin_ID" INT,
  "Doctor_ID" INT
);

CREATE TABLE "Patient_Appointment" (
  "Patient_ID" INT,
  "Appointment_ID" INT,
  PRIMARY KEY ("Patient_ID", "Appointment_ID")
);

CREATE INDEX "idx_patient_id" ON "Patient_Appointment" ("Patient_ID");

CREATE INDEX "idx_appointment_id" ON "Patient_Appointment" ("Appointment_ID");

ALTER TABLE "Appointments" ADD FOREIGN KEY ("Admin_ID") REFERENCES "ClinicAdmins" ("Admin_ID");

ALTER TABLE "Appointments" ADD FOREIGN KEY ("Doctor_ID") REFERENCES "Doctors" ("Doctor_ID");

ALTER TABLE "Patient_Appointment" ADD FOREIGN KEY ("Patient_ID") REFERENCES "Patients" ("Patient_ID");

ALTER TABLE "Patient_Appointment" ADD FOREIGN KEY ("Appointment_ID") REFERENCES "Appointments" ("Appointment_ID");
