import { ILivro } from 'src/app/livros/model/livros';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { LivroService } from '../livro.service';

@Component({
  selector: 'app-livro-read-cat',
  templateUrl: './livro-read-cat.component.html',
  styleUrls: ['./livro-read-cat.component.css']
})
export class LivroReadCatComponent implements OnInit {

  codigo: String = "";
  livros: ILivro[] = [];
  livro: ILivro | undefined;

  constructor(private livroservice: LivroService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.codigo = this.route.snapshot.paramMap.get("codigo")!;
    this.findAll();
  }


  findAll(): void {
    this.livroservice.findAllByCategoria(this.codigo).subscribe((resposta) => {
      this.livros = resposta;
      console.log(this.livros);
    });
  }


  readById(): void{
    const codigos = parseInt(this.route.snapshot.paramMap.get('codigos')!, 10);
    this.livroservice.findAllByCategoria("codigos").subscribe(livro => {
       //this.livro = livro;
    });
  }
}
