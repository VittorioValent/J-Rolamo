import { Component, OnInit } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { EntityInfoService } from '../../../service/entity-info.service';
import { EntityInfoDTO } from 'src/dto/entity-info-dtot';

@Component({
  selector: 'app-nav-menu',
  templateUrl: './nav-menu.component.html',
  styleUrls: ['./nav-menu.component.css']
})
export class NavMenuComponent implements OnInit{
  
  entities: EntityInfoDTO[] = [];

  ngOnInit(): void {

  }

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver, private service: EntityInfoService) {}

  logout(){
    localStorage.clear();
  }

  getMenuEntities(){
    this.service.getMenuEntities().subscribe(entities=> this.entities = entities);
  }
}
