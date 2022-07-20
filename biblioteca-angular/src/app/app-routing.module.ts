import { LivroFormComponent } from './components/funcionarios/livro-form/livro-form.component';
import { LoginComponent } from './components/funcionario/login/login.component';
import { NaoEncontradaComponent } from './components/template/nao-encontrada/nao-encontrada.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoriaReadComponent } from './components/views/categorias/categoria-read/categoria-read.component';
import { LivroReadCatComponent } from './components/views/livro/livro-read-cat/livro-read-cat.component';
import { TodoslivrosComponent } from './components/funcionarios/lista-livros/todoslivros.component';

const routes: Routes = [
{path:'', redirectTo: 'livros', pathMatch:'full'},
{ path: 'livros',
loadChildren: () => import('./livros/livros/livros.module').then(m => m.LivrosModule)},
{path: 'categorias', component: CategoriaReadComponent},
{path: 'login', component: LoginComponent},
{path: 'categorias/:codigo/livros', component: LivroReadCatComponent},
{ path: 'admin', component: TodoslivrosComponent},
{ path: 'admin/new', component: LivroFormComponent},
{path: '**', component: NaoEncontradaComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
