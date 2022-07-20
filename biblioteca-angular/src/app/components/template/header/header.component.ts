import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Component, ViewChild } from '@angular/core';
import { BreakpointObserver, Breakpoints, BreakpointState } from '@angular/cdk/layout';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent{

  @ViewChild('drawer') drawer: { toggle: () => void; } | undefined;
  selected(option: string) {
  // handle it
  this.drawer!.toggle();
  }

  public selectedItem : string = '';
  public isHandset$: Observable<boolean> = this.breakpointObserver
    .observe(Breakpoints.Handset)
    .pipe(map((result: BreakpointState) => result.matches));

  constructor(private breakpointObserver: BreakpointObserver) { }


  }

