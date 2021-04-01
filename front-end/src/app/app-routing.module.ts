import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ModifierProjetComponent } from './identification projet/projet/modifier projet/modifier-projet.component';
import { AfficherProjetsComponent } from './identification projet/projet/afficher projets/afficher-projets.component';
import { AjouterProjetComponent } from './identification projet/projet/ajouter projet/ajouter-projet.component';
import { AfficherFinancementsComponent } from './identification projet/source financement/afficher financements/afficher-financements.component';
import { AfficherDecompositionsComponent } from './identification projet/decomposition/afficher decompositions/afficher-decompositions.component';
import { ModifierDecompositionComponent } from './identification projet/decomposition/modifier decomposition/modifier-decomposition.component';
import {AfficherAppelsOffreComponent} from './suivi projet/suivi marche/appel offre/afficher appels offre/afficher-appels-offre.component';
import {AjouterAppelOffreComponent} from './suivi projet/suivi marche/appel offre/ajouter appel offre/ajouter-appel-offre.component';
import {ModifierAppelOffreComponent} from './suivi projet/suivi marche/appel offre/modifier appel offre/modifier-appel-offre.component';
import {AfficherAvancementMarcheComponent} from './suivi projet/suivi avancement marche/afficher avancement marche/afficher-avancement-marche.component';
import { LoginComponent } from './authentification/login/login.component';
import { AjouterUtilisateurComponent } from './authentification/ajouter utilisateur/ajouter-utilisateur.component';
import { ModifierUtilisateurComponent } from './authentification/modifier utilisateur/modifier-utilisateur.component';
import { AfficherUtilisateursComponent } from './authentification/afficher utilisateurs/afficher-utilisateurs.component';
import { ModifierFinancementEtrangerComponent } from './identification projet/source financement/modifier financement etranger/modifier-financement-etranger.component';
import { ModifierAutreFinancementComponent } from './identification projet/source financement/modifier autre financement/modifier-autre-financement.component';
import { AjouterFinancementEtrangerComponent } from './identification projet/source financement/ajouter financement etranger/ajouter-financement-etranger.component';
import { AjouterAutreFinancementComponent } from './identification projet/source financement/ajouter autre financement/ajouter-autre-financement.component';
import { AfficherMarchesComponent } from './suivi projet/suivi marche/marche/afficher marches/afficher-marches.component';
import { AjouterMarcheComponent } from './suivi projet/suivi marche/marche/ajouter marche/ajouter-marche.component';
import { ModifierMarcheComponent } from './suivi projet/suivi marche/marche/modifier marche/modifier-marche.component';
import { AfficherFacturesComponent } from './suivi projet/suivi marche/facture/afficher factures/afficher-factures.component';
import { AjouterFactureComponent } from './suivi projet/suivi marche/facture/ajouter facture/ajouter-facture.component';
import { ModifierFactureComponent } from './suivi projet/suivi marche/facture/modifier facture/modifier-facture.component';
import { DetailsProjetComponent } from './identification projet/projet/details projet/details-projet.component';
import { DetailsFinancementPublicComponent } from './identification projet/source financement/details financement public/details-financement-public.component';
import { DetailsFinancementEtrangerComponent } from './identification projet/source financement/details financement etranger/details-financement-etranger.component';
import { DetailsAutreFinancementComponent } from './identification projet/source financement/details autre financement/details-autre-financement.component';
import { DetailsDecompositionComponent } from './identification projet/decomposition/details decomposition/details-decomposition.component';
import { DetailsAppelOffreComponent } from './suivi projet/suivi marche/appel offre/details appel offre/details-appel-offre.component';
import { DetailsMarcheComponent } from './suivi projet/suivi marche/marche/details marche/details-marche.component';
import { DetailsFactureComponent } from './suivi projet/suivi marche/facture/details facture/details-facture.component';
import { RechercherProjetComponent } from './identification projet/projet/rechercher projet/rechercher-projet.component';
import { RechercherDecompositionComponent } from './identification projet/decomposition/rechercher decomposition/rechercher-decomposition.component';
import { RechercherFinancementEtrangerComponent } from './identification projet/source financement/rechercher financement etranger/rechercher-financement-etranger.component';
import { RechercherAutreFinancementComponent } from './identification projet/source financement/rechercher autre financement/rechercher-autre-financement.component';
import { RechercherAppelOffreComponent } from './suivi projet/suivi marche/appel offre/rechercher appel offre/rechercher-appel-offre.component';
import { RechercherMarcheComponent } from './suivi projet/suivi marche/marche/rechercher marche/rechercher-marche.component';
import { RechercherFactureComponent } from './suivi projet/suivi marche/facture/rechercher facture/rechercher-facture.component';
import { AfficherObjectifsComponent } from './evaluation projet/objectif/afficher objectifs/afficher-objectifs.component';
import { AjouterObjectifComponent } from './evaluation projet/objectif/ajouter objectif/ajouter-objectif.component';
import { ModifierObjectifComponent } from './evaluation projet/objectif/modifier objectif/modifier-objectif.component';
import { DetailsObjectifComponent } from './evaluation projet/objectif/details objectif/details-objectif.component';
import { RechercherObjectifComponent } from './evaluation projet/objectif/rechercher objectif/rechercher-objectif.component';
import { AfficherIndicateursComponent } from './evaluation projet/indicateur/afficher indicateurs/afficher-indicateurs.component';
import { AjouterIndicateurComponent } from './evaluation projet/indicateur/ajouter indicateur/ajouter-indicateur.component';
import { ModifierIndicateurComponent } from './evaluation projet/indicateur/modifier indicateur/modifier-indicateur.component';
import { DetailsIndicateurComponent } from './evaluation projet/indicateur/details indicateur/details-indicateur.component';
import { RechercherIndicateurComponent } from './evaluation projet/indicateur/rechercher indicateur/rechercher-indicateur.component';
import { SupprimerUtilisateurComponent } from './authentification/supprimer utilisateur/supprimer-utilisateur.component';
import { SupprimerIndicateurComponent } from './evaluation projet/indicateur/supprimer indicateur/supprimer-indicateur.component';
import { SupprimerObjectifComponent } from './evaluation projet/objectif/supprimer objectif/supprimer-objectif.component';
import { SupprimerDecompositionComponent } from './identification projet/decomposition/supprimer decomposition/supprimer-decomposition.component';
import { SupprimerProjetComponent } from './identification projet/projet/supprimer projet/supprimer-projet.component';
import { SupprimerFinancementEtrangerComponent } from './identification projet/source financement/supprimer financement etranger/supprimer-financement-etranger.component';
import { SupprimerAutreFinancementComponent } from './identification projet/source financement/supprimer autre financement/supprimer-autre-financement.component';
import { SupprimerAppelOffreComponent } from './suivi projet/suivi marche/appel offre/supprimer appel offre/supprimer-appel-offre.component';
import { SupprimerMarcheComponent } from './suivi projet/suivi marche/marche/supprimer marche/supprimer-marche.component';
import { SupprimerFactureComponent } from './suivi projet/suivi marche/facture/supprimer facture/supprimer-facture.component';
import { RechercherUtilisateurComponent } from './authentification/rechercher utilisateur/rechercher-utilisateur.component';
import { DetailsUtilisateurComponent } from './authentification/details utilisateur/details-utilisateur.component';
import { ModifierFinancementPublicComponent } from './identification projet/source financement/modifier financement public/modifier-financement-public.component';
import { SupprimerFinancementPublicComponent } from './identification projet/source financement/supprimer financement public/supprimer-financement-public.component';
import { AfficherLotsAppelOffreComponent } from './suivi projet/suivi marche/lot appel offre/afficher lots appel offre/afficher-lots-appel-offre.component';
import { AjouterLotAppelOffreComponent } from './suivi projet/suivi marche/lot appel offre/ajouter lot appel offre/ajouter-lot-appel-offre.component';
import { ModifierLotAppelOffreComponent } from './suivi projet/suivi marche/lot appel offre/modifier lot appel offre/modifier-lot-appel-offre.component';
import { RechercherLotAppelOffreComponent } from './suivi projet/suivi marche/lot appel offre/rechercher lot appel offre/rechercher-lot-appel-offre.component';
import { SupprimerLotAppelOffreComponent } from './suivi projet/suivi marche/lot appel offre/supprimer lot appel offre/supprimer-lot-appel-offre.component';
import { DetailsLotAppelOffreComponent } from './suivi projet/suivi marche/lot appel offre/details lot appel offre/details-lot-appel-offre.component';
import { AdminPageComponent } from './admin/admin page/admin-page.component';
import { UpdateComponent } from './admin/update/update.component';
import { DeleteComponent } from './admin/delete/delete.component';
import { AddComponent } from './admin/add/add.component';
import { RechercherComponent } from './admin/rechercher/rechercher.component';
import { AfficherDetailsProjetComponent } from './identification projet/projet/afficher details projet/afficher-details-projet.component';
import { AjouterFinancementPublicComponent } from './identification projet/source financement/ajouter financement public/ajouter-financement-public.component';



