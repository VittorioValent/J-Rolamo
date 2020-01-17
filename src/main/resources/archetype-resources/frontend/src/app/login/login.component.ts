import { Component, OnInit } from "@angular/core";
import { LoginDTO } from "src/dto/login-dto";
import { NgForm } from "@angular/forms";
import { UserService } from "src/service/user.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  loginDTO: LoginDTO;

  constructor(private service: UserService, private router: Router) {}

  ngOnInit() {}

  login(f: NgForm): void {
    this.loginDTO = new LoginDTO(f.value.username, f.value.password);

    this.service.login(this.loginDTO).subscribe(authToken => {
      if (authToken != null) {
        localStorage.setItem("authToken", JSON.stringify(authToken));
        switch (authToken.role) {
          case 'ROLE_ADMIN': {
            this.router.navigate(['/admin-dashboard']);
            break;
          }
          case 'ROLE_USER': {
            this.router.navigate(['/user-dashboard']);
            break;
          }
          default:
            this.router.navigate(['/login']);
        }      }
    });
  }
}
