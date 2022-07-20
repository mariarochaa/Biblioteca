import { TodoslivrosComponent } from './../../components/funcionarios/lista-livros/todoslivros.component';
import { LivroFormComponent } from './../../components/funcionarios/livro-form/livro-form.component';


import { DetalhesLivroComponent } from './../detalhes-livro/detalhes-livro.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LivrosComponent } from '../livros.component';
import { NaoEncontradaComponent } from 'src/app/components/template/nao-encontrada/nao-encontrada.component';

const routes: Routes = [{ path: '', component: LivrosComponent },
{ path: 'admin', component: TodoslivrosComponent },
{ path: 'admin/new', component: LivroFormComponent},
{ path: ':id', component: DetalhesLivroComponent},
{path: '**', component: NaoEncontradaComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LivrosRoutingModule { }
