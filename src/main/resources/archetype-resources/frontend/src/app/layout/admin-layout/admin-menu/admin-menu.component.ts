import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

/**
 * Questa component mostra il menù dell'admin. Le variabibi booleane is***Collasped controllano il
 * display dei sottomenù. I metodi ***collapse() cambiano il valore di queste variabili, il metodo logout
 * cancella la sessione e reindirizza alla pagina di login.
 * 
 * @author Vittorio Valent
 */
@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isAccountCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    this.isUserCollapsed = !this.isUserCollapsed;
  }

  accountcollapse() {
    this.isAccountCollapsed = !this.isAccountCollapsed;
  }
}
