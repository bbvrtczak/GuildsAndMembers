import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GuildViewComponent } from './guild-view.component';

describe('GuildViewComponent', () => {
  let component: GuildViewComponent;
  let fixture: ComponentFixture<GuildViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [GuildViewComponent]
    });
    fixture = TestBed.createComponent(GuildViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
