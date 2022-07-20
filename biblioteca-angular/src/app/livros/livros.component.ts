import { Categoria } from './model/categoria';
import { ActivatedRoute, Router} from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ILivro } from './model/livros';
import { LivrosService } from './services/livros.service';

@Component({
  selector: 'app-livros',
  templateUrl: './livros.component.html',
  styleUrls: ['./livros.component.css']
})
export class LivrosComponent implements OnInit {

     id: number | null = null;
     livros$: Observable<ILivro[]> ;
     categoria: Categoria | undefined;
     livro: ILivro[] | undefined  ;


    constructor(private livrosService: LivrosService,
      private router:Router,
      private route: ActivatedRoute){

    this.livros$ = this.livrosService.list();
   }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      this.id = Number(params.get("id"));
    })
    //this.getProductCategories();

     const livro = this.livrosService.getAll();
  //   this.route.queryParamMap.subscribe(params => {
  //     const descricao = params.get("descricao")?.toLowerCase();

  //     if (descricao) {
  //       this.livro = livro.filter(produto => produto.descricao.toLowerCase().includes(descricao));
  //       return;
  //     }

  //     this.livro = livro;
  //   });
  // }

    // getProjectByName(nome: String) {
    //   return this.livros
    //     .map(livros => livros.filter(proj => proj.name === name));
    // }
  }

  //teste
  onAdd(){
    this.router.navigate([':id'], {relativeTo: this.route});
  }

  getProductCategories() {
    this.livrosService.getProductCategories().subscribe((categoria) =>{
      this.categoria = categoria
    });
 }


}
