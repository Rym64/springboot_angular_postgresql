import { Component, OnInit } from '@angular/core';
import { Decomposition } from '../../../shared/modele/decomposition.model';
import { ActivatedRoute, Router } from '@angular/router';
import pdfMake from 'pdfmake/build/pdfmake';
import pdfFonts from 'pdfmake/build/vfs_fonts';
pdfMake.vfs = pdfFonts.pdfMake.vfs;
import { WebService } from '../../../shared/sevices/web.service';


@Component({
  selector: 'app-rechercher-avancement-marche',
  templateUrl: './rechercher-avancement-marche.component.html',
  styleUrls: ['./rechercher-avancement-marche.component.css']
})



export class RechercherAvancementMarcheComponent implements OnInit {



  decomposition: Decomposition = undefined
  recherche: string
  decompositionsList: Array<Decomposition>



  constructor(private route: ActivatedRoute,private webService: WebService,private router: Router) { }


  ngOnInit() {
    this.recherche = this.route.snapshot.params['recherche'];
    this.webService.rechercher("rechercherFacture",this.recherche).subscribe(res => {
      let response = JSON.parse(JSON.stringify(res))
      this.decompositionsList = response;})
  }



  rechercherAvancementMarche(recherche){
    this.router.navigate(['rechercherAvancementMarche', recherche]); 
  }



  downloadPdf(){

  }

  
  
}

