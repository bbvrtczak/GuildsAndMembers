import { Component, OnInit } from '@angular/core';
import { GuildService } from "../../service/guild.service";
import { ActivatedRoute, Router } from "@angular/router";
import { GuildDetails } from "../../model/guild-details";
import {Members} from "../../../member/model/members";

/**
 * Preview of single guild.
 */
@Component({
  selector: 'app-guild-view',
  templateUrl: './guild-view.component.html',
  styleUrls: ['./guild-view.component.css']
})
export class GuildViewComponent implements OnInit {

  /**
   * Single guild.
   */
  guild: GuildDetails | undefined;
  members: Members | undefined;

  /**
   *
   * @param service guild service
   * @param route activated route
   * @param router router
   */
  constructor(private service: GuildService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getGuild(params['uuid'])
        .subscribe(guild => this.guild = guild)
    });

    this.route.params.subscribe(params => {
      this.service.getGuildMembers(params['uuid'])
        .subscribe(members => this.members = members)
    });
  }

  // deleting member
  onDelete(memberId: string): void {
    this.service.deleteMember(memberId).subscribe(() => this.ngOnInit());
  }

}
