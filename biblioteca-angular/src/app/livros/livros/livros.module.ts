import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LivrosRoutingModule } from './livros-routing.module';
import { LivrosComponent } from '../livros.component';
import { DetalhesLivroComponent } from '../detalhes-livro/detalhes-livro.component';
import { LivroFormComponent } from '../../components/funcionarios/livro-form/livro-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppMaterialModule } from 'src/app/shared/app-material/app-material.module';


@NgModule({
  declarations: [
    LivrosComponent,
    DetalhesLivroComponent
  ],
  imports: [
    CommonModule,
    LivrosRoutingModule,
    AppMaterialModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class LivrosModule { }
