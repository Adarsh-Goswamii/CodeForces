import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.Clock;
import java.util.*;
import java.awt.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

class Medical {
    String p2, p3, p4, p5, p6;
    double p1;
    double val_temp, val_systole, val_diastole, val_hrv, val_pep, val_fvc, val_fev1, val_ratiofv, val_haemoglobin;
    double val_hbpm, val_rbc, val_wbc, val_platelets;

    // constructor
    Medical() {
        this.val_temp = 37;
        this.val_hrv = 100;
        this.val_systole = 120;
        this.val_pep = 0.35;
        this.val_diastole = 80;
        this.val_hbpm = 70;
        this.val_fvc = 95;
        this.val_rbc = 540000;
        this.val_fev1 = 85;
        this.val_wbc = 7000;
        this.val_ratiofv = 75;
        this.val_platelets = 250000;
        this.val_haemoglobin = 15.5;
    }

    void SCAN(Symptoms symps) {
        val_temp = Math.random() * 100;
        double p1 = symps.temperature(val_temp);
        if (p1 <= 40)
            System.out.println("Temperature :" + p1);
        else
            System.out.println("Temperature Not possible");


        val_systole = Math.random() * 200;
        val_diastole = Math.random() * 100;
        p2 = symps.bloodpressure(val_systole, val_diastole);
        System.out.println("Systole :" + val_systole);
        System.out.println("Diastole :" + val_diastole);
        System.out.println(p2);


        val_hbpm = Math.random() * 100.0;
        p3 = symps.pulse(val_hbpm);
        if (symps.hbpm >= 40 && symps.hbpm < 130) {
            System.out.println("Pulse :" + symps.hbpm);
            System.out.println(p3);
        } else
            System.out.println("Pulse value not possible");


        val_rbc = Math.random() * 10000000;
        val_wbc = Math.random() * 10000;
        val_platelets = Math.random() * 1000000;
        val_haemoglobin = (Math.random() * 10) + 10.4;
        p4 = symps.bloodcontents(val_rbc, val_wbc, val_platelets, val_haemoglobin);

        if (symps.rbc < 3000000 || symps.rbc > 6000000 || symps.wbc < 1000 || symps.wbc > 10000 || symps.platelets < 70000 || symps.platelets > 500000 || symps.haemoglobin < 13.5 || symps.haemoglobin > 18.0)
            System.out.println("blood level not possible");
        else {
            System.out.println("Red blood cells :" + symps.rbc);
            System.out.println("White blood cells :" + symps.wbc);
            System.out.println("Platelets :" + symps.platelets);
            System.out.println("Heamoglobin :" + symps.haemoglobin);
            System.out.println(p4);
        }


        val_hrv = Math.random() * 100;
        val_pep = Math.random() + 0.16;

        p5 = symps.Ans(val_hrv, val_pep);
        if (symps.hrv < 10 || symps.pep < 0.30 || symps.pep > 0.40)
            System.out.println("hrv pep not possible");
        else {
            System.out.println("Heart rate variablitity :" + symps.hrv);
            System.out.println("Pre ejection period :" + symps.pep);
            System.out.println(p5);
        }


        val_fvc = Math.random() * 100;
        val_fev1 = Math.random() * 100;

        p6 = symps.spirometry(val_fvc, val_fev1);
        if (symps.fvc < 75 || symps.fvc > 100 || symps.fev1 < 30 || symps.fev1 > 130)
            System.out.println("fvc and fev1 values not possible");
        else {
            System.out.println("fvc :" + symps.fvc);
            System.out.println("fev1 :" + symps.fev1);
            System.out.println(p6);
        }


    }


