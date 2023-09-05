package pro.sky.hogwartsdb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.hogwartsdb.model.Faculty;
import pro.sky.hogwartsdb.service.FacultyService;
import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    public final FacultyService facultyService;


    public FacultyController(FacultyService facultyService) {

        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty createFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(createFaculty);
    }

    @GetMapping("{Id}")
    public ResponseEntity<Faculty> findFaculty(@PathVariable Long Id) {
        Faculty faculty = facultyService.findFaculty(Id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping()
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
        Faculty updateFaculty = facultyService.updateFaculty(faculty);
        if (updateFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateFaculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deleteFaculty (@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return  ResponseEntity.ok().build();
    }

    @GetMapping()
    public Collection<Faculty> findAllFaculty() {
        return facultyService.findAllFaculty() ;
    }

    @GetMapping()
    public ResponseEntity<Collection<Faculty>> findAllByColor(@RequestParam(required = false) String color) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findAllByColor(color));
        }
        return ResponseEntity.ok(Collections.emptyList());
    }
}
