package jr.acens.api.service;

import jr.acens.api.domain.Doencas;
import jr.acens.api.domain.diretriz.Diretriz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DiretrizService {
    public Page<Diretriz> getAllDiretrizesByDoenca(Pageable pageable, Doencas doenca);
}