    void predict_ailment(Symptoms symps) {

        // Prestored DataSet of ailments which can be increased based on new symptoms

        ArrayList<String> ailments = new ArrayList<String>();

        /**
         * PROB: ArrayList indexing starts with 0 so this will show an ERROR.
         * SOLN: 1. Start inserting values from 0
         *       2. Just insert the values without giving index. ex:
         *              aliments.add("cancer");
         *              aliments.add("chicken pocks");
         *              .
         *              .
         *              aliments.add("something");
         */

        ailments.add(0, "Dehydration");
        ailments.add(1, "Dehydration");
        ailments.add(2, "Tuberculosis");
        ailments.add(3, "Chicken Pocks");
        ailments.add(4, "Septecemia");
        ailments.add(5, "Breast Cancer");
        ailments.add(6, "Sarcoidoisis");
        ailments.add(7, "Anaphylaxis");
        ailments.add(8, "Prostate Cancer");
        ailments.add(9, "Thyroid Cancer");
        ailments.add(10, "Heart Attack");
        ailments.add(11, "Alzheimers Disease");
        ailments.add(12, "Goitre");
        ailments.add(13, "Demetia");
        ailments.add(14, "Leukemia");
        ailments.add(15, "Graves disease");
        ailments.add(16, "Arrhythmia");
        ailments.add(17, "Basal cell cancer");
        ailments.add(18, "Osteomalacia");
        ailments.add(19, "Osteoporosis");
        ailments.add(20, "Colon Cancer");
        ailments.add(21, "Scurvey");
        ailments.add(22, "Arthiritis");
        ailments.add(23, "Melanoma");
        ailments.add(24, "Night Blindness");
        ailments.add(25, "Hepatitis");
        ailments.add(26, "Lymphoma");
        ailments.add(27, "Pancreatic cancer");
        ailments.add(28, "Asthama");
        ailments.add(29, "Parkinson disease");
        ailments.add(30, "HIV");
        ailments.add(31, "Lung Cancer");
        ailments.add(32, "Paralysis");
        ailments.add(33, "Hyperthiroidism");
        ailments.add(34, "Blood Cancer");
        ailments.add(35, "Pneumonia");
        ailments.add(36, "Hypothiroidism");
        ailments.add(37, "Anaemia");
        ailments.add(38, "dizziness");
        ailments.add(39, "viral fever");
        ailments.add(40, "Chronic Bronchitis");
        ailments.add(41, "Emphysema");

        System.out.println();
        System.out.println();
        System.out.println("Predictable diseases:");
        System.out.println();


        if (p2.equalsIgnoreCase("Hypertension crisis") == true) {
            System.out.println(ailments.get(10));

        }


        if (p2.equalsIgnoreCase("Hypertension stage 2") == true) {
            System.out.println(ailments.get(13));

        }

        if (p2.equalsIgnoreCase("Hypotension") == true) {
            System.out.println(ailments.get(1));
            System.out.println(ailments.get(4));
            System.out.println(ailments.get(7));
        }


        if (p3.equalsIgnoreCase("high pulse rate") == true) {

            System.out.println(ailments.get(16));
        }

        if (p5.equalsIgnoreCase("abnormal ans movement") == true) {
            System.out.println(ailments.get(19));
            System.out.println(ailments.get(22));
            System.out.println(ailments.get(11));
        }


        if (p4.equalsIgnoreCase("abnormal blood level") == true) {
            System.out.println(ailments.get(37));
            System.out.println(ailments.get(26));
            System.out.println(ailments.get(14));
            System.out.println(ailments.get(34));
        }


        if (p3.equalsIgnoreCase("slow pulse rate") == true) {

            System.out.println(ailments.get(38));

        }

        if (p6.equalsIgnoreCase("severely abnormal respiration") == true) {
            System.out.println(ailments.get(28));
            System.out.println(ailments.get(31));
        }

        if (p6.equalsIgnoreCase("moderately abnormal respiration") == true) {
            System.out.println(ailments.get(35));
            System.out.println(ailments.get(40));
        }

        if (symps.temp > 37 && symps.temp <= 40) {
            System.out.println(ailments.get(39));

        }

        if (p6.equalsIgnoreCase("mildly abnormal respiration") == true) {
            System.out.println(ailments.get(41));
            System.out.println(ailments.get(2));
            System.out.println(ailments.get(6));
        }
        System.out.println(p2+"\n"+p3+"\n"+p4+"\n"+p5+"\n"+p6);
    }

//    void medication() { }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Symptoms symps= new Symptoms();
        Medical med= new Medical();

