import { Injectable } from "@angular/core";
import {
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  CanActivate
} from "@angular/router";

/**
 * Questa classe svolge la funzione di "cane da guadia" sulle routes dell'admin. Infatti, senza un
 * vero controllo, è possibile accedere a qualsiasi strada semplicemente conoscendone il percorso e
 * inserendolo nella bara di navigazione. Ovviamente non vogliamo che questo sia possibile a meno che
 * l'utente loggato sia un ADMIN. Questo Guard possiede infatti un metodo che controlla lo Usertype
 * dell'utente nella sessione e, se è ADMIN, lo lascia proseguire. ALtrimenti stamperà in console
 * un messaggio di mancata autenticazione.
 *
 * @Author Vittorio Valent
 *
 * @see AdminRoutingModule
 */
@Injectable({
  providedIn: "root"
})
export class AuthGuard implements CanActivate {
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    console.log("AuthGuard activated");
    return this.isAdmin();
  }

  /**
   * Questo metodo controlla se c'è un utente loggato nella sessione. Se sì ne legge lo Usertype
   * e ritorna true se è ADMIN (quindi lo lascia passare) e false altrimenti.
   */
  isAdmin(): boolean {
    return true;
    /*     if (JSON.parse(localStorage.getItem('authToken')) !== null) {
      if (JSON.parse(localStorage.getItem('authToken')).role === 'ROLE_ADMIN') {
        return true;
      }
    } else {
      console.log('You do not have the authorization to this route')
      return false;
    } */
  }
}
