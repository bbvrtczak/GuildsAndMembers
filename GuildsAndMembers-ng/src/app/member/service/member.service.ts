import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Members } from "../model/members";
import { MemberDetails } from "../model/member-details";
import { MemberForm } from "../model/member-form";

/**
 * Member management service. Calls REST endpoints.
 */
@Injectable()
export class MemberService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all members.
   *
   * @return list of members
   */
  getMembers(): Observable<Members> {
    return this.http.get<Members>('/api/members');
  }

  /**
   * Fetches single members.
   *
   * @param uuid member's id
   * @return single members
   */
  getMember(uuid: string): Observable<MemberDetails> {
    return this.http.get<MemberDetails>('/api/members/' + uuid);
  }

  /**
   * Removes single member.
   *
   * @param uuid member's id
   */
  deleteMember(uuid: string): Observable<any> {
    return this.http.delete('/api/members/' + uuid);
  }

  /**
   * Updates single member.
   *
   * @param uuid member's id
   * @param request request body
   */
  putMember(uuid: string, request: MemberForm): Observable<any> {
    return this.http.put('/api/members/' + uuid, request);
  }

}
