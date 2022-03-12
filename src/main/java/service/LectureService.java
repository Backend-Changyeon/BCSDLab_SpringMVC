package service;

import java.sql.SQLException;

public interface LectureService {
    void getLectures() throws ClassNotFoundException, SQLException;
}
