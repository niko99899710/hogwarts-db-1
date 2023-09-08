package pro.sky.hogwartsdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sky.hogwartsdb.model.Faculty;
import pro.sky.hogwartsdb.model.Student;
import pro.sky.hogwartsdb.repository.FacultyRepository;

import java.util.*;

    @Service
    public class FacultyService {
        private final FacultyRepository facultyRepository;

        @Autowired
        public FacultyService(FacultyRepository facultyRepository) {
            this.facultyRepository = facultyRepository;
        }

        public Faculty createFaculty(Faculty faculty) {
            return facultyRepository.save(faculty);
        }

        public Faculty findFaculty(long Id) {
            return facultyRepository.getById(Id);
        }

        public Faculty updateFaculty( Faculty faculty) {
            return facultyRepository.save(faculty);
        }

        public void deleteFaculty(long id) {
            facultyRepository.deleteById(id);
        }

        public Collection<Faculty> findAllFaculty() {
            return facultyRepository.findAll();
        }

        public Collection<Faculty> findAllByColor(String color) {
         return facultyRepository.findAllByColor(color);
        }

        public Collection <Faculty>  findFacultyByStudents (Student students){
            return facultyRepository.findFacultyByStudents(students);
        };


    }

