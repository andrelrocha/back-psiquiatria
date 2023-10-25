package jr.acens.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jr.acens.api.domain.remedio.DTO.RemedioDTO;
import jr.acens.api.domain.remedio.DTO.RemedioReturnDTO;
import jr.acens.api.domain.remedio.useCase.CreateRemedioUseCase;
import jr.acens.api.domain.remedio.useCase.GetRemediosByClasse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/remedios")
@SecurityRequirement(name = "bearer-key")
public class RemedioController {
    @Autowired
    private GetRemediosByClasse getRemediosByClasse;
    @Autowired
    private CreateRemedioUseCase createRemedioUseCase;

    @GetMapping("/{classesRemedio}")
    public ResponseEntity<Page<RemedioReturnDTO>> getRemediosByClasse(@PathVariable String classesRemedio, @PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        var page = getRemediosByClasse.getRemediosByClasse(pageable, classesRemedio);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity<RemedioReturnDTO> createRemedio(@RequestBody RemedioDTO data) {
        var remedio = createRemedioUseCase.createRemedio(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(remedio);
    }
}
