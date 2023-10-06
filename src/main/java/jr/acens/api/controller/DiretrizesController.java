package jr.acens.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diretrizes")
@SecurityRequirement(name = "bearer-key")
public class DiretrizesController {


}
