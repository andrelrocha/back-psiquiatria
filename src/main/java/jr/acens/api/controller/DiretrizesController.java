package jr.acens.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jr.acens.api.domain.diretriz.DTO.DiretrizDTO;
import jr.acens.api.domain.diretriz.DTO.DiretrizReturnDTO;
import jr.acens.api.domain.user.DTO.UserDTO;
import jr.acens.api.service.DiretrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/diretrizes")
@SecurityRequirement(name = "bearer-key")
public class DiretrizesController {

    @Autowired
    private DiretrizService diretrizService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<DiretrizReturnDTO> createDiretriz(@RequestBody DiretrizDTO data, UriComponentsBuilder uriBuilder) {
        var diretriz = diretrizService.createDiretriz(data);
        var uri = uriBuilder.path("/diretrizes/{titulo}").buildAndExpand(diretriz.titulo()).toUri();
        return ResponseEntity.created(uri).body(diretriz);
    }
}
