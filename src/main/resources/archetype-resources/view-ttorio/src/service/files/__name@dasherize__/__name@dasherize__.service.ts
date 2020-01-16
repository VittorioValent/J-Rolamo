import { Injectable } from '@angular/core';
import { AbstractService } from './../abstractservice';
import { <%= classify(name) %>DTO } from '../../dto/<%= dasherize(name) %>-dto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class <%= classify(name) %>Service extends AbstractService<<%= classify(name) %>DTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = '<%= dasherize(name) %>';
  }
}
