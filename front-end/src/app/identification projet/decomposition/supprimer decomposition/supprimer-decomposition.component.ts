import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Decomposition } from '../../../shared/modele/decomposition.model';
import { WebService } from '../../../shared/sevices/web.service';



@Component({
  selector: 'app-supprimer-decomposition',
  templateUrl: './supprimer-decomposition.component.html',
  styleUrls: ['./supprimer-decomposition.component.css']
})



export class SupprimerDecompositionComponent implements OnInit {

  private decomposition:Decomposition;
  
  constructor(private webService:WebService,private router:Router) { }

  ngOnInit() {
    this.decomposition=this.webService.getterDecomposition();
  }



  deleteDecomposition(){
  this.webService.deleteDecomposition("supprimerDecomposition", this.decomposition).subscribe(res => {
    let data = JSON.parse(JSON.stringify(res))
    this.router.navigate(['/afficherDecompositions']);
    window.location.href="/afficherDecompositions";
  }, error => {})
}


}