        /**
         * Even if the user enters any random value except 1 this code will print
         * Body scan completed.
         *
         * add that println line inside the if statement when command== 1.
         *
         * Moreover, we dont need to predict ailments for wrong input given
         * by user........so include calling of predict_ailments in if too.
         */

        int command;
        System.out.println("Give command to initiate body scan." + "press 1.");
        command = sc.nextInt();
        if (command == 1) {
            System.out.println("Body scan in progress...");

            // not necessary but if you want. Will add a dela

            med.SCAN(symps);
            System.out.println("\n\nBody Scan completed...");
            med.predict_ailment(symps);
        } else {
            System.out.println("command not found!");
        }

        System.exit(0);

    }           //main() end
}   // medical class ends


class Symptoms {
    double temp, systole, diastole, hrv, pep, fvc, fev1, ratiofv, haemoglobin;
    double hbpm, rbc, wbc, platelets;

    Symptoms() {
        this.temp = 37;
        this.hrv = 100;
        this.systole = 120;
        this.pep = 0.35;
        this.diastole = 80;
        this.hbpm = 70;
        this.fvc = 95;
        this.rbc = 540000;
        this.fev1 = 85;
        this.wbc = 7000;
        this.ratiofv = 75;
        this.platelets = 250000;
        this.haemoglobin = 15.5;
    }                                                                                   //constructor ends


    double temperature(double temp) {
        if (this.temp <= 40)
            return temp;
        else

            return 273;
    }


    String bloodpressure(double systole, double diastole) {
        this.systole = systole;
        this.diastole = diastole;

        if (this.systole < 120 && this.systole > 100 || this.diastole < 80 && this.diastole > 60)
            return "Normal blood pressure";
        else if (this.systole >= 120 && this.systole <= 129)
            return "Elevated blood pressure";
        else if (this.systole >= 130 && this.systole <= 139 || this.diastole >= 80 && this.diastole <= 89)
            return "Hypertension stage 1";
        else if (this.systole >= 140 && this.systole <= 179 || this.diastole >= 90 && this.diastole <= 119)
            return "Hypertension stage 2";
        else if (this.systole >= 180 || this.diastole >= 120)
            return "Hypertension crisis";
        else
            return "Hypotension";
    }


    String pulse(double hbpm)                                                                       //hbpm is heartbeat per min
    {
        this.hbpm = hbpm;
        if (this.hbpm > 100)
            return "high pulse rate";
        else if (this.hbpm < 60)
            return "slow pulse rate";
        else
            return "normal pulse rate";
    }


    String bloodcontents(double rbc, double wbc, double platelets, double haemoglobin) {
        this.rbc = rbc;
        this.wbc = wbc;
        this.platelets = platelets;
        this.haemoglobin = haemoglobin;

        if (this.rbc >= 6100000 && this.wbc >= 11000 && this.platelets >= 450000 && this.haemoglobin > 17.5)
            return "abnormal blood level";
        else if (this.rbc <= 4700000 && this.wbc <= 4500 && this.platelets <= 150000 && this.haemoglobin < 13.5)
            return "abnormal blood level";
        else
            return "normal blood level";
    }


    String Ans(double hrv, double pep)                                                           //Autonomic Nervous System measurement
    {
        this.hrv = hrv;
        this.pep = pep;

        if (this.hrv >= 20 && this.hrv <= 200 && pep >= 0.30 && pep <= 0.39)
            return "normal ans movement";
        else
            return "abnormal ans movement";
    }


    String spirometry(double fvc, double fev1)                                              //Respiratory measurement
    {
        this.fvc = fvc;
        this.fev1 = fev1;
        double ratiofv = fvc / fev1;

        if (fev1 >= 80)
            return "normal respiration";
        else if (fev1 >= 70 && fev1 <= 79)
            return "mildly abnormal respiration";
        else if (fev1 >= 60 && fev1 <= 69)
            return "moderately abnormal respiration";
        else
            return "severely abnormal respiration";
    }
}   //Symptoms class ends

