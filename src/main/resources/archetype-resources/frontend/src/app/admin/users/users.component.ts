import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/user-dto';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';

/**
 * Come ogni componente di CRUD, questa estende la classe AbstractCrudComponent, ereditando tutti i metodi 
 * per le CRUD. Questo ci permette di non riscrivere ogni volta gli stessi metodi e avere meno errori.
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractCrudComponent
 * 
 */
@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent extends AbstractCrudComponent<UserDTO> implements OnInit {

  constructor(service: UserService) {
    super(service);
  }

  ngOnInit() {
    this.clear();
    this.getAll();
  }

  clear() {
    this.dto = new UserDTO();
  }

  close() {
    this.selected = null;
  }
}
