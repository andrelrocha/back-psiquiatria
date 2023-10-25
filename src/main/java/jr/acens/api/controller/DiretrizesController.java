package jr.acens.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jr.acens.api.domain.diretriz.DTO.DiretrizDTO;
import jr.acens.api.domain.diretriz.DTO.DiretrizReturnDTO;
import jr.acens.api.domain.diretriz.DTO.UpdateDiretrizDTO;
import jr.acens.api.service.DiretrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/diretrizes")
@SecurityRequirement(name = "bearer-key")
public class DiretrizesController {

    @Autowired
    private DiretrizService diretrizService;

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

    @PostMapping("/suggestion")
    public ResponseEntity<String> suggestDiretriz(@RequestBody DiretrizDTO data) {
        var string = diretrizService.suggestDiretriz(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(string);
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<DiretrizReturnDTO> updateDiretriz(@RequestBody UpdateDiretrizDTO data, @PathVariable Long id) {
        var diretriz = diretrizService.updateDiretriz(data, id);
        return ResponseEntity.ok(diretriz);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity deleteDiretriz(@PathVariable Long id) {
        diretrizService.deleteDiretriz(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/admin/create")
    @Transactional
    public ResponseEntity<DiretrizReturnDTO> createDiretriz(@RequestBody DiretrizDTO data, UriComponentsBuilder uriBuilder) {
        var diretriz = diretrizService.createDiretriz(data);
        var uri = uriBuilder.path("/diretrizes/{titulo}").buildAndExpand(diretriz.titulo()).toUri();
        return ResponseEntity.created(uri).body(diretriz);
    }

    @PostMapping("/admin/confirm/{id}")
    public ResponseEntity<String> confirmDiretriz(@PathVariable Long id) {
        var string = diretrizService.confirmSuggestion(id);
        return ResponseEntity.ok(string);
    }

    @PostMapping("/admin/deny/{id}")
    public ResponseEntity denyDiretriz(@PathVariable Long id) {
        diretrizService.denySuggestion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/admin/suggestiondiretrizes")
    public ResponseEntity getDiretrizesSuggestion(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        var diretrizesNotConfirmed = diretrizService.getDiretrizesSuggestion(pageable);
        return ResponseEntity.ok(diretrizesNotConfirmed);
    }
}
