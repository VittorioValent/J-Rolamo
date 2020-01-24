import { Component, OnInit } from "@angular/core";
import { UserService } from "./../../../service/user.service";
import { UserDTO } from "./../../../dto/user-dto";
import { TableComponent } from "../../utils/table-component";

@Component({
  selector: "app-users",
  templateUrl: "./user.component.html",
  styleUrls: ["./user.component.css"]
})
export class UserComponent extends TableComponent<UserDTO> implements OnInit {
  constructor(service: UserService) {
    super(service);
  }

  ngOnInit() {
    this.initTable();
  }
}