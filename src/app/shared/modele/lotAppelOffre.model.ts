import { AppelOffre } from './appelOffre.model';
import { EnumTypeLotAppelOffre } from './enumTypeLotAppelOffre.model';
import { Marche } from './marche.model';

export class LotAppelOffre {
    code : string;
    montant : number;
    date_lot : Date;
    type_lot: EnumTypeLotAppelOffre;
    appelOffre : AppelOffre;
    marches : Array<Marche>;

    
}