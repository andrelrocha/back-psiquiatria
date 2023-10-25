package jr.acens.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jr.acens.api.domain.diretriz.DTO.DiretrizDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaReturnDTO;
import jr.acens.api.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sintomas")
@SecurityRequirement(name = "bearer-key")
public class SintomasController {
    @Autowired
    private SintomaService sintomaService;

    @PostMapping("/admin")
    public ResponseEntity<SintomaReturnDTO> createSintoma(@RequestBody SintomaDTO data) {
        var sintoma = sintomaService.createSintoma(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(sintoma);
    }
}
