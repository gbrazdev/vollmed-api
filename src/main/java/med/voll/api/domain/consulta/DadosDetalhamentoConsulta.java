package med.voll.api.domain.consulta;


import java.time.LocalDateTime;
import java.util.Date;

public record DadosDetalhamentoConsulta(
        Long id,
        Long idMedico,
        Long idPasciente,
        LocalDateTime data

) {

}

