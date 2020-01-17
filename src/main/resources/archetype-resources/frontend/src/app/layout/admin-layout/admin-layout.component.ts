import { Component, OnInit } from '@angular/core';

/**
 * Questa componente non ha metodi perché è solo un contenitore per le varie componenti del layout.
 * 
 * @author Vittorio Valent
 */
@Component({
  selector: 'app-admin-layout',
  templateUrl: './admin-layout.component.html',
  styleUrls: ['./admin-layout.component.css']
})
export class AdminLayoutComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
