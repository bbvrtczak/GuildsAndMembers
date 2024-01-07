import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Guilds } from "../model/guilds";

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
   * Removes single guild.
   *
   * @param uuid guild's id
   */
  deleteGuild(uuid: string): Observable<any> {
    return this.http.delete('/api/guilds/' + uuid);
  }

}
