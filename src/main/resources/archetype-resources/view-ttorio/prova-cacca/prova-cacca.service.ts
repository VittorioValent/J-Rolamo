import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ProvaCaccaDTO } from 'src/dto/prova-cacca-dto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProvaCaccaService extends AbstractService<ProvaCaccaDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'prova-cacca';
  }
}
