import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/user-dto';

/**
 * Questa component è statica eccetto per il display dell'utente loggato (viene estratto dalla session
 * nel motodo ngOnInit() ). HeaderComponent è uno degli elementi che viene caricato nel Layout.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayout
 */
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username: string;

  constructor() { }

  ngOnInit() {
    this.username = (JSON.parse(localStorage.getItem('authToken')).username);
  }

}
