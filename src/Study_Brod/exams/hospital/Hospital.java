package Study_Brod.exams.hospital;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;



// Bonus:
//   Vypiste 5 nejlepe placenych doktoru v nemocnici
//   Procentualni zastoupeni zamestnancu. (příklad: 50% Doktoři, 35% Chirurgové, 15% Kardiochirurgové)
//   Kdo způsobil největší penalizaci nemocnici

public class Hospital {

    static int validateJob(Doctor d, String jobType) {
        // TODO: implementujte logiku validace práce:
        // Doktor může dělat práci typu `jobType` jen pokud je kvalifikovan
        // C -> cardiacSurgery
        // S -> surgery
        // D -> diagnose
        int penalty =0;

        switch (jobType){
            case "C":{
                if(d instanceof CardicSurgeon) {
                    ((CardicSurgeon) d).cardicSurgery();
                }
                else penalty++;
                break;
            }

            case "S":{
                if(d instanceof Surgeon) {
                    ((Surgeon) d).surgery();
                }
                else penalty++;
                break;
            }
            case "D":{
                d.diagnose();
                break;
            }
        }
        return penalty;
    }


    public static void main(String[] args) {

        DataImport di = new DataImport("data/hospitalData.txt");
        DataExport de = new DataExport("data/hospital.txt");

        // TODO: napsat test

        ArrayList <Doctor> doctors = new ArrayList<>();
        int heartOparations = 0;
        int penalty = 0;

        // Načtěte ze souboru hospitalData informace o doktorech
        while (di.hasNext()){
            String line = di.readLine();
            String[] token = line.split(";");

            switch (token[1]){
                case "Doctor": {
                    doctors.add(new Doctor(token[0]));
                    break;
                }
                case "Surgeon": {
                    doctors.add(new Surgeon(token[0]));
                    break;
                }
                default:{
                    doctors.add(new CardicSurgeon(token[0]));
                    break;
                }
            }
            for (int i = 2; i < token.length; i++) {
                penalty += validateJob(doctors.getLast(), token[i]);
                if (token[i].equals("C")) heartOparations ++;
            }

        }

        // do souboru hospital.txt vypiste nasledujici informace o vsech doktorech:

        // 1. Doktora s nejvetsim vydelkem
        Doctor best = new Doctor("N");
        for(Doctor doctor : doctors){
            if (doctor.salary> best.salary){
                best = doctor;
            }
        }
        de.writeLine("The best doctor is: "+best.toString());

        // 2. Doktora s nejmensjim vydelkem
        Doctor worst = doctors.getFirst();
        for(Doctor doctor : doctors){
            if (doctor.salary < worst.salary){
                worst = doctor;
            }
        }
        de.writeLine("The worst doctor is: "+worst.toString());

        // 3. Prumerny plat v nemocnici
        int midSalary = 0;
        int fullSalary = 0;
        for(Doctor doctor : doctors){
            fullSalary += doctor.salary;
        }
        midSalary = fullSalary/ doctors.size();
        de.writeLine("Salary in this hospital is around: "+midSalary);

        // 4. Pocet realizovanych operací srdce
        de.writeLine("Count of heart operation is: "+heartOparations);

        // 5. Pocet udelenych penalizaci nemocnici
        //     - Nemocnice je penalizovana za kazdy zakrok doktora, na ktery nema kvalifikaci
        de.writeLine("Count of penalty is: "+penalty);



        // nezapomenout na úklid
        di.finishImport();
        de.finishExport();
    }
}
