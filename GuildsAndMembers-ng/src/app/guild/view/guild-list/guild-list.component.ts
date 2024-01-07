import { Component, OnInit } from '@angular/core';
import { Guilds } from "../../model/guilds";
import { Guild } from "../../model/guild";
import { GuildService } from "../../service/guild.service";

/**
 * Navigable view with list of all guilds.
 */
@Component({
  selector: 'app-guild-list',
  templateUrl: './guild-list.component.html',
  styleUrls: ['./guild-list.component.css']
})
export class GuildListComponent implements OnInit {

  /**
   * @param service guilds service
   */
  constructor(private service: GuildService) {
  }

  /**
   * Available guilds.
   */
  guilds: Guilds | undefined;

  ngOnInit(): void {
    this.service.getGuilds().subscribe(guilds => this.guilds = guilds);
  }

  /**
   * Deletes selected guild.
   *
   * @param guild guild to be removed
   */
  onDelete(guild: Guild): void {
    this.service.deleteGuild(guild.id).subscribe(() => this.ngOnInit());
  }

}
