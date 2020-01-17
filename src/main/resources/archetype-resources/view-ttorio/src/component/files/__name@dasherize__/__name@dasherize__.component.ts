import { Component, OnInit } from '@angular/core';
import { <%= classify(name) %>Service } from 'src/service/<%= dasherize(name) %>/<%= dasherize(name) %>.service';
import { <%= classify(name) %>DTO } from 'src/dto/<%= dasherize(name) %>/<%= dasherize(name) %>-dto';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';

/**
 * Come ogni componente di CRUD, questa estende la classe AbstractCrudComponent, ereditando tutti i metodi 
 * per le CRUD. Questo ci permette di non riscrivere ogni volta gli stessi metodi e avere meno errori.
 * 
 * @author View-ttorio
 * 
 * @see AbstractCrudComponent
 * 
 */
@Component({
  selector: 'app-<%= classify(name) %>',
  templateUrl: './<%= dasherize(name) %>.component.html',
  styleUrls: ['./<%= dasherize(name) %>.component.css']
})
export class <%= classify(name) %>Component extends AbstractCrudComponent<<%= classify(name) %>DTO> implements OnInit {

  constructor(service: <%= classify(name) %>Service) {
    super(service);
  }

  ngOnInit() {
    this.clear();
    this.getAll();
  }

  clear() {
    this.dto = new <%= classify(name) %>DTO();
  }

  close() {
    this.selected = null;
  }
}
