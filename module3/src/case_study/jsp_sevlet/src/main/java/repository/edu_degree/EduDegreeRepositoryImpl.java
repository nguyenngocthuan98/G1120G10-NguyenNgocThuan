package repository.edu_degree;

import model.EducationDegree;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EduDegreeRepositoryImpl implements EduDegreeRepository{

    @Override
    public EducationDegree findById(int id) {
        return null;
    }
}
