import {Member} from "../../member/model/member";

/**
 * Represents single guild in list.
 */
export interface GuildDetails {

  /**
   * Unique id identifying guild.
   */
  id: string;

  /**
   * Name of the guild.
   */
  name: string;

  /**
   * Region of the guild.
   */
  region: string;

  /**
   * Creation year of the guild.
   */
  creationYear: number;

  /**
   * List of members.
   */
  members: Member[];

}
