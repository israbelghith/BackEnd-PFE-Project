package com.backend.caisse.serviceImp;

import com.backend.caisse.entities.PaiementSansFacture;
import com.backend.caisse.entities.SessionCaisse;
import com.backend.caisse.repos.PaiementSansFactureRepos;
import com.backend.caisse.service.PaiementSFactureService;
import com.backend.caisse.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaiementSansFactServiceImpl implements PaiementSFactureService {

    @Autowired
    PaiementSansFactureRepos paiementSansFactureRepos;

    @Autowired
    SessionService sessionService;

    @Override
    public PaiementSansFacture saisirAvance(PaiementSansFacture p) {
        p.setEtat("prépayé");
        SessionCaisse session = p.getEncaissement().getSession();
        // session.setMontantSession(montantSession);
        sessionService.modifierSessionParMontantEtNbFacture(session);

        return paiementSansFactureRepos.save(p);
    }

}
