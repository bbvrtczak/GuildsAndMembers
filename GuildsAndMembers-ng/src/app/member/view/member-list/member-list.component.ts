import { Component, OnInit } from '@angular/core';
import { MemberService } from "../../service/member.service";
import { Members } from "../../model/members";
import { Member } from "../../model/member";

@Component({
  selector: 'app-member-list',
  templateUrl: './member-list.component.html',
  styleUrls: ['./member-list.component.css']
})
export class MemberListComponent implements OnInit{

  /**
   * @param service members service
   */
  constructor(private service: MemberService) {
  }

  /**
   * Available members.
   */
  members: Members | undefined;

  ngOnInit(): void {
    this.service.getMembers().subscribe(members => this.members = members);
  }

  /**
   * Deletes selected member.
   *
   * @param member member to be removed
   */
  onDelete(member: Member): void {
    this.service.deleteMember(member.id).subscribe(() => this.ngOnInit());
  }

}
