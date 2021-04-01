import { EnumSecteur } from './enumSecteur.model';
import { Projet } from './projet.model';
export class Secteur
{type_secteur : EnumSecteur;
projets : Array<Projet>;
}