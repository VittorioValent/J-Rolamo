import { Component, OnInit } from '@angular/core';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  username: string;

  constructor() { }

  ngOnInit() {
    this.username = (JSON.parse(localStorage.getItem('authToken')).username);
  }


}
