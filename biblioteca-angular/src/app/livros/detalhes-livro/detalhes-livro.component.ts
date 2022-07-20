import { LivrosService } from './../services/livros.service';
import { ILivro } from './../model/livros';
import { Component, Inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from '../model/categoria';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';




@Component({
  selector: 'app-detalhes-livro',
  templateUrl: './detalhes-livro.component.html',
  styleUrls: ['./detalhes-livro.component.css']
})
export class DetalhesLivroComponent implements OnInit {

  livros$: ILivro | undefined;
  categoria: Categoria | undefined;

  constructor( private livrosService: LivrosService,
    private route: ActivatedRoute,
    private router: Router,
    public dialog: MatDialog){
    }

  ngOnInit(): void {
   this.readById();

  }

  readById(): void{
    const id = parseInt(this.route.snapshot.paramMap.get('id')!, 10);
    this.livrosService.readById(id).subscribe((livros) => {
      this.livros$ = livros;
    });
  }

  // openDialog() {
  //   this.dialog.open(DialogDataExampleDialog, {
  //     data: {
  //       animal: 'panda',
  //     },
  //   });
  // }
}


