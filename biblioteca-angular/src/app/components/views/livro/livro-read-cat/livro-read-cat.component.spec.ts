import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LivroReadCatComponent } from './livro-read-cat.component';

describe('LivroReadCatComponent', () => {
  let component: LivroReadCatComponent;
  let fixture: ComponentFixture<LivroReadCatComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LivroReadCatComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LivroReadCatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
