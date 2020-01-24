import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { EntityInfoDTO } from 'src/dto/entity-info-dtot';
import { Observable } from 'rxjs';
import { AbstractService } from './abstractservice';

@Injectable({
  providedIn: 'root'
})
export class WorkshopService extends AbstractService<EntityInfoDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'workshop';
  }
  createEntity(entityInfo: EntityInfoDTO): Observable<any> {
    return this._http.post('http://localhost:' + this.port + '/' + this.type + '/entityflow', entityInfo, { headers: this.getAuthHeaders() });
}

}
