package repository.edu_degree;

import model.EducationDegree;

public interface EduDegreeRepository{
    EducationDegree findById(int id);
}