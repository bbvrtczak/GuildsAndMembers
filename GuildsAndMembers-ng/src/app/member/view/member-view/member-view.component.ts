import { Component, OnInit } from '@angular/core';
import { MemberService } from "../../service/member.service";
import { ActivatedRoute, Router } from "@angular/router";
import { MemberDetails } from "../../model/member-details";

/**
 * Preview of single member.
 */
@Component({
  selector: 'app-member-view',
  templateUrl: './member-view.component.html',
  styleUrls: ['./member-view.component.css']
})
export class MemberViewComponent implements OnInit {

  /**
   * Single member.
   */
  member: MemberDetails | undefined;

  /**
   *
   * @param service member service
   * @param route activated route
   * @param router router
   */
  constructor(private service: MemberService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getMember(params['uuid'])
        .subscribe(member => this.member = member)
    });
  }

}
