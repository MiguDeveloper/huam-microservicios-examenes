package pe.tuna.huammicroserviciosexamenes.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.tuna.commonsmicroservicios.controllers.CommonController;
import pe.tuna.huammicroserviciosexamenes.models.Examen;
import pe.tuna.huammicroserviciosexamenes.models.Pregunta;
import pe.tuna.huammicroserviciosexamenes.service.IExamenSevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ExamenController extends CommonController<Examen, IExamenSevice> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
        Examen examenBd;
        Examen examenNew;
        try {
            examenBd = servicio.findById(id);
            examenBd.setNombre(examen.getNombre());
            List<Pregunta> pregEliminadas = new ArrayList<>();
            examenBd.getPreguntas().forEach(pregunta -> {
                if (!(examen.getPreguntas().contains(pregunta))) {
                    pregEliminadas.add(pregunta);
                }
            });
            pregEliminadas.forEach(pregunta -> examenBd.removePregunta(pregunta));
            examenBd.setPreguntas(examen.getPreguntas());

            examenNew = servicio.save(examenBd);
        } catch (DataAccessException ex) {
            response.put("isSuccess", false);
            response.put("message", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause()
                    .getMessage()));

            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("data", examenNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
