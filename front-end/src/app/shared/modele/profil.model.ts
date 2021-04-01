import { EnumTypeProfil } from './enumTypeProfil.model';
import { UserProfilProjet } from './userProfilProjet.model';

export class Profil {
    id : string;
    type_profil : EnumTypeProfil;
    utilisateursProfilsProjets : Array<UserProfilProjet>;
}