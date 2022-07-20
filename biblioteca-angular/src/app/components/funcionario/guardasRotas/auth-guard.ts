import { UserserviceService } from '../../funcionarios/userservice.service';

import { Observable } from 'rxjs';

import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router, CanLoad, Route } from '@angular/router';


@Injectable()
export class AuthGuard implements CanActivate, CanLoad {

  constructor(
    private userserviceService: UserserviceService,
    private router: Router
  ) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ) : Observable<boolean> | boolean {

    console.log('AuthGuard');

    return this.verificarAcesso();
  }

  private verificarAcesso(){
    if (this.userserviceService.usuarioEstaAutenticado()){
      return true;
    }

    this.router.navigate(['/login']);

    return false;
  }

  	canLoad(route: Route): Observable<boolean>|Promise<boolean>|boolean {
      console.log('canLoad: verificando se usuário pode carregar o cod módulo');

      return this.verificarAcesso();
    }
}
