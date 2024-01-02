package uta.edu.estudiante.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uta.edu.estudiante.models.Estudiante;
import uta.edu.estudiante.repositories.EstudianteRepository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@RestController
@RequestMapping("rest")
public class ApiEstudiante {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @GetMapping("/")
    public String index() {
        return "index"; // Devuelve la página index.html ubicada en resources/static
    }

    @GetMapping("/all")
    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.findAll();
    }

    @GetMapping("/search/{cedula}")
    public Estudiante getEstudianteById(@PathVariable String cedula) {
        return estudianteRepository.findById(cedula).orElse(null);
    }
    @PostMapping("/save/{cedula}")
    public Estudiante addEstudiante(@PathVariable String cedula, @RequestBody Estudiante estudiante) {
        estudiante.setCedula(cedula);
        return estudianteRepository.saveAndFlush(estudiante);
    }

    @PutMapping("/edit/{cedula}")
    public Estudiante updateEstudiante(@PathVariable String cedula, @RequestBody Estudiante estudiante) {
        estudiante.setCedula(cedula);
        return estudianteRepository.saveAndFlush(estudiante);
    }

    @DeleteMapping("/delete/{cedula}")
    public void deleteEstudiante(@PathVariable String cedula) {
        estudianteRepository.deleteById(cedula);
    }

    @GetMapping("/saludar")
    public String saluda() {
        return "Hola mundo";
    }
}