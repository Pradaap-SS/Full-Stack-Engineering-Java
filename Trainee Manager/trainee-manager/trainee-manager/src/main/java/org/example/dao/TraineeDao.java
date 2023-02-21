package org.example.dao;

import org.example.exeptions.InvalidTraineeOperationException;
import org.example.model.Trainee;

import java.util.List;

public interface TraineeDao {

    void registerTrainee(String cohort, Trainee trainee) throws InvalidTraineeOperationException;

    void removeTrainee(String cohort, Trainee trainee) throws InvalidTraineeOperationException;

    Trainee findByName(String cohort, String fullName) throws InvalidTraineeOperationException;

    List<Trainee> findAll(String cohort);
}
