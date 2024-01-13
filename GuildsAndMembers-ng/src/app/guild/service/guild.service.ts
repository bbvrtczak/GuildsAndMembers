import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Guilds } from "../model/guilds";
import {GuildDetails} from "../model/guild-details";
import {Members} from "../../member/model/members";

/**
 * Guild management service. Calls REST endpoints.
 */
@Injectable()
export class GuildService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all guilds.
   *
   * @return list of guilds
   */
  getGuilds(): Observable<Guilds> {
    return this.http.get<Guilds>('/api/guilds');
  }

  /**
   * Fetches single guild.
   *
   * @param uuid guild's id
   * @return single guild
   */
  getGuild(uuid: string): Observable<GuildDetails> {
    return this.http.get<GuildDetails>('/api/guilds/' + uuid);
  }

  /**
   * Removes single guild.
   *
   * @param uuid guild's id
   */
  deleteGuild(uuid: string): Observable<any> {
    return this.http.delete('/api/guilds/' + uuid);
  }

  getGuildMembers(uuid: string): Observable<Members>{
    return this.http.get<Members>('api/guilds/' + uuid + '/members')
  }

  deleteMember(uuid: string): Observable<any> {
    return this.http.delete('/api/members/' + uuid);
  }

}
