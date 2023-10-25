package jr.acens.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jr.acens.api.domain.diretriz.DTO.DiretrizDTO;
import jr.acens.api.domain.diretriz.DTO.DiretrizReturnDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaReturnDTO;
import jr.acens.api.domain.sintoma.DTO.SintomaUpdateDTO;
import jr.acens.api.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{doencas}")
    public ResponseEntity<Page<SintomaReturnDTO>> listAllSintomas(@PathVariable String doencas,
                                                                     @RequestParam(defaultValue = "0") int page,
                                                                     @RequestParam(defaultValue = "10") int size,
                                                                     @RequestParam(defaultValue = "id") String sortField,
                                                                     @RequestParam(defaultValue = "asc") String sortOrder) {
        var pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
        var pageReturn = sintomaService.getSintomasByDoenca(pageable, doencas);
        return ResponseEntity.ok(pageReturn);
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity updateSintoma(@RequestBody SintomaUpdateDTO data, @PathVariable Long id) {
        var sintoma = sintomaService.updateSintoma(data, id);
        return ResponseEntity.ok(sintoma);
    }
}
