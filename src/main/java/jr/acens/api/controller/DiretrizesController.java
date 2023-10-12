package jr.acens.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jr.acens.api.domain.diretriz.DTO.DiretrizDTO;
import jr.acens.api.domain.diretriz.DTO.DiretrizReturnDTO;
import jr.acens.api.domain.user.DTO.UserDTO;
import jr.acens.api.domain.user.DTO.UserReturnListDTO;
import jr.acens.api.service.DiretrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{doencas}")
    public ResponseEntity<Page<DiretrizReturnDTO>> listAllDiretrizes(@PathVariable String doencas,
                                                                @RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size,
                                                                @RequestParam(defaultValue = "topico") String sortField,
                                                                @RequestParam(defaultValue = "asc") String sortOrder) {
        var pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
        var pageReturn = diretrizService.getAllDiretrizesByDoenca(pageable, doencas);
        return ResponseEntity.ok(pageReturn);
    }
}
