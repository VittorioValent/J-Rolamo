import { ServiceType } from "./service-type";
import { ControllerType } from './controller-type';
import { FieldInfoDTO } from './field-info-dto';

export class EntityInfoDTO {
  id: number;

  entityName: string;

  auditable: boolean;

  fields: FieldInfoDTO[];

  serviceType: ServiceType;

  controllerType: ControllerType;
}
