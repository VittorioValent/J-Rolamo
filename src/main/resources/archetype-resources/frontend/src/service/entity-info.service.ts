import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthToken } from '../dto/auth-token';
import { EntityInfoDTO } from 'src/dto/entity-info-dtot';


@Injectable({
  providedIn: 'root'
})
export class EntityInfoService extends AbstractService<EntityInfoDTO> {
  constructor(http: HttpClient) {
    super(http);
    this.type = 'entity-info';
  }
  getMenuEntities(): Observable<EntityInfoDTO[]> {
    return this._http.get<EntityInfoDTO[]>('http://localhost:8081/api/public/entityInfo/menuEntities');
  }
}
