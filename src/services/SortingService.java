package services;

import java.util.List;
import java.util.ArrayList;
import models.Patient;

public class SortingService {

    // Quick Sort — sorts patients by age
    public List<Patient> quickSort(
            List<Patient> patients) {
        List<Patient> sorted =
                new ArrayList<>(patients);
        quickSortHelper(sorted, 0, sorted.size() - 1);
        return sorted;
    }

    private void quickSortHelper(
            List<Patient> patients,
            int low, int high) {
        if (low < high) {
            int pivotIndex =
                    partition(patients, low, high);
            quickSortHelper(
                    patients, low, pivotIndex - 1
            );
            quickSortHelper(
                    patients, pivotIndex + 1, high
            );
        }
    }

    private int partition(List<Patient> patients,
                          int low, int high) {
        int pivot = patients.get(high).getAge();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (patients.get(j).getAge() <= pivot) {
                i++;
                // Swap i and j
                Patient temp = patients.get(i);
                patients.set(i, patients.get(j));
                patients.set(j, temp);
            }
        }

        // Place pivot in correct position
        Patient temp = patients.get(i + 1);
        patients.set(i + 1, patients.get(high));
        patients.set(high, temp);

        return i + 1;
    }

    public void displaySorted(List<Patient> patients) {
        System.out.println(
                "Patients sorted by age (Quick Sort):"
        );
        for (Patient p : patients) {
            System.out.println(
                    "  " + p.getName() +
                            " — Age: " + p.getAge()
            );
        }
    }
}