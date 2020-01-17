import { RoleDTO } from "./role-dto";

/**
 * Classe DTO di User. DEVE essere uguale (stesso nome classe, stessi attributi e stessi nomi) a
 * quello nel backend.
 *
 *
 * @author Vittorio Valent
 */
export class UserDTO {
  id: number;

  username: string;

  password: string;

  role: RoleDTO;

  name: string;

  surname: string;

  accountNonExpired: boolean;

  credentialsNonExpired: boolean;

  accountNonLocked: boolean;

  enabled: boolean;
}
