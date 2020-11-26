package pe.tuna.huammicroserviciosexamenes.serviceImpl;

import org.springframework.stereotype.Service;
import pe.tuna.commonsmicroservicios.services.CommonServiceImpl;
import pe.tuna.huammicroserviciosexamenes.models.Examen;
import pe.tuna.huammicroserviciosexamenes.repository.ExamenRepository;
import pe.tuna.huammicroserviciosexamenes.service.IExamenSevice;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository>
        implements IExamenSevice {
}
