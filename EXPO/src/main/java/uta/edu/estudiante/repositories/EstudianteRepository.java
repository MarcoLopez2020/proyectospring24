package uta.edu.estudiante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uta.edu.estudiante.models.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, String> {
}
