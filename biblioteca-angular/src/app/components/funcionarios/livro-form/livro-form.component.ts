
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LivrosService } from 'src/app/livros/services/livros.service';



@Component({
  selector: 'app-livro-form',
  templateUrl: './livro-form.component.html',
  styleUrls: ['./livro-form.component.css']
})
export class LivroFormComponent implements OnInit {

  @ViewChild("fileUpload", { static: false })
  FileUpload!: ElementRef; files = [];

  form: FormGroup;
  constructor(private formBuilder: FormBuilder,
    private service: LivrosService,
    private snackBar: MatSnackBar) {
    this.form = this.formBuilder.group({

      ISBN:[null],
      nome:[null],
      autor: [null],
      categoria: [null],
      descricao: [null],
      ano: [null],
      imagem: [null]
    });
   }

  ngOnInit(): void {
  }
  onSubmit(){
    this.service.save(this.form.value)
      .subscribe(result => this.onSuccess(), error => this.onError());

    }

  onCancel(){
    console.log('onCancel');
  }

  private onError() {
    this.snackBar.open('Erro ao salvar livro.', '', { duration: 5000 });
  }

  private onSuccess() {
    this.snackBar.open('Livro salvo com sucesso!', '', { duration: 5000 });
    this.onCancel();
  }


}
