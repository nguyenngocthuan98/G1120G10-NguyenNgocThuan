package service.edu_degree;

import model.EducationDegree;
import repository.edu_degree.EduDegreeRepository;
import repository.edu_degree.EduDegreeRepositoryImpl;

public class EduDegreeServiceImpl implements EduDegreeService{
    EduDegreeRepository repository = new EduDegreeRepositoryImpl();
    @Override
    public EducationDegree findById(int id) {
        return repository.findById(id);
    }
}
