package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.PaiementAvecFacture;

public interface PaiementAFactureService {
    
  PaiementAvecFacture annulerPaiementFactures(List<Facture> fact);

  PaiementAvecFacture ajouterPaiement(PaiementAvecFacture p);

  PaiementAvecFacture payerFactures(List<Facture> factures);
}
