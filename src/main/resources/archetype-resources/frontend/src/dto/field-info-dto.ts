import { EntityInfoDTO } from './entity-info-dtot';

export class FieldInfoDTO{
    id:number;

    name:string;

    type:string;

    entityInfo: EntityInfoDTO;

    toDisplay: boolean;
    
    toFilter: boolean;
}