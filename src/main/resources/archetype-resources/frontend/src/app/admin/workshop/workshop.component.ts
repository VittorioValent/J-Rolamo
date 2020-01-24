import { Component, OnInit } from '@angular/core';
import { EntityInfoDTO } from 'src/dto/entity-info-dtot';
import { FieldInfoDTO } from 'src/dto/field-info-dto';
import { WorkshopService } from 'src/service/workshop.service';
import { ServiceType } from 'src/dto/service-type';
import { ControllerType } from 'src/dto/controller-type';
import { NgForm, FormBuilder, FormGroup, FormArray } from '@angular/forms';

@Component({
  selector: 'app-workshop',
  templateUrl: './workshop.component.html',
  styleUrls: ['./workshop.component.css']
})
export class WorkshopComponent implements OnInit {

entity: EntityInfoDTO= new EntityInfoDTO();
fields:FieldInfoDTO[] = [];


  constructor(private service: WorkshopService) {
  }
  ngOnInit() {

  }

  addField() {
    this.fields.push(new FieldInfoDTO());
  }

  createEntity(){
    this.entity.fields = this.fields;
    this.service.createEntity(this.entity).subscribe();
  }

}
