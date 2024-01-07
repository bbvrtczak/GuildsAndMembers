import { Component, OnInit } from '@angular/core';
import { MemberService } from '../../service/member.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MemberForm } from '../../model/member-form';

@Component({
  selector: 'app-member-edit',
  templateUrl: './member-edit.component.html',
  styleUrls: ['./member-edit.component.css']
})
export class MemberEditComponent implements OnInit {

  /**
   * Member's id.
   */
  uuid: string | undefined;

  /**
   * Single member.
   */
  member: MemberForm | undefined;

  /**
   * Single member.
   */
  original: MemberForm | undefined;

  /**
   * @param memberService member service
   * @param route activated route
   * @param router router
   */
  constructor(
    private memberService: MemberService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.memberService.getMember(params['uuid'])
        .subscribe(member => {
          this.uuid = member.id;
          this.member = {
            name: member.name,
            role: member.role,
          };
          this.original = {...this.member};
        });
    });
  }

  /**
   * Updates member.
   */
  onSubmit(): void {
    this.memberService.putMember(this.uuid!, this.member!)
      .subscribe(() => this.router.navigate(['/members']));
  }

}