const routes: Routes = [
  { path: 'afficherProjets', component: AfficherProjetsComponent },
  { path: 'ajouterProjet', component: AjouterProjetComponent },
  { path: 'modifierProjet', component: ModifierProjetComponent },
  { path: 'afficherFinancements', component: AfficherFinancementsComponent },
  { path: 'modifierFinancementPublic', component: ModifierFinancementPublicComponent },
  { path: 'modifierFinancementEtranger', component: ModifierFinancementEtrangerComponent },
  { path: 'modifierAutreFinancement', component: ModifierAutreFinancementComponent },
  { path: 'ajouterFinancementEtranger', component: AjouterFinancementEtrangerComponent },
  { path: 'ajouterAutreFinancement', component: AjouterAutreFinancementComponent },
  { path: 'afficherDecompositions', component: AfficherDecompositionsComponent },
  { path: 'modifierDecomposition', component: ModifierDecompositionComponent },
  { path: 'ajouterAppelOffre', component: AjouterAppelOffreComponent },
  { path: 'modifierAppelOffre', component: ModifierAppelOffreComponent },
  { path: 'afficherAppelsOffre', component: AfficherAppelsOffreComponent },
  { path: 'afficherAvancementMarche', component: AfficherAvancementMarcheComponent },
  { path: 'login', component: LoginComponent },
  { path: 'ajouterUtilisateur', component: AjouterUtilisateurComponent },
  { path: 'afficherUtilisateurs',component: AfficherUtilisateursComponent},
  { path: 'modifierUtilisateur',component: ModifierUtilisateurComponent},
  { path: 'afficherMarches',component: AfficherMarchesComponent},
  { path: 'ajouterMarche',component: AjouterMarcheComponent},
  { path: 'modifierMarche',component: ModifierMarcheComponent},
  { path: 'afficherFactures',component: AfficherFacturesComponent},
  { path: 'ajouterFacture',component: AjouterFactureComponent},
  { path: 'modifierFacture',component: ModifierFactureComponent},
  { path: 'detailsProjet',component: DetailsProjetComponent},
  { path: 'detailsFinancementPublic',component: DetailsFinancementPublicComponent},
  { path: 'detailsFinancementEtranger',component: DetailsFinancementEtrangerComponent},
  { path: 'detailsAutreFinancement',component: DetailsAutreFinancementComponent},
  { path: 'detailsDecomposition',component: DetailsDecompositionComponent},
  { path: 'detailsAppelOffre',component: DetailsAppelOffreComponent},
  { path: 'detailsMarche',component: DetailsMarcheComponent},
  { path: 'detailsFacture',component: DetailsFactureComponent},
  { path: 'rechercherProjet/:recherche',component: RechercherProjetComponent},
  { path: 'rechercherDecomposition/:recherche',component: RechercherDecompositionComponent},
  { path: 'rechercherFinancementEtranger/:recherche2',component: RechercherFinancementEtrangerComponent},
  { path: 'rechercherAutreFinancement/:recherche3',component: RechercherAutreFinancementComponent},
  { path: 'rechercherAppelOffre/:recherche',component: RechercherAppelOffreComponent},
  { path: 'rechercherMarche/:recherche',component: RechercherMarcheComponent},
  { path: 'rechercherFacture/:recherche',component: RechercherFactureComponent},
  { path: 'afficherObjectifs',component: AfficherObjectifsComponent},
  { path: 'ajouterObjectif',component: AjouterObjectifComponent},
  { path: 'modifierObjectif',component: ModifierObjectifComponent},
  { path: 'detailsObjectif',component: DetailsObjectifComponent},
  { path: 'rechercherObjectif/:recherche',component: RechercherObjectifComponent},
  { path: 'afficherIndicateurs',component: AfficherIndicateursComponent},
  { path: 'ajouterIndicateur',component: AjouterIndicateurComponent},
  { path: 'modifierIndicateur',component: ModifierIndicateurComponent},
  { path: 'detailsIndicateur',component: DetailsIndicateurComponent},
  { path: 'rechercherIndicateur/:recherche',component: RechercherIndicateurComponent},
  { path: 'supprimerUtilisateur',component: SupprimerUtilisateurComponent},
  { path: 'supprimerProjet',component: SupprimerProjetComponent},
  { path: 'supprimerDecomposition',component: SupprimerDecompositionComponent},
  { path: 'supprimerAppelOffre',component: SupprimerAppelOffreComponent},
  { path: 'supprimerFacture',component: SupprimerFactureComponent},
  { path: 'supprimerMarche',component: SupprimerMarcheComponent},
  { path: 'supprimerIndicateur',component: SupprimerIndicateurComponent},
  { path: 'supprimerObjectif',component: SupprimerObjectifComponent},
  { path: 'supprimerFinancementPublic',component: SupprimerFinancementPublicComponent},
  { path: 'supprimerFinancementEtranger',component: SupprimerFinancementEtrangerComponent},
  { path: 'supprimerAutreFinancement',component: SupprimerAutreFinancementComponent},
  { path: 'detailsUtilisateur',component: DetailsUtilisateurComponent},
  { path: 'rechercherUtilisateur/:recherche',component: RechercherUtilisateurComponent},
  { path: 'afficherLotsAppelOffre',component: AfficherLotsAppelOffreComponent},
  { path: 'ajouterLotAppelOffre',component: AjouterLotAppelOffreComponent},
  { path: 'modifierLotAppelOffre',component: ModifierLotAppelOffreComponent},
  { path: 'supprimerLotAppelOffre',component: SupprimerLotAppelOffreComponent},
  { path: 'detailsLotAppelOffre',component: DetailsLotAppelOffreComponent},
  { path: 'rechercherLotAppelOffre/:recherche',component: RechercherLotAppelOffreComponent},
  { path: 'afficherUserProfilProjet',component: AdminPageComponent},
  { path: 'ajouterUserProfilProjet',component: AddComponent},
  { path: 'modifierUserProfilProjet',component: UpdateComponent},
  { path: 'supprimerUserProfilProjet',component: DeleteComponent},
  { path: 'rechercherUtilisateurProfilProjet/:recherche',component: RechercherComponent},
  { path: 'afficherDetailsProjet',component: AfficherDetailsProjetComponent},
  { path: 'ajouterFinancementPublic',component: AjouterFinancementPublicComponent},







];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
