package com.backend.caisse.serviceImp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.backend.caisse.entities.Caissier;
import com.backend.caisse.entities.Client;
import com.backend.caisse.entities.Contrat;
import com.backend.caisse.entities.Encaissement;
import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.Paiement;
import com.backend.caisse.repos.ClientRepository;
import com.backend.caisse.repos.ContratRepository;
import com.backend.caisse.repos.EncaissementRepository;
import com.backend.caisse.repos.FactureRepository;
import com.backend.caisse.repos.PaiementRepository;
import com.backend.caisse.service.EncaissementService;
import com.backend.caisse.service.FactureService;
import com.backend.caisse.service.PaiementService;
import com.backend.caisse.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaiementServiceImpl implements PaiementService {

    @Autowired
    PaiementRepository paiementRepository;


    @Autowired
    EncaissementService encaissementService;


    @Override
    public List<Paiement> ListerPaiements(Long numS) {

        List<Paiement> paiements= new ArrayList<>();
        List<Encaissement> lEncaissements=encaissementService.listerEncaissementsParSession(numS);
        for(Encaissement e: lEncaissements)
        {
            paiements.add(paiementRepository.findByEncaissementIdE(e.getIdE()));
            
        }
        return paiements;
    }

}