import { Member } from "./member";

/**
 * GET members response. Contains list of available members. Can be used to list particular
 * guild's members as well as all members.
 */
export interface Members {

  /**
   * Name of the selected members.
   */
  members: Member[];

}
